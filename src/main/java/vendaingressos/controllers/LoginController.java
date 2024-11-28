package vendaingressos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vendaingressos.MainApp;
import vendaingressos.models.*;
import vendaingressos.repository.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField senhaField;

    private Repository repository;

    private static Usuario usuarioAtual;

    public LoginController() {
        this.repository = new Repository();
    }

    @FXML
    public void handleLogin() throws IOException {
        String login = loginField.getText();
        String senha = senhaField.getText();

        // Carrega listas de usuários e administradores
        List<Usuario> usuarios = repository.carregarUsuarios();
        List<Usuario> admins = repository.carregarAdmins();

        // Verifica se o login pertence a um administrador
        for (Usuario admin : admins) {
            if (admin.getLogin().equals(login) && admin.getSenha().equals(senha)) {
                usuarioAtual = admin; // Salva o administrador na variável
                MainApp.showHomeAdmin();
                return;
            }
        }

        // Verifica se o login pertence a um usuário comum
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioAtual = usuario; // Salva o usuário na variável
                MainApp.showHomeUser();
                return;
            }
        }

        // Exibe erro se nenhum login for válido
        ErroController.exibirMensagemErro("Erro de Validação", "Login e/ou senha inválidos.");
    }

    public static Usuario getUsuarioAtual() {
        if (usuarioAtual == null) {
            throw new IllegalStateException("Nenhum usuário está autenticado no momento.");
        }
        if(usuarioAtual.getPagamentos() == null){
            usuarioAtual.pagamentos = new ArrayList<>();
        }
        if(usuarioAtual.getIngressos() == null){
            usuarioAtual.ingressos = new ArrayList<>();
        }
        return usuarioAtual;
    }


    @FXML
    private void goRegister() {
        try {
            MainApp.showRegisterScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
