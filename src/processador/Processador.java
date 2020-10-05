package processador;

import boleto.Boleto;
import fatura.Fatura;
import fatura.StatusFaturaEnum.StatusFatura;
import pagamento.Pagamento;
import pagamento.TipoPagamentoEnum.TipoPagamento;

import java.util.List;

public class Processador {

    public static double getValorTotalBoletos(List<Boleto> boletoList) {
        double valorTotal = 0;
        for (Boleto boleto : boletoList) {
            valorTotal = valorTotal + boleto.getValorPago();
        }
        return valorTotal;
    }

    public static void criaPagamentos(List<Boleto> boletoList, Fatura fatura) {
        for (Boleto boleto : boletoList) {
            Pagamento pagamento = new Pagamento(boleto.getValorPago(), boleto.getData(), TipoPagamento.BOLETO);
            fatura.addPagamentoList(pagamento);
        }
    }

    private static void setFaturaPaga(Fatura fatura) {
        fatura.setStatusFatura(StatusFatura.PAGA);
    }

    public static boolean verificaFaturaPaga(List<Boleto> boletoList, Fatura fatura) {
        double valorTotalPago = Processador.getValorTotalBoletos(boletoList);
        if (valorTotalPago >= fatura.getValorTotal()) {
            Processador.setFaturaPaga(fatura);
            return true;
        }
        return false;
    }

}
