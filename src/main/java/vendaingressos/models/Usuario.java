package vendaingressos.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    // Atributos do usuário
    public String login; // Nome de usuário para login
    public String senha; // Senha do usuário
    public String nome; // Nome completo do usuário
    public String cpf; // CPF do usuário
    public String email; // Email do usuário
//    public boolean isAdmin; // Indica se o usuário é um administrador
//    private List<Ingresso> ingressos; // Lista de ingressos comprados pelo usuário
//    private List<Pagamento> pagamentos; // Lista de pagamentos realizados pelo usuário

    /**
     * Construtor para inicializar um novo usuário.
     *
     * @param login   O nome de usuário para login.
//     * @param senha   A senha do usuário.
     * @param nome    O nome completo do usuário.
     * @param cpf     O CPF do usuário.
     * @param email   O email do usuário.
//     * @param isAdmin Indica se o usuário é um administrador.
     */
    public Usuario(String nome, String login, String cpf, String email, String senha) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
//        this.isAdmin = isAdmin;
//        this.ingressos = new ArrayList<>();
//        this.pagamentos = new ArrayList<>();
    }

    /**
     * Retorna o login do usuário.
     *
     * @return O login do usuário.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Retorna o nome completo do usuário.
     *
     * @return O nome completo do usuário.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna o CPF do usuário.
     *
     * @return O CPF do usuário.
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Retorna o email do usuário.
     *
     * @return O email do usuário.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getSenha() {
        return this.senha;
    }

    public String getnome() {
        return this.nome;
    }

    /**
     * Verifica se o usuário possui privilégios de administrador.
     *
     * @return true se o usuário for administrador, false caso contrário.
     */
//    public boolean isAdmin() {
//        return this.isAdmin;
//    }

    /**
     * Realiza o login do usuário verificando as credenciais.
     *
     * @param login O nome de usuário fornecido.
     * @param senha A senha fornecida.
     * @return true se as credenciais estiverem corretas, false caso contrário.
     */
    public boolean login(String login, String senha) {
        return login.equals(this.login) && senha.equals(this.senha);
    }

    /**
     * Atualiza a senha do usuário.
     *
     * @param novaSenha A nova senha a ser definida.
     */
    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    /**
     * Atualiza o nome do usuário.
     *
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Atualiza o CPF do usuário.
     *
     * @param cpf O novo CPF do usuário.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Atualiza o email do usuário.
     *
     * @param email O novo email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

//    /**
//     * Compara se dois usuários são iguais com base no login.
//     *
//     * @param o O objeto a ser comparado.
//     * @return true se os usuários forem iguais, false caso contrário.
//     */
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Usuario usuario = (Usuario) o;
//        return Objects.equals(login, usuario.login);
//    }
//
//    /**
//     * Gera um código hash para o usuário baseado no login.
//     *
//     * @return O código hash do usuário.
//     */
//    public int hashCode() {
//        return Objects.hash(login);
//    }

//    /**
//     * Retorna a lista de ingressos do usuário.
//     *
//     * @return A lista de ingressos comprados pelo usuário.
//     */
//    public List<Ingresso> getIngressos() {
//        return ingressos;
//    }
//
//    /**
//     * Retorna a lista de pagamentos do usuário.
//     *
//     * @return A lista de pagamentos realizados pelo usuário.
//     */
//    public List<Pagamento> getPagamentos() {
//        return pagamentos;
//    }
//
//    /**
//     * Adiciona um ingresso à lista de ingressos do usuário.
//     *
//     * @param ingresso O ingresso a ser adicionado.
//     */
//    public void adicionarIngresso(Ingresso ingresso) {
//        ingressos.add(ingresso);
//    }
//
//    /**
//     * Remove um ingresso da lista de ingressos do usuário.
//     *
//     * @param ingresso O ingresso a ser removido.
//     */
//    public void removerIngresso(Ingresso ingresso) {
//        ingressos.remove(ingresso);
//    }
//
//    /**
//     * Edita o perfil do usuário, atualizando o nome, email e senha.
//     *
//     * @param novoNome   O novo nome do usuário.
//     * @param novoEmail  O novo email do usuário.
//     * @param novaSenha  A nova senha do usuário.
//     */
//    public void editarPerfil(String novoNome, String novoEmail, String novaSenha) {
//        if (novoNome != null && !novoNome.isEmpty()) {
//            this.nome = novoNome;
//        }
//        if (novoEmail != null && !novoEmail.isEmpty()) {
//            this.email = novoEmail;
//        }
//        if (novaSenha != null && !novaSenha.isEmpty()) {
//            this.senha = novaSenha;
//        }
//    }
//
//    /**
//     * Adiciona um pagamento à lista de pagamentos do usuário.
//     *
//     * @param pagamento O pagamento a ser adicionado.
//     */
//    public void adicionarPagamento(Pagamento pagamento) {
//        pagamentos.add(pagamento);
//    }
//
//    /**
//     * Remove um pagamento da lista de pagamentos do usuário, caso ele esteja presente.
//     *
//     * @param pagamento O pagamento a ser removido.
//     */
//    public void removerPagamento(Pagamento pagamento) {
//        if (pagamentos.contains(pagamento)) {
//            pagamentos.remove(pagamento);
//        }
//    }
}

/*******************************
 Autor: Felipe Amorim do Carmo Silva
 Componente Curricular: EXA863 - MI - PROGRAMAÇÃO
 Concluído em: 11/09/2024
 Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 ********************************/
