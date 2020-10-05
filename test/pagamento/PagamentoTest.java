package pagamento;

import org.junit.jupiter.api.*;
import pagamento.TipoPagamentoEnum.TipoPagamento;

import java.util.Date;

import static org.junit.Assert.*;


public class PagamentoTest {

    private static final Date DATE = new Date(System.currentTimeMillis());
    private static final double VALOR_PAGAMENTO = 50.30;
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
        pagamento.setValorPago(VALOR_PAGAMENTO);
        pagamento.setDate(DATE);
        pagamento.setTipoPagamento(TipoPagamento.BOLETO);
        assertNotEquals(pagamento, new Pagamento());
    }

    @DisplayName("Testa os getters da classe Pagamento")
    @Test
    public void testaGetters() {
        pagamento = new Pagamento(VALOR_PAGAMENTO, DATE, TipoPagamento.BOLETO);
        Assertions.assertAll("pagamento",
                () -> assertEquals(VALOR_PAGAMENTO, pagamento.getValorPago(), 0),
                () -> assertNotNull(pagamento.getDate()),
                () -> assertEquals(TipoPagamento.BOLETO, pagamento.getTipoPagamento()));
    }


}


