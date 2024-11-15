//package vendaingressos.repository;
//
//import dados.Repository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//public class RepositoryTest {
//
//    private Repository repository;
//    private List<Compra> compras;
//    private List<Usuario> usuarios;
//    private List<Feedback> feedbacks;
//
//    @BeforeEach
//    public void setUp() {
//        repository = new Repository();
//        compras = new ArrayList<>();
//        usuarios = new ArrayList<>();
//        feedbacks = new ArrayList<>();
//    }
//
//    @Test
//    public void testSalvarVendas() {
//        Usuario usuario1 = new Usuario("Felipeacs", "felipe@gmail.com", "Felipe", "Rua 1", "senha123", false);
//        Usuario usuario2 = new Usuario("Joãoacs", "joao@gmail.com", "João", "Rua 2", "senha456", false);
//
//        Evento evento1 = new Evento("Show de Rock", "Concerto musical", new Date());
//
//        Ingresso ingresso1 = new Ingresso(evento1, 150.00, "A12");
//        Pagamento pagamento1 = new Pagamento("Cartão de Crédito", "Felipe Silva", "12345678900", "felipe@gmail.com", "1234567890123456", "12/25", "123");
//        pagamento1.setPagamentoConfirmado(true);
//        Compra compra1 = new Compra(usuario1, evento1, ingresso1, pagamento1, 150.00);
//        compras.add(compra1);
//
//        Ingresso ingresso2 = new Ingresso(evento1, 150.00, "A13");
//        Pagamento pagamento2 = new Pagamento("Cartão de Débito", "João Silva", "98765432100", "joao@gmail.com", "6543210987654321", "11/24", "321");
//        pagamento2.setPagamentoConfirmado(true);
//        Compra compra2 = new Compra(usuario2, evento1, ingresso2, pagamento2, 150.00);
//        compras.add(compra2);
//
//        repository.salvarVendas(compras);
//
//        List<Compra> comprasSalvas = repository.carregarVendas();
//        assertEquals(2, comprasSalvas.size());
//        assertEquals("Felipe", comprasSalvas.get(0).getUsuario().getNome());
//        assertEquals("João", comprasSalvas.get(1).getUsuario().getNome());
//        assertEquals("A12", comprasSalvas.get(0).getIngresso().getAssento());
//        assertEquals("A13", comprasSalvas.get(1).getIngresso().getAssento());
//    }
//
//    @Test
//    public void testCarregarVendas() {
//        testSalvarVendas();
//
//        List<Compra> comprasCarregadas = repository.carregarVendas();
//
//        assertNotNull(comprasCarregadas);
//        assertEquals(2, comprasCarregadas.size());
//
//        Compra compra1 = comprasCarregadas.get(0);
//        assertEquals("Felipe", compra1.getUsuario().getNome());
//        assertEquals("Show de Rock", compra1.getIngresso().getEvento().getNome());
//        assertEquals("A12", compra1.getIngresso().getAssento());
//
//        Compra compra2 = comprasCarregadas.get(1);
//        assertEquals("João", compra2.getUsuario().getNome());
//        assertEquals("Show de Rock", compra2.getIngresso().getEvento().getNome());
//        assertEquals("A13", compra2.getIngresso().getAssento());
//    }
//
//    @Test
//    public void testSalvarUsuarios() {
//        Usuario usuario1 = new Usuario("Felipeacs", "felipe@gmail.com", "Felipe", "Rua 1", "senha123", false);
//        Usuario usuario2 = new Usuario("Joãoacs", "joao@gmail.com", "João", "Rua 2", "senha456", false);
//
//        usuarios.add(usuario1);
//        usuarios.add(usuario2);
//
//        repository.salvarUsuarios(usuarios);
//
//        List<Usuario> usuariosSalvos = repository.carregarUsuarios();
//        assertEquals(2, usuariosSalvos.size());
//        assertEquals("Felipe", usuariosSalvos.get(0).getNome());
//        assertEquals("João", usuariosSalvos.get(1).getNome());
//    }
//
//    @Test
//    public void testCarregarUsuarios() {
//        testSalvarUsuarios();
//
//        List<Usuario> usuariosCarregados = repository.carregarUsuarios();
//
//        assertNotNull(usuariosCarregados);
//        assertEquals(2, usuariosCarregados.size());
//        assertEquals("Felipe", usuariosCarregados.get(0).getNome());
//        assertEquals("João", usuariosCarregados.get(1).getNome());
//    }
//
//    @Test
//    public void testSalvarFeedback() {
//        Usuario usuario = new Usuario("Felipeacs", "felipe@gmail.com", "Felipe", "Rua 1", "senha123", false);
//        Evento evento = new Evento("Show de Rock", "Concerto musical", new Date());
//
//        Feedback feedback = new Feedback(usuario, evento, "Ótimo evento!", 5, new Date(), new ArrayList<>());
//        feedbacks.add(feedback);
//
//        repository.salvarFeedbacks(feedbacks);
//
//        List<Feedback> feedbacksSalvos = repository.carregarFeedback();
//        assertEquals(1, feedbacksSalvos.size());
//        assertEquals("Felipe", feedbacksSalvos.get(0).getUsuario().getNome());
//        assertEquals("Ótimo evento!", feedbacksSalvos.get(0).getComentario());
//    }
//
//    @Test
//    public void testCarregarFeedback() {
//        // Salvando feedbacks primeiro
//        testSalvarFeedback();
//
//        // Carregando feedbacks
//        List<Feedback> feedbacksCarregados = repository.carregarFeedback();
//
//        // Verificando se os feedbacks carregados estão corretos
//        assertNotNull(feedbacksCarregados);
//        assertEquals(1, feedbacksCarregados.size());
//        assertEquals("Felipe", feedbacksCarregados.get(0).getUsuario().getNome());
//        assertEquals("Ótimo evento!", feedbacksCarregados.get(0).getComentario());
//    }
//
//    @Test
//    void testConfirmarCompraEmail() {
//        // Arrange
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2024, Calendar.DECEMBER, 25);
//        Date data = calendar.getTime();
//
//        List<Compra> compras = new ArrayList<>();
//        Usuario usuario = new Usuario("Felipeacs", "felipe@gmail.com", "Felipe", "Rua 1", "senha123", false);
//        Evento evento = new Evento("Evento Teste", "Descrição do Evento", data);
//        Ingresso ingresso = new Ingresso(evento, 50.0, "A12");
//        Pagamento pagamento = new Pagamento("cartão", "felipe", "12345678912", "felipe@gmail.com", "5180 2372 4247 8062", "04/08/2026", "853");
//        Compra compra = new Compra(usuario, evento, ingresso, pagamento, 50.0);
//        compras.add(compra);
//
//        // Act
//        repository.confirmarCompraEmail(compra);
//        List<Usuario> usuariosCarregados = repository.carregarConfirmacao();
//
//        // Assert
//        assertNotNull(usuariosCarregados);
//        assertEquals(1, usuariosCarregados.size());
//    }
//
//}
