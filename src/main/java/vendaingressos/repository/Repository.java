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

import vendaingressos.*;
import vendaingressos.models.Usuario;

public class Repository {

    private static final String FILE_USUARIOS = "repository/usuarios.json";
//    private static final String FILE_VENDAS = "src/dados/vendas.json";
//    private static final String FILE_FEEDBACK = "src/dados/feedbacks.json";
//    private static final String FILE_CONFIRMACAO_COMPRA = "src/dados/confirmacaoCompra.json";

    private final Gson gson;

    public Repository() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    private <T> void salvarDados(List<T> dados, String filePath){
        String json = gson.toJson(dados);
        File file = new File(filePath);
        try{
            if(file.createNewFile()){

            }
            try(FileWriter fileWriter = new FileWriter(file)){
                fileWriter.write(json);
                fileWriter.flush();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private <T> List<T> carregarDados(String filePath, Type typeOfT){
        List<T> dados = new ArrayList<>();
        try{
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            dados = gson.fromJson(content, typeOfT);
        } catch (IOException e){
            e.printStackTrace();
        }
        return dados;
    }

    //Usuarios
    public void salvarUsuarios(List<Usuario> usuarios){
        salvarDados(usuarios, FILE_USUARIOS);
    }

//    public List<Usuario> carregarUsuarios(){
//        Type usuarioListType = new TypeToken<ArrayList<Usuario>>() {}.getType();
//        return carregarDados(FILE_USUARIOS, usuarioListType);
//    }

//    //Vendas
//    public void salvarVendas(List<Compra> compras) {
//        salvarDados(compras, FILE_VENDAS);
//    }
//
//    public List<Compra> carregarVendas() {
//        Type compraListType = new TypeToken<ArrayList<Compra>>() {}.getType();
//        return carregarDados(FILE_VENDAS, compraListType);
//    }
//
//    //Feedback
//    public void salvarFeedbacks(List<Feedback> feedbacks){
//        salvarDados(feedbacks, FILE_FEEDBACK);
//    }
//    public List<Feedback> carregarFeedback(){
//        Type feedbackListType = new TypeToken<ArrayList<Feedback>>() {}.getType();
//        return carregarDados(FILE_FEEDBACK, feedbackListType);
//    }
//
//    //Confirmar Compra
//    public void confirmarCompraEmail(Compra compra) {
//        // Criar um objeto que contém os dados desejados
//        Confirmation confirmation = new Confirmation(
//                compra.getUsuario(),
//                compra.getEvento(),
//                "Parabéns! Ingresso comprado com sucesso, bom evento :)"
//        );
//
//        // Salvar o objeto de confirmação em um JSON
//        List<Confirmation> confirmations = new ArrayList<>();
//        confirmations.add(confirmation);
//        salvarDados(confirmations, FILE_CONFIRMACAO_COMPRA);
//    }
//
//    // Classe interna para a confirmação
//    private class Confirmation {
//        private Usuario usuario;
//        private Evento evento;
//        private String mensagem;
//
//        public Confirmation(Usuario usuario, Evento evento, String mensagem) {
//            this.usuario = usuario;
//            this.evento = evento;
//            this.mensagem = mensagem;
//        }
//    }
//
//
//    public List<Usuario> carregarConfirmacao(){
//        Type usuarioListType = new TypeToken<ArrayList<Usuario>>() {}.getType();
//        return carregarDados(FILE_CONFIRMACAO_COMPRA, usuarioListType);
//    }
}

