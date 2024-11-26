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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    //--

    //Buttons
    @FXML
    private Button homeButton;
    @FXML
    private Button comprarIngresso;
    @FXML
    private Button selecionarButton;

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

    public HomeUserController() {
        this.repository = new Repository();
        eventos = repository.carregarEventos();
    }

    @FXML
    public void initialize() {
        stackPaneEventos.setVisible(true);
        stackPaneComprarIngresso.setVisible(false);
        stackPaneFeedbacksEventos.setVisible(false);
        stackPaneSelecionarIngresso.setVisible(false);

        carregarEventos();

        homeButton.setOnAction(event -> {
            stackPaneEventos.setVisible(true);
            stackPaneSelecionarIngresso.setVisible(false);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);

        });

        comprarIngresso.setOnAction(event -> {
            stackPaneEventos.setVisible(false);
            stackPaneSelecionarIngresso.setVisible(true);
            stackPaneComprarIngresso.setVisible(false);
            stackPaneFeedbacksEventos.setVisible(false);
        });

        selecionarButton.setOnAction(event -> {
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
            this.metodoPagamento();
            stackPaneFeedbacksEventos.setVisible(false);
        });
    }

    public void metodoPagamento() {
        // Captura os dados do formulário
        String nome = nomeCartaoCompra.getText();
        String cpf = cpfCompra.getText();
        String validade = validadeCartaoCompra.getText();
        String numero = numeroCartaoCompra.getText();
        String cvv = cvvCartaoCompra.getText();
        String assento = assentoDesejadoCompra.getText();
        String id = idEvento.getText();

        // Valida os campos obrigatórios
        if (nome.isEmpty() || cpf.isEmpty() || validade.isEmpty() || numero.isEmpty() || cvv.isEmpty() || assento.isEmpty()) {
            ErroController.exibirMensagemErro("Erro de Validação", "Todos os campos devem ser preenchidos.");
            return;
        }

        // Cria o pagamento
        Pagamento pagamento = new Pagamento(
                "Cartão de Crédito", // Tipo de pagamento
                nome,                // Nome do titular
                cpf,                 // CPF
                null,                // Email (opcional)
                numero,              // Número do cartão
                validade,            // Validade do cartão
                cvv                 // Código de segurança
        );

        // Valida os dados do pagamento
        if (!pagamento.validarCartao()) {
            System.out.println("Os dados do cartão de crédito são inválidos.");
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
            System.out.println("Evento não encontrado. Verifique o ID do evento.");
            return;
        }

        // Gera um preço aleatório entre R$50.00 e R$200.00
        double precoAleatorio = 50.0 + (Math.random() * (200.0 - 50.0));

        // Associa o pagamento ao usuário e adiciona o ingresso
        Usuario usuario = LoginController.getUsuarioAtual(); // Método para obter o usuário logado
        if (usuario != null) {
            usuario.adicionarPagamento(pagamento);

            // Cria um ingresso para o assento desejado com preço aleatório
            Ingresso ingresso = new Ingresso(eventoIngresso, precoAleatorio, assento);
            usuario.adicionarIngresso(ingresso);

            System.out.println("Pagamento realizado com sucesso! Ingresso adicionado ao usuário.");
        } else {
            System.out.println("Usuário não encontrado. Por favor, faça login.");
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
}