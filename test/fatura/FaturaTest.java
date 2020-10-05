package fatura;

import fatura.StatusFaturaEnum.StatusFatura;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FaturaTest {

    private static final double VALOR_FATURA = 800;
    private static final Date DATE = new Date(System.currentTimeMillis());
    private static final String NOME_CLIENTE = "Josicreuza";
    private Fatura fatura;

    @BeforeAll
    public static void printaFim() {
        System.out.println("Inicio dos testes da classe Fatura.");
    }

    @AfterAll
    public static void printaInicio() {
        System.out.println("Fim dos testes da classe Fatura.");
    }

    @BeforeEach
    public void inicializaTest() {
        fatura = new Fatura();
    }

    @DisplayName("Testa os setters da classe Fatura")
    @Test
    public void testaSetter() {
        fatura.setDate(DATE);
        fatura.setValorTotal(VALOR_FATURA);
        fatura.setNomeCliente(NOME_CLIENTE);
        fatura.setStatusFatura(StatusFatura.NAO_PAGA);
        assertNotEquals(fatura, new Fatura());
    }

    @DisplayName("Testa os getters da classe Fatura")
    @Test
    public void testaGetter() {
        fatura = new Fatura(DATE, VALOR_FATURA, NOME_CLIENTE, StatusFatura.NAO_PAGA);
        Assertions.assertAll("fatura",
                () -> assertEquals(DATE, fatura.getDate()),
                () -> assertEquals(VALOR_FATURA, fatura.getValorTotal(), 0),
                () -> assertEquals(NOME_CLIENTE, fatura.getNomeCliente()));
    }

}