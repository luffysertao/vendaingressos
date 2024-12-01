package vendaingressos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import vendaingressos.MainApp;
import vendaingressos.models.Evento;
import vendaingressos.models.Ingresso;
import vendaingressos.models.*;
import vendaingressos.repository.Repository;


import java.io.IOException;
import java.util.List;
import java.text.SimpleDateFormat;

public class HomeUserController {

    //Containers
    @FXML
    private VBox eventosContainer; // Container para eventos
    //--

    //Stacks da Home
    @FXML
    private StackPane stackPaneEventos; // StackPane para exibir eventos
    @FXML
    private StackPane stackPaneFeedbacksEventos; // StackPane para exibir usuários
    @FXML
    private StackPane stackPaneSelecionarIngresso;
    @FXML
    private StackPane stackPaneComprarIngresso;
    @FXML
    private StackPane ingressosComprados;
    //--

    //Buttons
    @FXML
    private Button homeButton;
    @FXML
    private Button comprarIngresso;
    @FXML
    private Button listagemEventos;
    @FXML
    private Button listagemEventosRemove;
    @FXML
    private Button feedbackButton1;
    @FXML
    private Button feedbackButton2;
    @FXML
    private Button feedbackButton3;
    @FXML
    private Button comprarIngressoFeedback;
    @FXML
    private Button ingressosButton;

    //Adicionar Evento
    @FXML
    private TextField nomeCartaoCompra;
    @FXML
    private TextField cpfCompra;
    @FXML
    private TextField validadeCartaoCompra;
    @FXML
    private TextField numeroCartaoCompra;
    @FXML
    private TextField cvvCartaoCompra;
    @FXML
    private TextField assentoDesejadoCompra;
    @FXML
    private TextField idEvento;
    //--

    private final Repository repository;
    private List<Evento> eventos;
    private List<Usuario> usuarios;

    public HomeUserController() {
        this.repository = new Repository();
        eventos = repository.carregarEventos();
    }

    @FXML
    public void initialize() {

        usuarios = repository.carregarUsuarios();
        stackPaneEventos.setVisible(true);
        stackPaneComprarIngresso.setVisible(false);
        stackPaneFeedbacksEventos.setVisible(false);
        stackPaneSelecionarIngresso.setVisible(false);
        ingressosComprados.setVisible(false);

        carregarEventos();

        homeButton.setOnAction(event -> {
            stackPaneEventos.setVisible(true);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);
            ingressosComprados.setVisible(false);
        });

        comprarIngresso.setOnAction(event -> {
            stackPaneEventos.setVisible(false);
            stackPaneSelecionarIngresso.setVisible(true);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);
            ingressosComprados.setVisible(false);
        });

        listagemEventos.setOnAction(event -> {
            stackPaneEventos.setVisible(true);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);
            ingressosComprados.setVisible(false);
        });

        listagemEventosRemove.setOnAction(event -> {
            stackPaneEventos.setVisible(true);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);
            ingressosComprados.setVisible(false);
        });

        feedbackButton1.setOnAction(event -> {
            stackPaneEventos.setVisible(false);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(true);
            ingressosComprados.setVisible(false);
        });

        feedbackButton2.setOnAction(event -> {
            stackPaneEventos.setVisible(false);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(true);
            ingressosComprados.setVisible(false);
        });

        feedbackButton3.setOnAction(event -> {
            stackPaneEventos.setVisible(false);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(true);
            ingressosComprados.setVisible(false);
        });

        comprarIngressoFeedback.setOnAction(event -> {
            stackPaneEventos.setVisible(true);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);
            ingressosComprados.setVisible(false);
        });

        comprarIngressoFeedback.setOnAction(event -> {
            stackPaneEventos.setVisible(true);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);
            ingressosComprados.setVisible(false);
        });

        ingressosButton.setOnAction(event -> {
            stackPaneEventos.setVisible(false);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);
            ingressosComprados.setVisible(true);
        });

    }

    public void selecionarEvento(){
        String id = idEvento.getText();
        try {
            List<Evento> eventos = repository.carregarEventos();
            boolean eventoEncontrado = false;

            for (Evento evento : eventos) {
                if (evento != null && evento.getId().equals(id)) {
                    eventoEncontrado = true;
                    break;
                }
            }
            if (!eventoEncontrado) {
                ErroController.exibirMensagemErro("Erro de Validação", "Evento com ID " + id + " não encontrado.");
                return; // Sai do método para evitar execução posterior
            }
        } catch (Exception e) {
            e.printStackTrace();
            return; // Sai do método se ocorrer uma exceção
        }

        stackPaneEventos.setVisible(false);
        stackPaneSelecionarIngresso.setVisible(false);
        stackPaneComprarIngresso.setVisible(true);
        stackPaneFeedbacksEventos.setVisible(false);
    }

    public void metodoPagamento() {
        // Captura os dados do formulário
        String nome = nomeCartaoCompra.getText();
        String cpf = cpfCompra.getText();
        String validade = validadeCartaoCompra.getText();
        String numero = numeroCartaoCompra.getText();
        String cvv = cvvCartaoCompra.getText();
        String assentoDes = assentoDesejadoCompra.getText();
        String id = idEvento.getText();

        // Valida os campos obrigatórios
        if (nome.isEmpty() || cpf.isEmpty() || validade.isEmpty() || numero.isEmpty() || cvv.isEmpty() || assentoDes.isEmpty()) {
            ErroController.exibirMensagemErro("Erro de Validação", "Todos os campos devem ser preenchidos.");
            return;
        }

        // Pagamento
        Pagamento pagamento = new Pagamento(
                "Cartão de Crédito", // Tipo de pagamento
                nome,                // Nome do titular
                cpf,                 // CPF        // Email (opcional)
                numero,              // Número do cartão
                validade,            // Validade do cartão
                cvv                 // Código de segurança
        );
        if (!pagamento.validarCartao()) {
            ErroController.exibirMensagemErro("Erro de Validação", "Os dados do cartão de crédito são inválidos.");
            return;
        }


        // Carrega eventos e encontra o evento correspondente
        Evento eventoIngresso = null;
        List<Evento> eventos = repository.carregarEventos();
        for (Evento evento : eventos) {
            if (evento != null && evento.getId().equals(id)) {
                eventoIngresso = evento;
                break;
            }
        }
        if (eventoIngresso == null) {
            ErroController.exibirMensagemErro("Erro de Validação", "Evento não encontrado. Verifique o ID do evento.");
            return;
        }

        // Assentos
        List<String> assentos = eventoIngresso.getAssentosDisponiveis();
        if (!assentos.contains(assentoDes)) {
            ErroController.exibirMensagemErro("Erro de Validação", "O assento desejado não está disponível.");
            return;
        }

        // Gera um preço aleatório entre R$50.00 e R$200.00
        double precoAleatorio = 50.0 + (Math.random() * (200.0 - 50.0));

        // Associa o pagamento ao usuário e adiciona o ingresso
        Usuario usuario = LoginController.getUsuarioAtual(); // Obtém o usuário logado
        if (usuario != null) {
            // Atualiza os dados do usuário logado
            usuario.adicionarPagamento(pagamento);
            System.out.println("Pagamento adicionado com sucesso!");
            Ingresso ingresso = new Ingresso(eventoIngresso, precoAleatorio, assentoDes);
            usuario.adicionarIngresso(ingresso);
            System.out.println("Ingresso adicionado com sucesso!");

            // Atualiza a lista de usuários, substituindo o usuário existente
            boolean usuarioAtualizado = false;
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getCpf().equals(usuario.getCpf())) { // Comparação pelo CPF como identificador único
                    usuarios.set(i, usuario); // Substitui o usuário na lista
                    usuarioAtualizado = true;
                    break;
                }
            }

            if (!usuarioAtualizado) {
                // Caso o usuário não seja encontrado (o que não deveria acontecer)
                usuarios.add(usuario);
            }

            // Salva a lista de usuários atualizada no JSON
            repository.salvarUsuarios(usuarios);

            // Alteração de telas (mantém o fluxo original)
            stackPaneEventos.setVisible(true);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);

            System.out.println("Dados salvos com sucesso!");
        } else {
            ErroController.exibirMensagemErro("Erro de Validação", "Usuário não encontrado. Por favor, faça login.");
        }

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

    @FXML
    private void goLogin(){
        try {
            MainApp.showLoginScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}