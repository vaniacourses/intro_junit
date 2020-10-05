package pagamento;

import pagamento.TipoPagamentoEnum.TipoPagamento;

import java.util.Date;

public class Pagamento {
    private double valorPago;
    private Date date;
    private TipoPagamento tipoPagamento;

    public Pagamento() {
    }

    public Pagamento(double valorPago, Date date, TipoPagamento tipoPagamento) {
        this.valorPago = valorPago;
        this.date = date;
        this.tipoPagamento = tipoPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
