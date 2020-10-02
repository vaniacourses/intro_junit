package fatura;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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

    @DisplayName("Testa os setters da classe")
    @Test
    public void testaSetter() {
        inicializaFatura();
        assertNotEquals(fatura, new Fatura());
    }

    @DisplayName("Testa os getters da classe")
    @Test
    public void testaGetter() {
        inicializaFatura();
        Assertions.assertAll("fatua",
                () -> assertNotNull(fatura.getData()),
                () -> assertEquals(800, fatura.getValorTotal(), 0),
                () -> assertEquals("Josicreuza", fatura.getNomeCliente()));
    }

    private void inicializaFatura() {
        Date date = new Date(System.currentTimeMillis());
        fatura.setData(date);
        fatura.setValorTotal(800);
        fatura.setNomeCliente("Josicreuza");
    }
}