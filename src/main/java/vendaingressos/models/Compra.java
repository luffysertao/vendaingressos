package vendaingressos.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A classe Compra representa a compra de ingressos para um evento.
 * Ela armazena informações sobre o comprador, o evento, o ingresso,
 * o pagamento, o valor total da compra e o status da compra.
 */
public class Compra {
    private Usuario comprador;
    private Evento evento;
    private Ingresso ingresso;
    private Pagamento pagamento;
    private double valorTotal;
    private boolean status;
    private Date dataCompra; // Nova variável para armazenar a data da compra
    private List<Usuario> compradores;

    /**
     * Construtor da classe Compra.
     *
     * @param comprador O usuário que está comprando o ingresso.
     * @param evento O evento para o qual o ingresso está sendo comprado.
     * @param ingresso O ingresso que está sendo comprado.
     * @param pagamento O método de pagamento usado para a compra.
     * @param valorTotal O valor total da compra.
     */
    public Compra(Usuario comprador, Evento evento, Ingresso ingresso, Pagamento pagamento, double valorTotal) {
        this.comprador = comprador;
        this.evento = evento;
        this.ingresso = ingresso;
        this.pagamento = pagamento;
        this.valorTotal = valorTotal;
        this.status = false; // Inicialmente, a compra não está concluída
        this.dataCompra = null; // Inicializa a data como null
        this.compradores = new ArrayList<>();
    }

    /**
     * Valida a compra, verificando se o pagamento e o ingresso estão válidos.
     * Se a compra for válida, atualiza o status, desativa o ingresso e armazena
     * a data da compra.
     *
     * @return true se a compra for válida, false caso contrário.
     */
    public boolean validarCompra() {
        boolean pagamentoValido;
        if (pagamento.getTipo().equalsIgnoreCase("cartão")) {
            pagamentoValido = pagamento.validarCartao();
        } else {
            pagamentoValido = pagamento.validarBoleto();
        }

        if (ingresso.isAtivo() && pagamentoValido) {
            compradores.add(comprador);
            this.status = true; // Atualiza o status
            ingresso.setAtivo(false); // Marca o ingresso como não ativo
            this.dataCompra = new Date(); // Define a data da compra como a data atual
            return true;
        }
        return false;
    }

    /**
     * Cancela a compra, reativando o ingresso se a compra foi realizada.
     *
     * @return true se o cancelamento for bem-sucedido, false caso contrário.
     */
    public boolean cancelarCompra() {
        if (status) {
            this.status = false; // Atualiza o status para indicar que a compra foi cancelada
            ingresso.reativar(); // Reativa o ingresso, se o evento não passou
            return true;
        }
        return false;
    }

    /**
     * Retorna o usuário que realizou a compra.
     *
     * @return O comprador.
     */
    public Usuario getUsuario() {
        return comprador;
    }

    /**
     * Retorna a forma de pagamento utilizada na compra.
     *
     * @return O tipo de pagamento (cartão ou boleto).
     */
    public String getFormaDePagamento() {
        return pagamento.getTipo(); // Retorna o tipo de pagamento
    }

    /**
     * Define a data da compra.
     *
     * @param dataCompra A data a ser definida para a compra.
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * Retorna o evento associado à compra.
     *
     * @return O evento da compra.
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Define o evento associado à compra.
     *
     * @param evento O evento a ser definido.
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * Retorna o ingresso comprado.
     *
     * @return O ingresso da compra.
     */
    public Ingresso getIngresso() {
        return ingresso;
    }

    /**
     * Define o ingresso da compra.
     *
     * @param ingresso O ingresso a ser definido.
     */
    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    /**
     * Retorna o método de pagamento utilizado.
     *
     * @return O pagamento da compra.
     */
    public Pagamento getPagamento() {
        return pagamento;
    }

    /**
     * Define o método de pagamento da compra.
     *
     * @param pagamento O pagamento a ser definido.
     */
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * Retorna o valor total da compra.
     *
     * @return O valor total.
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Define o valor total da compra.
     *
     * @param valorTotal O valor total a ser definido.
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Retorna o status da compra.
     *
     * @return true se a compra foi concluída, false caso contrário.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Retorna a data em que a compra foi realizada.
     *
     * @return A data da compra.
     */
    public Date getDataCompra() {
        return dataCompra;
    }
}
