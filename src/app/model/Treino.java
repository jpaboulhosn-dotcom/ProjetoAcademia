package app.model;

import java.util.ArrayList;

public class Treino {
    private int id;
    private String nome;
    private Professor professor;
    private ArrayList<Exercicio> exercicios;

    public Treino(
            int id,
            String nome,
            Professor professor) {

        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.exercicios = new ArrayList<>();
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

    public Professor getProfessor() {
        return professor;
    }

    public ArrayList<Exercicio> getExercicios() {
        return exercicios;
    }

  
    public boolean adicionarExercicio(
            Exercicio exercicio) {

        for (Exercicio e : exercicios) {

            if (e.getId() == exercicio.getId()) {
                return false;
            }
        }

        exercicios.add(exercicio);
        return true;
    }

    @Override
    public String toString() {
        return "Treino{id=" + id
                + ", nome='" + nome
                + "', professor='" + professor.getNome()
                + "', exercicios=" + exercicios.size()
                + "}";
    }
}
