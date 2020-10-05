package boleto;

import java.util.Date;

public class Boleto {

    private String codigo;
    private Date data;
    private double valorPago;

    public Boleto() {
    }

    public Boleto(String codigo, Date data, double valorPago) {
        this.codigo = codigo;
        this.data = data;
        this.valorPago = valorPago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }


}
