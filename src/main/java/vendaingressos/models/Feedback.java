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
