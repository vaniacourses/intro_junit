package pagamento;

import org.junit.Assert.*
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
        Assertions.assertAll("boleto",
                () -> assertEquals("bol123", pagamento.getValorPago()),
                () -> assertNotNull(pagamento.getDate()),
                () -> assertEquals("BOLETO", pagamento.getTipoPagamento()));
    }

    private void inicializaPagamento() {
        Date date = new Date(System.currentTimeMillis());
        pagamento.setValorPago(50.30);
        pagamento.setDate(date);
        pagamento.setTipoPagamento("BOLETO");
    }

}


