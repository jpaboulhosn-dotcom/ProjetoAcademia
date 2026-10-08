package app.model;


public class Plano {
    private int id;
    private String nome;
    private double valorMensal;
    private int duracaoMeses;
    private boolean ativo;

    public Plano(
            int id,
            String nome,
            double valorMensal,
            int duracaoMeses) {

        this.id = id;
        this.nome = nome;
        this.valorMensal = valorMensal;
        this.duracaoMeses = duracaoMeses;
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Plano{id=" + id
                + ", nome='" + nome
                + "', valorMensal=R$ "
                + String.format("%.2f", valorMensal)
                + ", duracaoMeses=" + duracaoMeses
                + ", ativo=" + ativo
                + "}";
    }
}