package processador;

import boleto.Boleto;
import fatura.Fatura;
import fatura.StatusFaturaEnum.StatusFatura;
import pagamento.Pagamento;
import pagamento.TipoPagamentoEnum.TipoPagamento;

import java.util.List;

public class Processador {

    public List<Boleto> boletoList;
    public Fatura fatura;

    public Processador(List<Boleto> boletoList, Fatura fatura) {
        this.fatura = fatura;
        this.boletoList = boletoList;
    }

    public void criaPagamentos() {
        for (Boleto boleto : boletoList) {
            Pagamento pagamento = new Pagamento(boleto.getValorPago(), boleto.getData(), TipoPagamento.BOLETO);
            fatura.addPagamentoList(pagamento);
        }
    }

    private double getValorTotalPago() {
        double valorTotal = 0;
        for (Boleto boleto : boletoList) {
            valorTotal = valorTotal + boleto.getValorPago();
        }
        return valorTotal;
    }

    public boolean verificaFaturaPaga() {
        double valorTotalPago = getValorTotalPago();
        if (valorTotalPago >= fatura.getValorTotal()) {
            setFaturaPaga();
            return true;
        }
        return false;
    }

    private void setFaturaPaga() {
        fatura.setStatusFatura(StatusFatura.PAGA);
    }

}
