package app.service;

import app.model.*;

import java.util.ArrayList;
import java.util.Comparator;

public class AcademiaService {

    private ArrayList<Aluno> alunos =
            new ArrayList<>();

    private ArrayList<Professor> professores =
            new ArrayList<>();

    private ArrayList<Plano> planos =
            new ArrayList<>();

    private ArrayList<Treino> treinos =
            new ArrayList<>();

    private ArrayList<Exercicio> exercicios =
            new ArrayList<>();





    public boolean cadastrarAluno(Aluno aluno) {

        for (Aluno a : alunos) {

            if (a.getCpf()
                    .equalsIgnoreCase(
                            aluno.getCpf())) {

                return false;
            }
        }

        alunos.add(aluno);

        return true;
    }


    public boolean cadastrarProfessor(
            Professor professor) {

        if (buscarProfessorPorId(
                professor.getId()) != null) {

            return false;
        }

        professores.add(professor);

        return true;
    }


    public boolean cadastrarPlano(
            Plano plano) {

        if (buscarPlanoPorId(
                plano.getId()) != null) {

            return false;
        }

        planos.add(plano);

        return true;
    }


    
    public boolean cadastrarTreino(
            Treino treino) {

        if (treino.getProfessor() == null
                || !treino.getProfessor().isAtivo()) {

            return false;
        }

        if (buscarTreinoPorId(
                treino.getId()) != null) {

            return false;
        }

        treinos.add(treino);

        return true;
    }


    public boolean cadastrarExercicio(
            Exercicio exercicio) {

        if (buscarExercicioPorId(
                exercicio.getId()) != null) {

            return false;
        }

        exercicios.add(exercicio);

        return true;
    }





    public Aluno buscarAlunoPorId(int id) {

        for (Aluno a : alunos) {

            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }


    public Professor buscarProfessorPorId(
            int id) {

        for (Professor p : professores) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }


    public Plano buscarPlanoPorId(int id) {

        for (Plano p : planos) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }


    public Treino buscarTreinoPorId(int id) {

        for (Treino t : treinos) {

            if (t.getId() == id) {
                return t;
            }
        }

        return null;
    }


    public Exercicio buscarExercicioPorId(
            int id) {

        for (Exercicio e : exercicios) {

            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }


   

    public ArrayList<Aluno>
    pesquisarAlunoPorNome(String texto) {

        ArrayList<Aluno> resultado =
                new ArrayList<>();

        for (Aluno a : alunos) {

            if (a.getNome()
                    .toLowerCase()
                    .contains(
                            texto.toLowerCase())) {

                resultado.add(a);
            }
        }

        return resultado;
    }




    public boolean editarAluno(
            int id,
            String novoNome,
            String novoCpf) {

        Aluno aluno =
                buscarAlunoPorId(id);

        if (aluno == null) {
            return false;
        }

        for (Aluno a : alunos) {

            if (a.getId() != id
                    && a.getCpf()
                    .equalsIgnoreCase(novoCpf)) {

                return false;
            }
        }

        aluno.setNome(novoNome);
        aluno.setCpf(novoCpf);

        return true;
    }


    public boolean desativarAluno(int id) {

        Aluno aluno =
                buscarAlunoPorId(id);

        if (aluno == null) {
            return false;
        }

        aluno.desativar();

        return true;
    }





   
    public boolean associarPlanoAoAluno(
            int alunoId,
            int planoId) {

        Aluno aluno =
                buscarAlunoPorId(alunoId);

        Plano plano =
                buscarPlanoPorId(planoId);

        if (aluno == null
                || plano == null
                || !aluno.isAtivo()
                || !plano.isAtivo()) {

            return false;
        }

        aluno.associarPlano(plano);

        return true;
    }


  
    public boolean associarTreinoAoAluno(
            int alunoId,
            int treinoId) {

        Aluno aluno =
                buscarAlunoPorId(alunoId);

        Treino treino =
                buscarTreinoPorId(treinoId);

        if (aluno == null
                || treino == null
                || !aluno.isAtivo()) {

            return false;
        }

        return aluno.adicionarTreino(treino);
    }



    public boolean associarExercicioAoTreino(
            int treinoId,
            int exercicioId) {

        Treino treino =
                buscarTreinoPorId(treinoId);

        Exercicio exercicio =
                buscarExercicioPorId(
                        exercicioId);

        if (treino == null
                || exercicio == null) {

            return false;
        }

        return treino.adicionarExercicio(
                exercicio);
    }




 
    public boolean gerarMensalidade(
            int alunoId,
            int pagamentoId,
            String mesReferencia) {

        Aluno aluno =
                buscarAlunoPorId(alunoId);

        if (aluno == null
                || !aluno.isAtivo()
                || aluno.getPlano() == null
                || !aluno.getPlano().isAtivo()) {

            return false;
        }

        Pagamento pagamento =
                new Pagamento(
                        pagamentoId,
                        mesReferencia,
                        aluno.getPlano()
                                .getValorMensal()
                );

        return aluno.adicionarPagamento(
                pagamento);
    }


    public boolean pagarMensalidade(
            int alunoId,
            int pagamentoId) {

        Aluno aluno =
                buscarAlunoPorId(alunoId);

        if (aluno == null) {
            return false;
        }

        for (Pagamento p :
                aluno.getPagamentos()) {

            if (p.getId() == pagamentoId
                    && !p.isPago()) {

                p.pagar();

                return true;
            }
        }

        return false;
    }


    public boolean realizarMatriculaCompleta(
            Aluno aluno,
            int planoId,
            int treinoId,
            int pagamentoId,
            String mesReferencia) {

        Plano plano =
                buscarPlanoPorId(planoId);

        Treino treino =
                buscarTreinoPorId(treinoId);

        if (plano == null
                || treino == null
                || !plano.isAtivo()) {

            return false;
        }

        if (!cadastrarAluno(aluno)) {
            return false;
        }

        aluno.associarPlano(plano);

        aluno.adicionarTreino(treino);

        Pagamento pagamento =
                new Pagamento(
                        pagamentoId,
                        mesReferencia,
                        plano.getValorMensal()
                );

        aluno.adicionarPagamento(
                pagamento);

        return true;
    }



    public ArrayList<Aluno>
    listarAlunosOrdenadosPorNome() {

        ArrayList<Aluno> copia =
                new ArrayList<>(alunos);

        copia.sort(
                Comparator.comparing(
                        Aluno::getNome,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        return copia;
    }




    public double calcularMediaMensalidades() {

        double soma = 0;
        int quantidade = 0;

        for (Aluno a : alunos) {

            if (a.isAtivo()
                    && a.getPlano() != null) {

                soma +=
                        a.getPlano()
                                .getValorMensal();

                quantidade++;
            }
        }

        if (quantidade == 0) {
            return 0;
        }

        return soma / quantidade;
    }


  
    public double calcularTotalArrecadado() {

        double total = 0;

        for (Aluno a : alunos) {
            total += a.calcularTotalPago();
        }

        return total;
    }


    public Plano encontrarPlanoMaisCaro() {

        Plano maior = null;

        for (Plano p : planos) {

            if (maior == null
                    || p.getValorMensal()
                    > maior.getValorMensal()) {

                maior = p;
            }
        }

        return maior;
    }

    public ArrayList<Aluno>
    rankingAlunosPorTotalPago() {

        ArrayList<Aluno> ranking =
                new ArrayList<>(alunos);

        ranking.sort(
                (a, b) ->
                        Double.compare(
                                b.calcularTotalPago(),
                                a.calcularTotalPago()
                        )
        );

        return ranking;
    }


    
    public double calcularTaxaInadimplencia() {

        if (alunos.isEmpty()) {
            return 0;
        }

        int comPendencia = 0;

        for (Aluno a : alunos) {

            if (a.contarPagamentosPendentes()
                    > 0) {

                comPendencia++;
            }
        }

        return (comPendencia * 100.0)
                / alunos.size();
    }


    public int contarAlunosAtivos() {

        int total = 0;

        for (Aluno a : alunos) {

            if (a.isAtivo()) {
                total++;
            }
        }

        return total;
    }




    public void gerarRelatorioGeral() {

        System.out.println(
                "\n===== RELATORIO GERAL ====="
        );

        System.out.println(
                "Alunos cadastrados: "
                        + alunos.size()
        );

        System.out.println(
                "Alunos ativos: "
                        + contarAlunosAtivos()
        );

        System.out.printf(
                "Media das mensalidades: R$ %.2f%n",
                calcularMediaMensalidades()
        );

        System.out.printf(
                "Total arrecadado: R$ %.2f%n",
                calcularTotalArrecadado()
        );

        Plano maior =
                encontrarPlanoMaisCaro();

        if (maior == null) {

            System.out.println(
                    "Plano mais caro: Nenhum"
            );

        } else {

            System.out.printf(
                    "Plano mais caro: %s - R$ %.2f%n",
                    maior.getNome(),
                    maior.getValorMensal()
            );
        }

        System.out.printf(
                "Taxa de inadimplencia: %.2f%%%n",
                calcularTaxaInadimplencia()
        );

        System.out.println(
                "Ranking por total pago:"
        );

        int posicao = 1;

        for (Aluno a :
                rankingAlunosPorTotalPago()) {

            System.out.printf(
                    "%dº %s - R$ %.2f%n",
                    posicao,
                    a.getNome(),
                    a.calcularTotalPago()
            );

            posicao++;
        }

        System.out.println(
                "===========================\n"
        );
    }





    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(
            ArrayList<Aluno> alunos) {

        this.alunos = alunos;
    }

    public ArrayList<Professor>
    getProfessores() {

        return professores;
    }

    public ArrayList<Plano> getPlanos() {
        return planos;
    }

    public ArrayList<Treino> getTreinos() {
        return treinos;
    }

    public ArrayList<Exercicio>
    getExercicios() {

        return exercicios;
    }
}
