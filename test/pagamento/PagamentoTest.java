package pagamento;

import org.junit.jupiter.api.*;
import pagamento.TipoPagamentoEnum.TipoPagamento;

import java.util.Date;

import static org.junit.Assert.*;


public class PagamentoTest {

    private Pagamento pagamento;

    @BeforeAll
    public static void printaInicio() {
        System.out.println("Inicio dos testes da classe Patamento.");
    }

    @AfterAll
    public static void printaFim() {
        System.out.println("Fim dos testes da classe Patamento.");
    }

    @BeforeEach
    public void inicializaTest() {
        pagamento = new Pagamento();
    }

    @DisplayName("Testa os setters da classe Pagamento")
    @Test
    public void testaSetters() {
        inicializaPagamento();
        assertNotEquals(pagamento, new Pagamento());
    }

    @DisplayName("Testa os getters da classe Pagamento")
    @Test
    public void testaGetters() {
        inicializaPagamento();
        Assertions.assertAll("pagamento",
                () -> assertEquals(50.30, pagamento.getValorPago(), 0),
                () -> assertNotNull(pagamento.getDate()),
                () -> assertEquals(TipoPagamento.BOLETO, pagamento.getTipoPagamento()));
    }

    private void inicializaPagamento() {
        Date date = new Date(System.currentTimeMillis());
        pagamento = new Pagamento(50.30, date, TipoPagamento.BOLETO);
    }

}


