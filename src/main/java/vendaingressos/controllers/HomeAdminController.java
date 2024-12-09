package vendaingressos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vendaingressos.MainApp;
import vendaingressos.models.Evento;
import vendaingressos.models.Usuario;
import vendaingressos.repository.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class HomeAdminController {

    //Containers
    @FXML
    private VBox eventosContainer; // Container para eventos
    @FXML
    private VBox usuariosContainer;
    @FXML
    private VBox adminsContainer;
    //--

    //Stacks da Home
    @FXML
    private StackPane stackPaneEventos; // StackPane para exibir eventos
    @FXML
    private StackPane stackPaneUsuarios; // StackPane para exibir usuários
    @FXML
    private StackPane stackPaneAdicionarEventos;
    @FXML
    private StackPane stackPaneAdmins;
    @FXML
    private StackPane stackPaneRemoverEvento;
    //--

    //Buttons
    @FXML
    private Button usuariosButton; // Botão "USUÁRIOS"
    @FXML
    private Button listagemEventos; // Botão "USUÁRIOS"
    @FXML
    private Button adicionarUsuariosButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button adminsButton;
    @FXML
    private Button removerEvento;
    @FXML
    private Button listagemEventosRemove;
    @FXML
    private Button adicionarUsuariosButtonRemove;
    @FXML
    private Button removerEventoHome;
    //--

    //Adicionar Evento
    @FXML
    private TextField nomeEventoNovo;
    @FXML
    private TextField dataEventoNovo;
    @FXML
    private TextField descricaoEventoNovo;
    @FXML
    private TextField assentosEventoNovo;
    @FXML
    private TextField idEventoNovo;
    @FXML
    private TextField idEvento;
    //--

    private final Repository repository;
    private List<Evento> eventos;

    public HomeAdminController() {
        this.repository = new Repository();
        eventos = repository.carregarEventos();
    }

    @FXML
    public void initialize() {
        // Configuração inicial: mostrar eventos e ocultar usuários
        stackPaneEventos.setVisible(true);
        stackPaneUsuarios.setVisible(false);
        stackPaneAdicionarEventos.setVisible(false);
        stackPaneAdmins.setVisible(false);
        stackPaneRemoverEvento.setVisible(false);

        carregarEventos();
        carregarUsuarios();
        carregarAdmins();

        // Configuração do botão "USUÁRIOS"
        usuariosButton.setOnAction(event -> {
            stackPaneUsuarios.setVisible(true); // Mostra a StackPane de usuários
            stackPaneEventos.setVisible(false); // Oculta a StackPane de eventos
            stackPaneAdicionarEventos.setVisible(false);
            stackPaneAdmins.setVisible(false);
            stackPaneRemoverEvento.setVisible(false);
        });

        homeButton.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(true);
            stackPaneAdicionarEventos.setVisible(false);
            stackPaneAdmins.setVisible(false);
            stackPaneRemoverEvento.setVisible(false);
        });

        listagemEventos.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(true);
            stackPaneAdicionarEventos.setVisible(false);
            stackPaneAdmins.setVisible(false);
            stackPaneRemoverEvento.setVisible(false);
        });

        listagemEventosRemove.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(true);
            stackPaneAdicionarEventos.setVisible(false);
            stackPaneAdmins.setVisible(false);
            stackPaneRemoverEvento.setVisible(false);
        });

        adicionarUsuariosButton.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(false);
            stackPaneAdicionarEventos.setVisible(true);
            stackPaneAdmins.setVisible(false);
            stackPaneRemoverEvento.setVisible(false);
        });

        adicionarUsuariosButtonRemove.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(false);
            stackPaneAdicionarEventos.setVisible(true);
            stackPaneAdmins.setVisible(false);
            stackPaneRemoverEvento.setVisible(false);
        });

        adminsButton.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(false);
            stackPaneAdicionarEventos.setVisible(false);
            stackPaneAdmins.setVisible(true);
            stackPaneRemoverEvento.setVisible(false);
        });

        removerEvento.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(false);
            stackPaneAdicionarEventos.setVisible(false);
            stackPaneAdmins.setVisible(false);
            stackPaneRemoverEvento.setVisible(true);
        });

        removerEventoHome.setOnAction(event -> {
            stackPaneUsuarios.setVisible(false);
            stackPaneEventos.setVisible(false);
            stackPaneAdicionarEventos.setVisible(false);
            stackPaneAdmins.setVisible(false);
            stackPaneRemoverEvento.setVisible(true);
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

                    Text id = new Text("ID: " + evento.getId());
                    id.setStyle("-fx-font-size: 14;");

                    vboxEvento.getChildren().addAll(nome, data, ingressos, descricao, id);
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
            System.err.println("Erro ao carregar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void carregarAdmins() {
        try {
            List<Usuario> admins = repository.carregarAdmins();

            adminsContainer.getChildren().clear();

            for (Usuario admin : admins) {
                if (admin != null) {
                    VBox vboxUsuario= new VBox();
                    vboxUsuario.setSpacing(10);
                    vboxUsuario.setStyle(
                            "-fx-padding: 10; -fx-background-color: #ffffff; -fx-border-color: #c1c1c1; -fx-border-radius: 10; -fx-background-radius: 10;");

                    Text login = new Text("Login: " + admin.getNome());
                    login.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");

                    Text senha = new Text("Senha: " + admin.getSenha());
                    senha.setStyle("-fx-font-size: 14;");

                    Text nome = new Text("Nome: " + admin.getNome());
                    nome.setStyle("-fx-font-size: 14;");

                    Text cpf = new Text("CPF: " + admin.getCpf());
                    cpf.setStyle("-fx-font-size: 14;");

                    Text email = new Text("Email: " + admin.getEmail());
                    email.setStyle("-fx-font-size: 14;");

                    vboxUsuario.getChildren().addAll(login, senha, nome, cpf, email);
                    adminsContainer.getChildren().add(vboxUsuario);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar admins: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Date converterStringParaDate(String dataString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            return dateFormat.parse(dataString);
        } catch (Exception e) {
            return null;
        }
    }


    public static ArrayList<String> converterStringParaArrayList(String assentosString) {
        try {
            String[] assentosArray = assentosString.split(","); // Dividir por vírgulas
            return new ArrayList<>(Arrays.asList(assentosArray));
        } catch (Exception e) {
            return null; // Retorna null em caso de erro
        }
    }

    @FXML
    public void criarEvento() {
        String nome = nomeEventoNovo.getText();
        String dataString = dataEventoNovo.getText();
        String descricao = descricaoEventoNovo.getText();
        String assentosString = assentosEventoNovo.getText();
        String id = idEventoNovo.getText();

        if (nome.isEmpty() || dataString.isEmpty() || descricao.isEmpty() || assentosString.isEmpty() || id.isEmpty()) {
            ErroController.exibirMensagemErro("Erro de Validação", "Todos os campos devem ser preenchidos.");
            return;
        }

        Date data = converterStringParaDate(dataString);
        if (data == null) {
            ErroController.exibirMensagemErro("Erro de Formato", "A data deve estar no formato dd/MM/yyyy.");
            return;
        }

        ArrayList<String> assentos = converterStringParaArrayList(assentosString);
        if (assentos == null || assentos.isEmpty()) {
            ErroController.exibirMensagemErro("Erro de Formato", "Os assentos devem ser separados por vírgulas (Ex.: A1,B2,C3).");
            return;
        }

        // Verifica se já existe um evento com o mesmo ID
        for (Evento eventoExistente : eventos) {
            if (eventoExistente.getId().equals(id)) {
                ErroController.exibirMensagemErro("Erro de ID", "Já existe um evento com o ID fornecido.");
                return;
            }
        }

        Evento evento = new Evento(nome, descricao, data, id);
        evento.setAssentos(assentos);

        eventos.add(evento);
        repository.salvarEventos(eventos);

        carregarEventos();

        List<Evento> eventosCarregados = repository.carregarEventos();
        eventosCarregados.forEach(System.out::println);
    }

    public void removerEvento() {
        String id = idEvento.getText();

        try {
            List<Evento> eventos = repository.carregarEventos();

            for (Evento evento : eventos) {
                if (evento != null && evento.getId().equals(id)) {
                    eventos.remove(evento);
                    System.out.println("Evento removido com sucesso!");

                    repository.salvarEventos(eventos);
                    carregarEventos();
                    return;
                }
            }

            ErroController.exibirMensagemErro("Erro de Validação", "Evento com ID " + id + " não encontrado.");

        } catch (Exception e) {
            System.err.println("Erro ao remover evento: " + e.getMessage());
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
