package vendaingressos.models;

import java.util.Date;

public class Feedback {
    private Usuario usuario;
    private String comentario;
    private Date data;

    public Feedback(Usuario usuario, String comentario, Date data) {
        this.usuario = usuario;
        this.comentario = comentario;
        this.data = data != null ? data : new Date(); // Usa a data fornecida, ou a data atual
    }

    @Override
    public String toString() {
        return String.format("Feedback{usuario=%s, comentario='%s'}",
                usuario != null ? usuario.getNome() : "null", comentario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getData() {
        return data;
    }

    public boolean validarComentario(String comentario) {
        // Simulando uma lista de palavrões para validação
        String[] palavroes = {"palavrao1", "palavrao2", "palavrao3"};
        for (String palavra : comentario.split("\\s+")) {
            for (String palavrao : palavroes) {
                if (palavra.equalsIgnoreCase(palavrao)) {
                    return true;
                }
            }
        }
        return false;
    }
}
