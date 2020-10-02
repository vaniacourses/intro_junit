package fatura;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.Assert.*;

public class FaturaTest {

    Fatura fatura = new Fatura();

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
        inicializaFatura();
        assertNotEquals(fatura, new Fatura());
    }

    @DisplayName("Testa os getters da classe Fatura")
    @Test
    public void testaGetter() {
        inicializaFatura();
        Assertions.assertAll("fatura",
                () -> assertNotNull(fatura.getDate()),
                () -> assertEquals(800, fatura.getValorTotal(), 0),
                () -> assertEquals("Josicreuza", fatura.getNomeCliente()));
    }

    private void inicializaFatura() {
        Date date = new Date(System.currentTimeMillis());
        fatura.setDate(date);
        fatura.setValorTotal(800);
        fatura.setNomeCliente("Josicreuza");
    }
}