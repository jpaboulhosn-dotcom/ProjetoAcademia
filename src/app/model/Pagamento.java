package app.model;

public class Pagamento {
    private int id;
    private String mesReferencia;
    private double valor;
    private boolean pago;

    public Pagamento(
            int id,
            String mesReferencia,
            double valor) {

        this.id = id;
        this.mesReferencia = mesReferencia;
        this.valor = valor;
        this.pago = false;
    }

    public int getId() {
        return id;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void pagar() {
        this.pago = true;
    }

    @Override
    public String toString() {
        return "Pagamento{id=" + id
                + ", mes='" + mesReferencia
                + "', valor=R$ "
                + String.format("%.2f", valor)
                + ", pago=" + pago
                + "}";
    }
}
