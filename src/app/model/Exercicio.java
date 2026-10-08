package app.model;


public class Exercicio {
    private int id;
    private String nome;
    private String grupoMuscular;
    private int series;
    private int repeticoes;

    public Exercicio(
            int id,
            String nome,
            String grupoMuscular,
            int series,
            int repeticoes) {

        this.id = id;
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.series = series;
        this.repeticoes = repeticoes;
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

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(
            String grupoMuscular) {

        this.grupoMuscular = grupoMuscular;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return "Exercicio{id=" + id
                + ", nome='" + nome
                + "', grupo='" + grupoMuscular
                + "', series=" + series
                + ", repeticoes=" + repeticoes
                + "}";
    }
}