package vendaingressos.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import vendaingressos.models.*;

public class Repository {

    private static final String FILE_USUARIOS = "src/main/java/vendaingressos/repository/usuarios.json";
    private static final String FILE_ADMINS = "src/main/java/vendaingressos/repository/admins.json";
    private static final String FILE_EVENTOS = "src/main/java/vendaingressos/repository/eventos.json";

    private final Gson gson;

    public Repository() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("dd/MM/yyyy")
                .create();
    }


    private <T> void salvarDados(List<T> dados, String filePath) {
        String json = gson.toJson(dados);
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("Arquivo criado: " + filePath);
            }
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(json);
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> List<T> carregarDados(String filePath, Type typeOfT) {
        List<T> dados = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                salvarDados(dados, filePath);
                return dados;
            }
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            if (!content.isEmpty()) {
                dados = gson.fromJson(content, typeOfT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }

    // Usuários
    public void salvarUsuarios(List<Usuario> usuarios) {
        salvarDados(usuarios, FILE_USUARIOS);
    }

    public List<Usuario> carregarUsuarios() {
        Type usuarioListType = new TypeToken<ArrayList<Usuario>>() {}.getType();
        return carregarDados(FILE_USUARIOS, usuarioListType);
    }

    // Admins
    public void salvarAdmins(List<Usuario> usuarios) {
        salvarDados(usuarios, FILE_ADMINS);
    }

    public List<Usuario> carregarAdmins() {
        Type usuarioListType = new TypeToken<ArrayList<Usuario>>() {}.getType();
        return carregarDados(FILE_ADMINS, usuarioListType);
    }

    // Eventos
    public void salvarEventos(List<Evento> eventos) {
        if (eventos == null || eventos.isEmpty()) {
            System.out.println("Lista de eventos vazia ou nula");
            return;
        }
        System.out.println("Salvando eventos");
        salvarDados(eventos, FILE_EVENTOS);
    }


    public List<Evento> carregarEventos() {
        Type eventosListType = new TypeToken<ArrayList<Evento>>() {}.getType();
        return carregarDados(FILE_EVENTOS, eventosListType);
    }
}

/*******************************
 Autor: Felipe Amorim do Carmo Silva
 Componente Curricular: EXA863 - MI - PROGRAMAÇÃO
 Concluído em: 01/12/2024
 Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ********************************/