package boleto;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.Assert.*;

public class BoletoTest {

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
        inicializaBoleto();
        assertNotEquals(boleto, new Boleto());
    }

    @Test
    public void testGetters() {
        inicializaBoleto();
        Assertions.assertAll("boleto",
                () -> assertEquals("bol123", boleto.getCodigo()),
                () -> assertNotNull(boleto.getData()),
                () -> assertEquals(300.50, boleto.getValorPago(), 0));
    }

    private void inicializaBoleto() {
        Date date = new Date(System.currentTimeMillis());
        boleto.setCodigo("bol123");
        boleto.setData(date);
        boleto.setValorPago(300.50);
    }

}
