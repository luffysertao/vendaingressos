package vendaingressos.models;

import java.util.Objects;

/**
 * Classe Pagamento representa o pagamento realizado pelo usuário.
 * Suporta diferentes tipos de pagamento como cartão de crédito e boleto.
 */
public class Pagamento {
    private String tipo;
    private String nomeTitular;
    private String cpf;
    private String email;
    private String numeroCartao;
    private String validadeCartao;
    private String codigoSeguranca;
    private boolean pagamentoConfirmado; // Novo atributo para indicar se o pagamento está confirmado

    /**
     * Construtor para inicializar um pagamento com informações de cartão.
     *
     * @param tipo Tipo de pagamento (ex: "Cartão de Crédito" ou "Boleto").
     * @param nomeTitular Nome do titular do cartão.
     * @param cpf CPF do titular.
     * @param email Email do titular.
     * @param numeroCartao Número do cartão de crédito.
     * @param validadeCartao Data de validade do cartão (MM/AA).
     * @param codigoSeguranca Código de segurança do cartão (CVV).
     */
    public Pagamento(String tipo, String nomeTitular, String cpf, String email, String numeroCartao, String validadeCartao, String codigoSeguranca) {
        this.tipo = tipo;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.email = email;
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.codigoSeguranca = codigoSeguranca;
        if (Objects.equals(tipo, "Cartão de Crédito")) {
            this.pagamentoConfirmado = true;
        } else {
            this.pagamentoConfirmado = false;
        }
    }

    /**
     * Construtor para inicializar um pagamento sem informações de cartão.
     *
     * @param tipo Tipo de pagamento (ex: "Cartão de Crédito" ou "Boleto").
     * @param nomeTitular Nome do titular do pagamento.
     * @param cpf CPF do titular.
     * @param email Email do titular.
     */
    public Pagamento(String tipo, String nomeTitular, String cpf, String email) {
        this.tipo = tipo;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.email = email;
        this.pagamentoConfirmado = false; // Inicialmente, o pagamento não está confirmado
    }

    /** @return o tipo de pagamento. */
    public String getTipo() {
        return tipo;
    }

    /** @return o nome do titular do pagamento. */
    public String getNomeTitular() {
        return nomeTitular;
    }

    /** @return o CPF do titular do pagamento. */
    public String getCpf() {
        return cpf;
    }

    /** @return o email do titular do pagamento. */
    public String getEmail() {
        return email;
    }

    /** @return o número do cartão de crédito. */
    public String getNumeroCartao() {
        return numeroCartao;
    }

    /** @return a data de validade do cartão de crédito. */
    public String getValidadeCartao() {
        return validadeCartao;
    }

    /** @return o código de segurança do cartão. */
    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    /** @return true se o pagamento está confirmado; caso contrário, false. */
    public boolean isPagamentoConfirmado() {
        return pagamentoConfirmado;
    }

    /** @param tipo Define o tipo de pagamento. */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /** @param nomeTitular Define o nome do titular do pagamento. */
    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    /** @param cpf Define o CPF do titular do pagamento. */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /** @param email Define o email do titular do pagamento. */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @param numeroCartao Define o número do cartão de crédito. */
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    /** @param validadeCartao Define a data de validade do cartão de crédito. */
    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    /** @param codigoSeguranca Define o código de segurança do cartão. */
    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    /** @param pagamentoConfirmado Define se o pagamento está confirmado. */
    public void setPagamentoConfirmado(boolean pagamentoConfirmado) {
        this.pagamentoConfirmado = pagamentoConfirmado;
    }

    /**
     * Valida as informações para pagamento por boleto.
     *
     * @return true se o CPF e o email são válidos; caso contrário, false.
     */
    public boolean validarBoleto() {
        return validarCPF() && validarEmail();
    }

    /**
     * Valida as informações para pagamento por cartão.
     *
     * @return true se o número do cartão, validade e código de segurança são válidos; caso contrário, false.
     */
    public boolean validarCartao() {
        return validarNumeroCartao() && validarValidadeCartao() && validarCodigoSeguranca();
    }

    /**
     * Valida o CPF.
     *
     * @return true se o CPF tem 11 dígitos; caso contrário, false.
     */
    public boolean validarCPF() {
        return cpf != null && cpf.length() == 11; // Exemplo simples de validação de CPF
    }

    /**
     * Valida o email.
     *
     * @return true se o email contém "@"; caso contrário, false.
     */
    public boolean validarEmail() {
        return email != null && email.contains("@"); // Exemplo simples de validação de email
    }

    /**
     * Valida o número do cartão de crédito.
     *
     * @return true se o número do cartão tem 16 dígitos; caso contrário, false.
     */
    public boolean validarNumeroCartao() {
        return numeroCartao != null && numeroCartao.length() == 16;
    }

    /**
     * Valida a data de validade do cartão.
     *
     * @return true se a data está no formato MM/AA; caso contrário, false.
     */
    public boolean validarValidadeCartao() {
        return validadeCartao != null && validadeCartao.matches("(0[1-9]|1[0-2])/\\d{2}");
    }

    /**
     * Valida o código de segurança do cartão.
     *
     * @return true se o código de segurança tem 3 dígitos; caso contrário, false.
     */
    public boolean validarCodigoSeguranca() {
        return codigoSeguranca != null && codigoSeguranca.length() == 3;
    }
}
