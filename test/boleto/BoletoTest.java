package boleto;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.Assert.*;

public class BoletoTest {

    private static final Date DATE = new Date(System.currentTimeMillis());
    private static final double VALOR_PAGO = 300.50;
    private static final String CODIGO_BOLETO = "bol123";
    private Boleto boleto;

    @BeforeAll
    public static void printInicioTest() {
        System.out.println("Inicio dos testes da classe Boleto.");
    }

    @AfterAll
    public static void printFimTest() {
        System.out.println("Fim dos testes da classe Boleto.");
    }

    @BeforeEach
    public void inicializa() {
        boleto = new Boleto();
    }

    @DisplayName("Testa os setters da classe Boleto")
    @Test
    public void testSettersBoleto() {
        boleto.setCodigo(CODIGO_BOLETO);
        boleto.setDate(DATE);
        boleto.setValorPago(VALOR_PAGO);
        assertNotEquals(boleto, new Boleto());
    }

    @Test
    public void testGetters() {
        boleto = new Boleto(CODIGO_BOLETO, DATE, VALOR_PAGO);
        Assertions.assertAll("boleto",
                () -> assertEquals(CODIGO_BOLETO, boleto.getCodigo()),
                () -> assertNotNull(boleto.getData()),
                () -> assertEquals(VALOR_PAGO, boleto.getValorPago(), 0));
    }

}
