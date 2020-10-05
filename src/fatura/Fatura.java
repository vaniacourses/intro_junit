package fatura;

import fatura.StatusFaturaEnum.StatusFatura;
import pagamento.Pagamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fatura {
    private Date date;
    private double valorTotal;
    private String nomeCliente;
    private StatusFaturaEnum.StatusFatura statusFatura;
    private List<Pagamento> pagamentoList;

    public Fatura() {
    }

    public Fatura(Date date, double valorTotal, String nomeCliente, StatusFatura statusFatura) {
        this.date = date;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.statusFatura = statusFatura;
    }

    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        if (this.pagamentoList == null) {
            this.pagamentoList = new ArrayList<>();
        }
        this.pagamentoList.addAll(pagamentoList);
    }

    public void addPagamentoList(Pagamento pagamento) {
        if (this.pagamentoList == null) {
            this.pagamentoList = new ArrayList<>();
        }
        this.pagamentoList.add(pagamento);
    }

    public StatusFatura getStatusFatura() {
        return statusFatura;
    }

    public void setStatusFatura(StatusFatura statusFatura) {
        this.statusFatura = statusFatura;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
