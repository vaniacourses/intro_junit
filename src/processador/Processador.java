package processador;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;
import pagamento.TipoPagamentoEnum;

import java.util.Date;
import java.util.List;

public class Processador {

    public List<Boleto> boletoList;
    public Fatura fatura;

    public Processador(List<Boleto> boletoList, Fatura fatura) {
        this.fatura = fatura;
        this.boletoList = boletoList;
    }

    public Pagamento criaPagamento() {
        double valorTotalPagemento = getValorTotalPago();
        Date date = new Date(System.currentTimeMillis());
        return new Pagamento(valorTotalPagemento, date, TipoPagamentoEnum.TipoPagamento.BOLETO);
    }

    private double getValorTotalPago() {
        double valorTotal = 0;
        for (Boleto boleto : boletoList) {
            valorTotal = valorTotal + boleto.getValorPago();
        }
        return valorTotal;
    }

    public boolean verificaFaturaPaga(){
        double valorTotalPago = getValorTotalPago();
        return valorTotalPago >= fatura.getValorTotal();
    }

}
