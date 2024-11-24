package vendaingressos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vendaingressos.MainApp;
import vendaingressos.models.Usuario;
import vendaingressos.repository.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
    @FXML
    private PasswordField confirmPasswordField;

    private Repository repository;
    private List<Usuario> usuarios;

    public void initialize() {
        repository = new Repository();
        usuarios = repository.carregarUsuarios();
    }
    
    @FXML
    public void handleRegister() {
        String nome = nomeField.getText();
        String login = loginField.getText();
        String cpf = cpfField.getText();
        String email = emailField.getText();
        String senha = senhaField.getText();
        String confirmarSenha = confirmPasswordField.getText();

        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (usuarios.stream().anyMatch(usuario ->
                        usuario.getLogin().equals(login) ||
                        usuario.getEmail().equals(email) ||
                        usuario.getCpf().equals(cpf))) {
            ErroController.exibirMensagemErro("Erro de Validação", "Login, e-mail ou CPF já cadastrado.");
        } else if (email.isEmpty()) {
            ErroController.exibirMensagemErro("Erro de Validação", "O campo de e-mail não pode estar vazio.");
        } else if (!email.matches(regexEmail)) {
            ErroController.exibirMensagemErro("Erro de Validação", "O e-mail fornecido é inválido. Use o formato exemplo@dominio.com.");
        } else if (!Objects.equals(confirmarSenha, senha)){
            ErroController.exibirMensagemErro("Erro de Validação", "Senhas diferente");
        }
        else{

        Usuario usuario = new Usuario(nome, login, cpf, email, senha);

        usuarios.add(usuario);
        repository.salvarUsuarios(usuarios);

        //Testar ver se ta tudo ok
        List<Usuario> usuariosCarregados = repository.carregarUsuarios();
        usuariosCarregados.forEach(System.out::println);

        try {
            MainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
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
