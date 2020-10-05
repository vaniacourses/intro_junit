package processador;

import boleto.Boleto;
import fatura.Fatura;
import fatura.StatusFaturaEnum.StatusFatura;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ProcessadorTest {

    private static final Date DATE = new Date(System.currentTimeMillis());
    private static final double VALOR_PAGO_FATURA_PAGA = 400;
    private static final double VALOR_PAGO_FATURA_NAO_PAGA = 800;
    private static final String NOME_CLIENTE = "Jusicreuza";
    private List<Boleto> listBoletos = new ArrayList<>();

    @BeforeAll
    public static void printInicioTest() {
        System.out.println("Inicio dos testes da classe ProcessadorTest.");
    }

    @AfterAll
    public static void printFimDoTest() {
        System.out.println("Fim dos testes da classe ProcessadorTest");
    }

    @BeforeEach
    public void inicializa() {
        listBoletos = new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
        Boleto boleto = new Boleto("bol123", date, 300);
        Boleto boleto2 = new Boleto("eto456", date, 100);
        listBoletos.addAll(Arrays.asList(boleto, boleto2));
    }

    @DisplayName("Testa a verificação correta de uma Fatura paga")
    @Test
    public void testVerificaFaturaPaga() {
        Fatura fatura = inicializaFatura(VALOR_PAGO_FATURA_PAGA);
        Processador processador = inicializaProcessador(listBoletos, fatura);
        assertTrue(processador.verificaFaturaPaga());
        assertEquals(StatusFatura.PAGA, fatura.getStatusFatura());
    }

    @DisplayName("Testa a verificação correta de uma Fatura não paga")
    @Test
    public void testVerificaFaturaEmAberto() {
        Fatura fatura = inicializaFatura(VALOR_PAGO_FATURA_NAO_PAGA);
        Processador processador = inicializaProcessador(listBoletos, fatura);
        assertFalse(processador.verificaFaturaPaga());
        assertEquals(StatusFatura.NAO_PAGA, fatura.getStatusFatura());
    }

    @DisplayName("Testa se o processador está criando pagamentos relacionados a fatura")
    @Test
    public void testCriaPagamento() {
        Fatura fatura = inicializaFatura(VALOR_PAGO_FATURA_NAO_PAGA);
        Processador processador = inicializaProcessador(listBoletos, fatura);
        processador.criaPagamentos();
        assertEquals(listBoletos.size(), fatura.getPagamentoList().size());
    }

    private Processador inicializaProcessador(List<Boleto> listBoletos, Fatura fatura) {
        return new Processador(listBoletos, fatura);
    }

    private Fatura inicializaFatura(double valorPago) {
        return new Fatura(DATE, valorPago, NOME_CLIENTE, StatusFatura.NAO_PAGA);
    }

    private double getValorTotalBoletos() {
        double valorTotal = 0;
        for (Boleto boleto : listBoletos) {
            valorTotal = valorTotal + boleto.getValorPago();
        }
        return valorTotal;
    }

}
