package vendaingressos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vendaingressos.MainApp;
import vendaingressos.models.Usuario;
import vendaingressos.repository.Repository;

import java.io.IOException;
import java.util.List;

public class RegisterController {

    @FXML
    private TextField nomeField;
    @FXML
    private TextField loginField;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField senhaField;

    private Repository repository;
    private List<Usuario> usuarios;

    public void initialize() {
        repository = new Repository();
    }

    @FXML
    public void handleRegister() {
        String nome = nomeField.getText();
        String login = loginField.getText();
        String cpf = cpfField.getText();
        String email = emailField.getText();
        String senha = senhaField.getText();

        Usuario usuario = new Usuario(nome, login, cpf, email, senha);

        // Adiciona o novo usuário à lista e salva no arquivo
        usuarios.add(usuario);
        repository.salvarUsuarios(usuarios);

        System.out.println("Usuário registrado com sucesso!");
    }

    @FXML
    private void goLogin() {
        try {
            MainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
