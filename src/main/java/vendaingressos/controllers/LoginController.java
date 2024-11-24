package vendaingressos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vendaingressos.MainApp;
import vendaingressos.models.Usuario;
import vendaingressos.repository.Repository;

import java.io.IOException;
import java.util.List;

public class LoginController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField senhaField;

    private Repository repository;

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
        if (admins.stream().anyMatch(admin -> admin.getLogin().equals(login) && admin.getSenha().equals(senha))) {
            MainApp.showHomeAdmin();
            return;
        }

        // Verifica se o login pertence a um usuário comum
        if (usuarios.stream().anyMatch(usuario -> usuario.getLogin().equals(login) && usuario.getSenha().equals(senha))) {
            MainApp.showHomeUser();
            return;
        }

        // Exibe erro se nenhum login for válido
        ErroController.exibirMensagemErro("Erro de Validação", "Login e/ou senha inválidos.");
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
