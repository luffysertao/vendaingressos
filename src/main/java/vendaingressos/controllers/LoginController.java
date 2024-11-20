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

        List<Usuario> admins = repository.carregarAdmins();

        for (Usuario admin : admins) {
            if (admin.getLogin().equals(login) && admin.getSenha().equals(senha)) {
                MainApp.showHomeAdminHome();
                return;
            }
        }

        System.out.println("Login ou senha inválidos para administrador.");
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
