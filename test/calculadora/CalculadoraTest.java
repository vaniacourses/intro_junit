package calculadora;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeAll
    public static void printaInicio(){
        System.out.println("Inicia rodada de testes");
    }

    @AfterAll
    public static void printaFim(){
        System.out.println("Fim da rodada de testes");
    }

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @DisplayName("Testa a soma de dois números")
    @Test
    public void testSomaDoisNumeros() {
        int soma = calc.soma(4, 5);
        Assertions.assertEquals(9, soma);
    }

    @Test
    public void testDivisaoDoisNumeros() {
        int divisao = calc.divisao(8, 4);
        assertTrue(divisao == 2);
    }

    @Test
    public void testDivisaoPorZero() {
        try {
            int divisao = calc.divisao(8, 0);
            fail("Exceção não prevista");
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void testDivisaoPorZeroComAssertThrows() {
        assertThrows(ArithmeticException.class,
                () -> calc.divisao(8, 0));
    }

    @Test
    public void testSubtracaoDoisNumerosPositivos() {
        assertEquals(5, calc.subtracao(10, 5));
    }

    @Test
    public void testSubtracaoDoisNumerosNegativos() {
        assertEquals(-5, calc.subtracao(-10, -5));
    }

    @Test
    public void testSomatorio() {
        assertEquals(6, calc.somatoria(3));
    }

    @DisplayName("Compara se A menor que B")
    @Test
    public void testComparaNumerosDiferentesAMenorQueB() {
        assertEquals(-1, calc.compara(1, 2));
    }

    @DisplayName("Compara se A maior que B")
    @Test
    public void testComparaNumerosDiferentesBMenorQueA() {
        assertEquals(1, calc.compara(2, 1));
    }

    @DisplayName("Compara se A igual a B")
    @Test
    public void testComparaNumerosIguais() {
        assertEquals(0, calc.compara(2, 2));
    }

    @Test
    public void verificaSeEhNegativo() {
        assertFalse(calc.ehPositivo(-1));
    }

    @Test
    public void verificaSeEhPositivo() {
        assertTrue(calc.ehPositivo(1));
    }
}
