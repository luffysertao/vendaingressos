//package vendaingressos.controllers;
//
//import vendaingressos.models.*;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * A classe Controller gerencia as operações de cadastro de usuários, eventos, compra de ingressos,
// * processamento de pagamentos e feedbacks para os eventos.
// * Ela mantém listas de usuários, eventos, ingressos comprados, pagamentos e vendas realizadas.
// */
//public class Controller {
//
//    /** Lista de usuários cadastrados no sistema */
//    public List<Usuario> usuarios = new ArrayList<>();
//
//    /** Lista de eventos disponíveis no sistema */
//    public List<Evento> eventos = new ArrayList<>();
//
//    /** Lista de ingressos comprados pelos usuários */
//    public List<Ingresso> ingressosComprados = new ArrayList<>();
//
//    /** Lista de pagamentos realizados pelos usuários */
//    public List<Pagamento> pagamentos = new ArrayList<>();
//
//    /** Lista de compras ou vendas realizadas */
//    public List<Compra> vendas = new ArrayList<>();
//
//    /**
//     * Cadastra um novo usuário no sistema.
//     *
//     * @param login O login do usuário.
//     * @param senha A senha do usuário.
//     * @param adminUser Identifica se o usuário é administrador.
//     * @param number O número de telefone do usuário.
//     * @param email O email do usuário.
//     * @param valido Indica se o cadastro do usuário é válido.
//     * @return O usuário cadastrado.
//     */
//    public Usuario cadastrarUsuario(String login, String senha, String adminUser, String number, String email, boolean valido) {
//        Usuario admin = new Usuario(login, senha, adminUser, number, email, valido);
//        usuarios.add(admin);
//        return admin;
//    }
//
//    /**
//     * Cadastra um novo evento no sistema, disponível apenas para administradores.
//     *
//     * @param admin O administrador responsável pelo cadastro do evento.
//     * @param nome O nome do evento.
//     * @param descricao A descrição do evento.
//     * @param data A data em que o evento ocorrerá.
//     * @return O evento cadastrado.
//     * @throws SecurityException Se o usuário não for um administrador.
//     */
//    public Evento cadastrarEvento(Usuario admin, String nome, String descricao, Date data) {
//        if (admin.getLogin().equals("admin")) {
//            Evento evento = new Evento(nome, descricao, data);
//            eventos.add(evento);
//            return evento;
//        } else {
//            throw new SecurityException("Somente administradores podem cadastrar eventos.");
//        }
//    }
//
//    /**
//     * Adiciona um assento disponível a um evento específico.
//     *
//     * @param show O nome do evento.
//     * @param assento O assento a ser adicionado.
//     */
//    public void adicionarAssentoEvento(String show, String assento) {
//        for (Evento evento : eventos) {
//            if (evento.getNome().equals(show)) {
//                evento.adicionarAssento(assento);
//            }
//        }
//    }
//
//    /**
//     * Realiza a compra de um ingresso para um evento.
//     *
//     * @param usuario O usuário que está comprando o ingresso.
//     * @param nomeEvento O nome do evento.
//     * @param assento O assento desejado.
//     * @return O ingresso comprado.
//     * @throws IllegalArgumentException Se o assento não estiver disponível ou o evento não for encontrado.
//     */
//    public Ingresso comprarIngresso(Usuario usuario, String nomeEvento, String assento) {
//        for (Evento evento : eventos) {
//            if (evento.getNome().equals(nomeEvento)) {
//                if (evento.getAssentosDisponiveis().contains(assento)) {
//                    Ingresso ingresso = new Ingresso(evento, 100, assento);
//                    usuario.adicionarIngresso(ingresso);
//                    evento.removerAssento(assento);
//                    ingressosComprados.add(ingresso);
//                    return ingresso;
//                } else {
//                    throw new IllegalArgumentException("Assento não disponível");
//                }
//            }
//        }
//        throw new IllegalArgumentException("Evento não encontrado");
//    }
//
//    /**
//     * Cancela a compra de um ingresso.
//     *
//     * @param usuario O usuário que deseja cancelar o ingresso.
//     * @param ingresso O ingresso a ser cancelado.
//     * @return true se o cancelamento for bem-sucedido.
//     */
//    public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
//        usuario.removerIngresso(ingresso);
//        ingresso.setAtivo(false);
//        return true;
//    }
//
//    /**
//     * Lista todos os eventos disponíveis.
//     *
//     * @return A lista de eventos disponíveis.
//     */
//    public List<Evento> listarEventosDisponiveis() {
//        return eventos;
//    }
//
//    /**
//     * Lista todos os ingressos comprados por um usuário.
//     *
//     * @param usuario O usuário cujos ingressos serão listados.
//     * @return A lista de ingressos comprados pelo usuário.
//     */
//    public List<Ingresso> listarIngressosComprados(Usuario usuario) {
//        return ingressosComprados;
//    }
//
//    /**
//     * Finaliza a compra de um ingresso, validando o pagamento e atualizando as vendas.
//     *
//     * @param usuario O usuário que está comprando o ingresso.
//     * @param ingresso O ingresso que está sendo comprado.
//     * @param pagamento O pagamento associado à compra.
//     * @return A compra realizada.
//     * @throws IllegalArgumentException Se a compra ou o pagamento for inválido.
//     */
//    public Compra finalizarCompra(Usuario usuario, Ingresso ingresso, Pagamento pagamento) {
//        Compra compra = new Compra(usuario, ingresso.getEvento(), ingresso, pagamento, ingresso.getPreco());
//        if (compra.validarCompra()) {
//            vendas.add(compra);
//            return compra;
//        } else {
//            throw new IllegalArgumentException("Compra inválida");
//        }
//    }
//
//    /**
//     * Adiciona um feedback para um evento.
//     *
//     * @param usuario O usuário que está enviando o feedback.
//     * @param eventoNome O nome do evento.
//     * @param comentario O comentário do feedback.
//     * @param nota A nota atribuída ao evento.
//     * @param data A data do feedback.
//     * @return O feedback adicionado.
//     * @throws IllegalArgumentException Se o usuário não participou do evento ou o evento não for encontrado.
//     */
//    public Feedback adicionarFeedback(Usuario usuario, String eventoNome, String comentario, int nota, Date data) {
//        for (Evento evento : eventos) {
//            if (evento.getNome().equals(eventoNome)) {
//                Feedback feedback = new Feedback(usuario, evento, comentario, nota, data, new ArrayList<>());
//                evento.adicionarFeedback(feedback);
//                return feedback;
//            }
//        }
//        throw new IllegalArgumentException("Evento não encontrado ou usuário não participou do evento.");
//    }
//
//    /**
//     * Remove um feedback de um evento.
//     *
//     * @param usuario O usuário que deseja remover o feedback.
//     * @param eventoNome O nome do evento.
//     * @param comentario O comentário do feedback a ser removido.
//     * @return true se o feedback for removido com sucesso.
//     */
//    public boolean removerFeedback(Usuario usuario, String eventoNome, String comentario) {
//        for (Evento evento : eventos) {
//            if (evento.getNome().equals(eventoNome)) {
//                List<Feedback> feedbacks = evento.getFeedbacks();
//                for (Feedback feedback : feedbacks) {
//                    if (feedback.getUsuario().equals(usuario) && feedback.getComentario().equals(comentario)) {
//                        evento.removerFeedback(feedback);
//                        return true;
//                    }
//                }
//            }
//        }
//        throw new IllegalArgumentException("Feedback não encontrado para este evento.");
//    }
//
//    /**
//     * Processa um pagamento, validando-o e confirmando-o de acordo com o tipo.
//     *
//     * @param pagamento O pagamento a ser processado.
//     * @return true se o pagamento for confirmado com sucesso.
//     * @throws IllegalArgumentException Se o pagamento for nulo ou inválido.
//     */
//    public boolean processarPagamento(Pagamento pagamento) {
//        if (pagamento == null) {
//            throw new IllegalArgumentException("Pagamento não pode ser nulo.");
//        }
//
//        switch (pagamento.getTipo()) {
//            case "Cartão de Crédito":
//                if (pagamento.validarCartao()) {
//                    pagamento.setPagamentoConfirmado(true);
//                    pagamentos.add(pagamento);
//                    return true;
//                }
//                break;
//
//            case "Boleto":
//                if (pagamento.validarBoleto()) {
//                    pagamentos.add(pagamento);
//                    return true;
//                }
//                break;
//
//            default:
//                throw new IllegalArgumentException("Tipo de pagamento inválido.");
//        }
//
//        return false;
//    }
//}
//
///*******************************
// Autor: Felipe Amorim do Carmo Silva
// Componente Curricular: EXA863 - MI - PROGRAMAÇÃO
// Concluído em: 11/09/2024
// Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
// trecho de código de outro colega ou de outro autor, tais como provindos de livros e
// apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
// de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
// do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
// ********************************/
