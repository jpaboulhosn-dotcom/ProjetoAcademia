package app.model;


public class Professor {
    private int id;
    private String nome;
    private String especialidade;
    private boolean ativo;

    public Professor(
            int id,
            String nome,
            String especialidade) {

        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(
            String especialidade) {

        this.especialidade = especialidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Professor{id=" + id
                + ", nome='" + nome
                + "', especialidade='" + especialidade
                + "', ativo=" + ativo
                + "}";
    }
}