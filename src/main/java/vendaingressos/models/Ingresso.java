package vendaingressos.models;

public class Ingresso {
    // Atributos do ingresso
    public Evento evento; // Evento associado ao ingresso
    public double preco; // Preço do ingresso
    public String assento; // Assento reservado
    public boolean ativo; // Estado do ingresso (ativo ou não)

    /**
     * Construtor para inicializar um novo ingresso.
     *
     * @param evento  O evento associado ao ingresso.
     * @param preco   O preço do ingresso.
     * @param assento O assento reservado para o ingresso.
     */
    public Ingresso(Evento evento, double preco, String assento) {
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
        this.ativo = true; // Inicialmente o ingresso está ativo
    }

    /**
     * Getter para o evento associado ao ingresso.
     *
     * @return O evento associado a este ingresso.
     */
    public Evento getEvento() {
        return this.evento;
    }

    /**
     * Getter para o preço do ingresso.
     *
     * @return O preço do ingresso.
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Getter para o assento reservado.
     *
     * @return O assento reservado para o ingresso.
     */
    public String getAssento() {
        return this.assento;
    }

    /**
     * Getter para verificar se o ingresso está ativo.
     *
     * @return true se o ingresso estiver ativo, false caso contrário.
     */
    public boolean isAtivo() {
        return this.ativo;
    }

    /**
     * Setter para definir o estado do ingresso (ativo ou não).
     *
     * @param value O novo estado do ingresso (true para ativo, false para inativo).
     */
    public void setAtivo(boolean value) {
        this.ativo = value;
    }

    /**
     * Método para cancelar o ingresso se o evento não tiver passado.
     *
     * @return true se o ingresso foi cancelado com sucesso, false se o evento já ocorreu.
     */
    public boolean cancelar() {
        if (evento.isEventoPassado()) {
            return false; // Não pode cancelar se o evento já ocorreu
        }

        this.ativo = false;
        return true;
    }

    /**
     * Método para reativar o ingresso se o evento não tiver passado.
     */
    public void reativar() {
        if (!this.ativo && !evento.isEventoPassado()) {
            this.ativo = true;
        }
    }

    /**
     * Comparação para verificar se dois ingressos são iguais com base no assento.
     *
     * @param obj O objeto a ser comparado.
     * @return true se os ingressos forem iguais (com base no assento), false caso contrário.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ingresso ingresso = (Ingresso) obj;
        return assento.equals(ingresso.assento);
    }

    /**
     * Código hash para o ingresso, baseado no assento.
     *
     * @return O código hash do ingresso.
     */
    public int hashCode() {
        return assento.hashCode();
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
