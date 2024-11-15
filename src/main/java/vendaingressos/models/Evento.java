//package vendaingressos.models;
//
//import vendaingressos.Feedback;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Classe que representa um evento, com atributos como nome, descrição, data,
// * assentos disponíveis e feedbacks.
// */
//public class Evento {
//
//    // Atributos do evento
//    private String nome;
//    private String descricao;
//    private Date data;
//    private List<String> assentos;
//    private boolean isAtivo;
//    private List<Feedback> feedbacks;
//
//    /**
//     * Construtor para inicializar um novo evento.
//     *
//     * @param nome       O nome do evento.
//     * @param descricao  A descrição do evento.
//     * @param data       A data do evento.
//     */
//    public Evento(String nome, String descricao, Date data) {
//        this.nome = nome;
//        this.descricao = descricao;
//        this.data = data;
//        this.assentos = new ArrayList<>();
//        this.isAtivo = true;
//        this.feedbacks = new ArrayList<>();
//    }
//
//    /**
//     * Retorna o nome do evento.
//     *
//     * @return O nome do evento.
//     */
//    public String getNome() {
//        return nome;
//    }
//
//    /**
//     * Retorna a descrição do evento.
//     *
//     * @return A descrição do evento.
//     */
//    public String getDescricao() {
//        return descricao;
//    }
//
//    /**
//     * Retorna a data do evento.
//     *
//     * @return A data do evento.
//     */
//    public Date getData() {
//        return data;
//    }
//
//    /**
//     * Verifica se o evento já ocorreu.
//     *
//     * @return true se o evento já tiver ocorrido, false caso contrário.
//     */
//    public boolean isEventoPassado() {
//        Date agora = new Date();
//        return data.before(agora);
//    }
//
//    /**
//     * Adiciona um novo assento ao evento.
//     *
//     * @param assento O assento a ser adicionado.
//     */
//    public void adicionarAssento(String assento) {
//        if (!assentos.contains(assento)) {
//            assentos.add(assento);
//        }
//    }
//
//    /**
//     * Retorna uma lista de assentos disponíveis para o evento.
//     *
//     * @return Uma cópia da lista de assentos disponíveis.
//     */
//    public List<String> getAssentosDisponiveis() {
//        return new ArrayList<>(assentos);
//    }
//
//    /**
//     * Remove um assento da lista de assentos disponíveis.
//     *
//     * @param assento O assento a ser removido.
//     */
//    public void removerAssento(String assento) {
//        if (assentos.contains(assento)) {
//            assentos.remove(assento);
//        }
//    }
//
//    /**
//     * Verifica se o evento está ativo. Um evento é considerado inativo
//     * se a data do evento já tiver passado.
//     *
//     * @return true se o evento estiver ativo, false caso contrário.
//     */
//    public boolean isAtivo() {
//        if (isEventoPassado()) {
//            this.isAtivo = false;
//            return isAtivo;
//        } else {
//            return true;
//        }
//    }
//
//    /**
//     * Retorna a lista de assentos do evento.
//     *
//     * @return A lista de assentos.
//     */
//    public List<String> getAssentos() {
//        return assentos;
//    }
//
//    /**
//     * Retorna a lista de feedbacks do evento.
//     *
//     * @return A lista de feedbacks.
//     */
//    public List<Feedback> getFeedbacks() {
//        return feedbacks;
//    }
//
//    /**
//     * Adiciona um feedback ao evento. O feedback só é adicionado se
//     * o comentário for válido.
//     *
//     * @param feedback O feedback a ser adicionado.
//     */
//    public void adicionarFeedback(Feedback feedback) {
//        String comentario = feedback.getComentario();
//        if (!feedback.validarComentario(comentario)) {
//            feedbacks.add(feedback);
//        }
//    }
//
//    /**
//     * Remove um feedback do evento.
//     *
//     * @param feedback O feedback a ser removido.
//     */
//    public void removerFeedback(Feedback feedback) {
//        feedbacks.remove(feedback);
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
