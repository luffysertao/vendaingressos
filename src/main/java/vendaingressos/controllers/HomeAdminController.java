package vendaingressos.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vendaingressos.MainApp;
import vendaingressos.models.Evento;
import vendaingressos.models.Usuario;
import vendaingressos.repository.Repository;

import java.io.IOException;
import java.util.List;
import java.text.SimpleDateFormat;

public class HomeAdminController {

    @FXML
    private VBox eventosContainer; // Container para eventos

    @FXML
    private VBox usuariosContainer;

    @FXML
    private StackPane stackPaneEventos; // StackPane para exibir eventos

    @FXML
    private StackPane stackPaneUsuarios; // StackPane para exibir usuários

    @FXML
    private Button usuariosButton; // Botão "USUÁRIOS"

    @FXML
    private Button homeButton;

    private final Repository repository;

    public HomeAdminController() {
        this.repository = new Repository();
    }

    @FXML
    public void initialize() {
        // Configuração inicial: mostrar eventos e ocultar usuários
        stackPaneEventos.setVisible(true);
        stackPaneUsuarios.setVisible(false);

        carregarEventos();
        carregarUsuarios();

        // Configuração do botão "USUÁRIOS"
        usuariosButton.setOnAction(event -> {
            stackPaneUsuarios.setVisible(true); // Mostra a StackPane de usuários
            stackPaneEventos.setVisible(false); // Oculta a StackPane de eventos
        });

        homeButton.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(true);
        });
    }

    private void carregarEventos() {
        try {
            List<Evento> eventos = repository.carregarEventos();

            eventosContainer.getChildren().clear();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            for (Evento evento : eventos) {
                if (evento != null) {
                    VBox vboxEvento = new VBox();
                    vboxEvento.setSpacing(10);
                    vboxEvento.setStyle(
                            "-fx-padding: 10; -fx-background-color: #ffffff; -fx-border-color: #c1c1c1; -fx-border-radius: 10; -fx-background-radius: 10;");

                    Text nome = new Text("Nome: " + evento.getNome());
                    nome.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");

                    String dataFormatada = dateFormat.format(evento.getData());
                    Text data = new Text("Data: " + dataFormatada);
                    data.setStyle("-fx-font-size: 14;");

                    int quantidadeIngressos = evento.getAssentos().size();
                    Text ingressos = new Text("Ingressos disponíveis: " + quantidadeIngressos);
                    ingressos.setStyle("-fx-font-size: 14;");

                    Text descricao = new Text("Descrição: " + evento.getDescricao());
                    descricao.setStyle("-fx-font-size: 14;");

                    vboxEvento.getChildren().addAll(nome, data, ingressos, descricao);
                    eventosContainer.getChildren().add(vboxEvento);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar eventos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void carregarUsuarios() {
        try {
            List<Usuario> usuarios = repository.carregarUsuarios();

            usuariosContainer.getChildren().clear();


            for (Usuario usuario : usuarios) {
                if (usuario != null) {
                    VBox vboxUsuario= new VBox();
                    vboxUsuario.setSpacing(10);
                    vboxUsuario.setStyle(
                            "-fx-padding: 10; -fx-background-color: #ffffff; -fx-border-color: #c1c1c1; -fx-border-radius: 10; -fx-background-radius: 10;");

                    Text login = new Text("Login: " + usuario.getNome());
                    login.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");

                    Text senha = new Text("Senha: " + usuario.getSenha());
                    senha.setStyle("-fx-font-size: 14;");

                    Text nome = new Text("Nome: " + usuario.getNome());
                    nome.setStyle("-fx-font-size: 14;");

                    Text cpf = new Text("CPF: " + usuario.getCpf());
                    cpf.setStyle("-fx-font-size: 14;");

                    Text email = new Text("Email: " + usuario.getEmail());
                    email.setStyle("-fx-font-size: 14;");

                    vboxUsuario.getChildren().addAll(login, senha, nome, cpf, email);
                    usuariosContainer.getChildren().add(vboxUsuario);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar eventos: " + e.getMessage());
            e.printStackTrace();
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
