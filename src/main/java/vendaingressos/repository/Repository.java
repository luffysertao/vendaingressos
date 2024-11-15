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
import vendaingressos.models.Usuario;

public class Repository {

    private static final String FILE_USUARIOS = "src/main/java/vendaingressos/repository/usuarios.json";

    private final Gson gson;

    public Repository() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
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
}
