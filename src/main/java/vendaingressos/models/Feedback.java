//package vendaingressos.models;
//
//import vendaingressos.Usuario;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
///**
// * A classe Feedback representa um feedback dado por um usuário a um evento,
// * contendo um comentário, nota, data e possíveis respostas ao feedback.
// */
//public class Feedback {
//    private Usuario usuario;
//    private Evento evento;
//    private String comentario;
//    private int nota;
//    private Date data;
//    private List<String> respostas;
//
//    /**
//     * Construtor para criar um novo feedback.
//     *
//     * @param usuario    O usuário que fez o feedback.
//     * @param evento     O evento relacionado ao feedback.
//     * @param comentario O comentário do feedback.
//     * @param nota       A nota atribuída ao evento.
//     * @param data       A data do feedback.
//     * @param respostas  As respostas ao feedback (opcional, pode ser nulo).
//     */
//    public Feedback(Usuario usuario, Evento evento, String comentario, int nota, Date data, List<String> respostas) {
//        this.usuario = usuario;
//        this.evento = evento;
//        this.comentario = comentario;
//        this.nota = nota;
//        this.data = data;
//        this.respostas = respostas != null ? respostas : new ArrayList<>();
//    }
//
//    /**
//     * Define o usuário que fez o feedback.
//     *
//     * @param usuario O usuário que fez o feedback.
//     */
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    /**
//     * Define o evento relacionado ao feedback.
//     *
//     * @param evento O evento associado ao feedback.
//     */
//    public void setEvento(Evento evento) {
//        this.evento = evento;
//    }
//
//    /**
//     * Define o comentário do feedback.
//     *
//     * @param comentario O comentário dado pelo usuário.
//     */
//    public void setComentario(String comentario) {
//        this.comentario = comentario;
//    }
//
//    /**
//     * Define a nota atribuída ao evento.
//     *
//     * @param nota A nota dada ao evento.
//     */
//    public void setNota(int nota) {
//        this.nota = nota;
//    }
//
//    /**
//     * Define a data em que o feedback foi feito.
//     *
//     * @param data A data do feedback.
//     */
//    public void setData(Date data) {
//        this.data = data;
//    }
//
//    /**
//     * Define a lista de respostas ao feedback.
//     *
//     * @param respostas A lista de respostas.
//     */
//    public void setRespostas(List<String> respostas) {
//        this.respostas = respostas;
//    }
//
//    /**
//     * Retorna o usuário que fez o feedback.
//     *
//     * @return O usuário do feedback.
//     */
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    /**
//     * Retorna o evento associado ao feedback.
//     *
//     * @return O evento relacionado ao feedback.
//     */
//    public Evento getEvento() {
//        return evento;
//    }
//
//    /**
//     * Retorna o comentário do feedback.
//     *
//     * @return O comentário dado pelo usuário.
//     */
//    public String getComentario() {
//        return comentario;
//    }
//
//    /**
//     * Retorna a nota atribuída ao evento.
//     *
//     * @return A nota do evento.
//     */
//    public int getNota() {
//        return nota;
//    }
//
//    /**
//     * Retorna a data em que o feedback foi feito.
//     *
//     * @return A data do feedback.
//     */
//    public Date getData() {
//        return data;
//    }
//
//    /**
//     * Retorna a lista de respostas ao feedback.
//     *
//     * @return A lista de respostas.
//     */
//    public List<String> getRespostas() {
//        return respostas;
//    }
//
//    /**
//     * Valida o comentário do feedback, verificando a presença de palavras ofensivas.
//     *
//     * @param comentario O comentário a ser validado.
//     * @return true se o comentário contiver palavras ofensivas, false caso contrário.
//     */
//    public boolean validarComentario(String comentario) {
//        List<String> listDePalavroes = Arrays.asList("palavrao1", "palavrao2", "palavrao3");
//        String[] palavras = comentario.split("\\s+");
//        for (String palavra : palavras) {
//            if (listDePalavroes.contains(palavra.toLowerCase())) {
//                return true;  // Contém palavrão
//            }
//        }
//        return false;  // Não contém palavrão
//    }
//}
