package processador;

import boleto.Boleto;
import fatura.Fatura;
import org.junit.jupiter.api.*;
import pagamento.Pagamento;
import pagamento.TipoPagamentoEnum.TipoPagamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ProcessadorTest {

    private List<Boleto> listBoletos;
    private static final Date DATE = new Date(System.currentTimeMillis());

    @BeforeAll
    public static void printInicioTest() {
        System.out.println("Inicio dos testes da classe ProcessadorTest.");
    }

    @AfterAll
    public static void printFimDoTest() {
        System.out.println("Fim dos testes da classe ProcessadorTest");
        System.out.println("------------------------------------------");
    }

    @BeforeEach
    public void inicializa() {
        List<Boleto> listBoletos = new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
        Boleto boleto = new Boleto("bol123", date, 300);
        Boleto boleto2 = new Boleto("eto456", date, 100);
        listBoletos.addAll(Arrays.asList(boleto, boleto2));
    }

    @DisplayName("Testa a verifica��o correta de uma Fatura paga")
    @Test
    public void testVerificaFaturaPaga() {
        Fatura fatura = inicializaFaturaDeAmbientePago();
        Processador processador = inicializaProcessador(listBoletos, fatura);
        assertTrue(processador.verificaFaturaPaga());
        System.out.println(LocalDate.now());
    }

    @DisplayName("Testa a verifica��o correta de uma Fatura n�o paga")
    @Test
    public void testVerificaFaturaEmAberto() {
        Fatura fatura = inicializaFaturaDeAmbienteEmAberto();
        Processador processador = inicializaProcessador(listBoletos, fatura);
        assertFalse(processador.verificaFaturaPaga());
    }

    @DisplayName("Testa se o processador est� criando pagamentos relacionados a fatura")
    @Test
    public void testCriaPagamento() {
        Fatura fatura = inicializaFaturaDeAmbienteEmAberto();
        Processador processador = inicializaProcessador(listBoletos,fatura);
        Pagamento pagamento = processador.criaPagamento();
        Assertions.assertAll("processador",
                () -> assertEquals(400, pagamento.getValor()),
                () -> assertNotNull(pagamento.getData()),
                () -> assertEquals(TipoPagamento.BOLETO, pagamento.getTipoPagamento()));
    }

    private Processador inicializaProcessador(List<Boleto> listBoletos, Fatura fatura) {
        return new Processador(listBoletos, fatura);
    }

    private Fatura inicializaFaturaDeAmbientePago() {
        //Criando fatura de forma a realizar testes com fatura paga
        return new Fatura(DATE, 400, "Jusicreuza");
    }

    private Fatura inicializaFaturaDeAmbienteEmAberto() {
        //Criando faruta de forma a realizar testes com fatura em aberto
        return new Fatura(DATE, 800, "Jusicreuza");
    }


}
