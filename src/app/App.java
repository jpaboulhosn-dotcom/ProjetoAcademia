package app;

import app.model.*;
import app.service.AcademiaService;
import app.util.CsvUtil;
import app.util.JsonUtil;

import java.io.IOException;
import java.util.Scanner;

public class App {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final AcademiaService academia =
            new AcademiaService();


    public static void main(String[] args) {

        carregarDadosIniciais();

        int opcao;

        do {

            mostrarMenu();

            opcao =
                    lerInteiro(
                            "Escolha uma opcao: "
                    );

            switch (opcao) {

                case 1 ->
                        cadastrarAluno();

                case 2 ->
                        consultarAluno();

                case 3 ->
                        editarAluno();

                case 4 ->
                        listarAlunos();

                case 5 ->
                        desativarAluno();

                case 6 ->
                        pesquisarAluno();

                case 7 ->
                        listarOrdenados();

                case 8 ->
                        associarPlano();

                case 9 ->
                        associarTreino();

                case 10 ->
                        associarExercicio();

                case 11 ->
                        gerarMensalidade();

                case 12 ->
                        pagarMensalidade();

                case 13 ->
                        matriculaCompleta();

                case 14 ->
                        academia
                                .gerarRelatorioGeral();

                case 15 ->
                        exportarCsv();

                case 16 ->
                        importarCsv();

                case 17 ->
                        exportarJson();

                case 18 ->
                        importarJson();

                case 0 ->
                        System.out.println(
                                "Programa encerrado."
                        );

                default ->
                        System.out.println(
                                "Opcao invalida."
                        );
            }

        } while (opcao != 0);
    }


    private static void mostrarMenu() {

        System.out.println(
                "\n========= SISTEMA DA ACADEMIA ========="
        );

        System.out.println(
                "1  - Cadastrar aluno"
        );

        System.out.println(
                "2  - Consultar aluno por ID"
        );

        System.out.println(
                "3  - Editar aluno"
        );

        System.out.println(
                "4  - Listar alunos"
        );

        System.out.println(
                "5  - Desativar aluno"
        );

        System.out.println(
                "6  - Pesquisar aluno por nome"
        );

        System.out.println(
                "7  - Ordenar alunos por nome"
        );

        System.out.println(
                "8  - Associar plano ao aluno"
        );

        System.out.println(
                "9  - Associar treino ao aluno"
        );

        System.out.println(
                "10 - Associar exercicio ao treino"
        );

        System.out.println(
                "11 - Gerar mensalidade"
        );

        System.out.println(
                "12 - Registrar pagamento"
        );

        System.out.println(
                "13 - Realizar matricula completa"
        );

        System.out.println(
                "14 - Gerar relatorio e indicadores"
        );

        System.out.println(
                "15 - Exportar alunos para CSV"
        );

        System.out.println(
                "16 - Importar alunos de CSV"
        );

        System.out.println(
                "17 - Exportar alunos para JSON"
        );

        System.out.println(
                "18 - Importar alunos de JSON"
        );

        System.out.println(
                "0  - Sair"
        );
    }


    private static void cadastrarAluno() {

        int id =
                lerInteiro("ID: ");

        String nome =
                lerTexto("Nome: ");

        String cpf =
                lerTexto("CPF: ");

        Aluno aluno =
                new Aluno(
                        id,
                        nome,
                        cpf
                );

        boolean cadastrou =
                academia.cadastrarAluno(
                        aluno
                );

        if (cadastrou) {

            System.out.println(
                    "Aluno cadastrado."
            );

        } else {

            System.out.println(
                    "Nao foi possivel cadastrar. CPF repetido."
            );
        }
    }


    private static void consultarAluno() {

        int id =
                lerInteiro(
                        "ID do aluno: "
                );

        Aluno aluno =
                academia
                        .buscarAlunoPorId(id);

        if (aluno == null) {

            System.out.println(
                    "Aluno nao encontrado."
            );

        } else {

            System.out.println(aluno);

            System.out.println(
                    "Treinos: "
                            + aluno.getTreinos()
            );

            System.out.println(
                    "Pagamentos: "
                            + aluno.getPagamentos()
            );
        }
    }


    private static void editarAluno() {

        int id =
                lerInteiro(
                        "ID do aluno: "
                );

        String nome =
                lerTexto(
                        "Novo nome: "
                );

        String cpf =
                lerTexto(
                        "Novo CPF: "
                );

        boolean editou =
                academia.editarAluno(
                        id,
                        nome,
                        cpf
                );

        if (editou) {

            System.out.println(
                    "Aluno editado."
            );

        } else {

            System.out.println(
                    "Nao foi possivel editar."
            );
        }
    }


    private static void listarAlunos() {

        System.out.println(
                "\n--- ALUNOS ---"
        );

        for (Aluno a :
                academia.getAlunos()) {

            System.out.println(a);
        }
    }


    private static void desativarAluno() {

        int id =
                lerInteiro(
                        "ID do aluno: "
                );

        boolean desativou =
                academia.desativarAluno(id);

        if (desativou) {

            System.out.println(
                    "Aluno desativado."
            );

        } else {

            System.out.println(
                    "Aluno nao encontrado."
            );
        }
    }


    private static void pesquisarAluno() {

        String nome =
                lerTexto(
                        "Nome ou parte do nome: "
                );

        for (Aluno a :
                academia
                        .pesquisarAlunoPorNome(
                                nome)) {

            System.out.println(a);
        }
    }


    private static void listarOrdenados() {

        for (Aluno a :
                academia
                        .listarAlunosOrdenadosPorNome()) {

            System.out.println(a);
        }
    }


    private static void associarPlano() {

        listarPlanos();

        int alunoId =
                lerInteiro(
                        "ID do aluno: "
                );

        int planoId =
                lerInteiro(
                        "ID do plano: "
                );

        boolean ok =
                academia
                        .associarPlanoAoAluno(
                                alunoId,
                                planoId
                        );

        if (ok) {

            System.out.println(
                    "Plano associado."
            );

        } else {

            System.out.println(
                    "Nao foi possivel associar."
            );
        }
    }


    private static void associarTreino() {

        listarTreinos();

        int alunoId =
                lerInteiro(
                        "ID do aluno: "
                );

        int treinoId =
                lerInteiro(
                        "ID do treino: "
                );

        boolean ok =
                academia
                        .associarTreinoAoAluno(
                                alunoId,
                                treinoId
                        );

        if (ok) {

            System.out.println(
                    "Treino associado."
            );

        } else {

            System.out.println(
                    "Nao foi possivel associar ou treino ja existe."
            );
        }
    }


    private static void associarExercicio() {

        listarTreinos();
        listarExercicios();

        int treinoId =
                lerInteiro(
                        "ID do treino: "
                );

        int exercicioId =
                lerInteiro(
                        "ID do exercicio: "
                );

        boolean ok =
                academia
                        .associarExercicioAoTreino(
                                treinoId,
                                exercicioId
                        );

        if (ok) {

            System.out.println(
                    "Exercicio associado."
            );

        } else {

            System.out.println(
                    "Nao foi possivel associar ou exercicio ja existe."
            );
        }
    }


    private static void gerarMensalidade() {

        int alunoId =
                lerInteiro(
                        "ID do aluno: "
                );

        int pagamentoId =
                lerInteiro(
                        "ID do pagamento: "
                );

        String mes =
                lerTexto(
                        "Mes de referencia (ex: 10/2026): "
                );

        boolean ok =
                academia
                        .gerarMensalidade(
                                alunoId,
                                pagamentoId,
                                mes
                        );

        if (ok) {

            System.out.println(
                    "Mensalidade gerada."
            );

        } else {

            System.out.println(
                    "Nao foi possivel gerar. Verifique plano, status ou mes repetido."
            );
        }
    }


    private static void pagarMensalidade() {

        int alunoId =
                lerInteiro(
                        "ID do aluno: "
                );

        int pagamentoId =
                lerInteiro(
                        "ID do pagamento: "
                );

        boolean ok =
                academia
                        .pagarMensalidade(
                                alunoId,
                                pagamentoId
                        );

        if (ok) {

            System.out.println(
                    "Pagamento registrado."
            );

        } else {

            System.out.println(
                    "Pagamento nao encontrado ou ja pago."
            );
        }
    }


    private static void matriculaCompleta() {

        System.out.println(
                "\n--- MATRICULA COMPLETA ---"
        );

        int id =
                lerInteiro(
                        "ID do novo aluno: "
                );

        String nome =
                lerTexto("Nome: ");

        String cpf =
                lerTexto("CPF: ");

        Aluno aluno =
                new Aluno(
                        id,
                        nome,
                        cpf
                );

        listarPlanos();

        int planoId =
                lerInteiro(
                        "ID do plano: "
                );

        listarTreinos();

        int treinoId =
                lerInteiro(
                        "ID do treino inicial: "
                );

        int pagamentoId =
                lerInteiro(
                        "ID da primeira mensalidade: "
                );

        String mes =
                lerTexto(
                        "Mes de referencia: "
                );

        boolean ok =
                academia
                        .realizarMatriculaCompleta(
                                aluno,
                                planoId,
                                treinoId,
                                pagamentoId,
                                mes
                        );

        if (ok) {

            System.out.println(
                    "Matricula concluida: aluno + plano + mensalidade + treino."
            );

        } else {

            System.out.println(
                    "Nao foi possivel concluir a matricula."
            );
        }
    }


    private static void exportarCsv() {

        try {

            CsvUtil.exportarAlunos(
                    academia,
                    "alunos.csv"
            );

            System.out.println(
                    "Arquivo alunos.csv criado."
            );

        } catch (IOException e) {

            System.out.println(
                    "Erro ao exportar CSV: "
                            + e.getMessage()
            );
        }
    }


    private static void importarCsv() {

        try {

            int quantidade =
                    CsvUtil.importarAlunos(
                            academia,
                            "alunos.csv"
                    );

            System.out.println(
                    quantidade
                            + " aluno(s) importado(s) do CSV."
            );

        } catch (IOException e) {

            System.out.println(
                    "Erro ao importar CSV: "
                            + e.getMessage()
            );
        }
    }


    private static void exportarJson() {

        try {

            JsonUtil.exportarAlunos(
                    academia,
                    "alunos.json"
            );

            System.out.println(
                    "Arquivo alunos.json criado."
            );

        } catch (IOException e) {

            System.out.println(
                    "Erro ao exportar JSON: "
                            + e.getMessage()
            );
        }
    }


    private static void importarJson() {

        try {

            int quantidade =
                    JsonUtil.importarAlunos(
                            academia,
                            "alunos.json"
                    );

            System.out.println(
                    quantidade
                            + " aluno(s) importado(s) do JSON."
            );

        } catch (IOException e) {

            System.out.println(
                    "Erro ao importar JSON: "
                            + e.getMessage()
            );
        }
    }


    private static void listarPlanos() {

        System.out.println(
                "\n--- PLANOS ---"
        );

        for (Plano p :
                academia.getPlanos()) {

            System.out.println(p);
        }
    }


    private static void listarTreinos() {

        System.out.println(
                "\n--- TREINOS ---"
        );

        for (Treino t :
                academia.getTreinos()) {

            System.out.println(t);
        }
    }


    private static void listarExercicios() {

        System.out.println(
                "\n--- EXERCICIOS ---"
        );

        for (Exercicio e :
                academia.getExercicios()) {

            System.out.println(e);
        }
    }


    private static void carregarDadosIniciais() {

        Professor p1 =
                new Professor(
                        1,
                        "Carlos",
                        "Musculacao"
                );

        Professor p2 =
                new Professor(
                        2,
                        "Marina",
                        "Condicionamento"
                );

        academia.cadastrarProfessor(p1);
        academia.cadastrarProfessor(p2);


        Plano plano1 =
                new Plano(
                        1,
                        "Basico",
                        100.00,
                        1
                );

        Plano plano2 =
                new Plano(
                        2,
                        "Trimestral",
                        90.00,
                        3
                );

        Plano plano3 =
                new Plano(
                        3,
                        "Premium",
                        150.00,
                        1
                );

        academia.cadastrarPlano(plano1);
        academia.cadastrarPlano(plano2);
        academia.cadastrarPlano(plano3);


        Exercicio e1 =
                new Exercicio(
                        1,
                        "Supino reto",
                        "Peito",
                        3,
                        10
                );

        Exercicio e2 =
                new Exercicio(
                        2,
                        "Agachamento",
                        "Pernas",
                        3,
                        12
                );

        Exercicio e3 =
                new Exercicio(
                        3,
                        "Remada",
                        "Costas",
                        3,
                        10
                );

        academia.cadastrarExercicio(e1);
        academia.cadastrarExercicio(e2);
        academia.cadastrarExercicio(e3);


        Treino t1 =
                new Treino(
                        1,
                        "Treino iniciante",
                        p1
                );

        t1.adicionarExercicio(e1);
        t1.adicionarExercicio(e2);

        academia.cadastrarTreino(t1);


        Treino t2 =
                new Treino(
                        2,
                        "Treino superiores",
                        p2
                );

        t2.adicionarExercicio(e1);
        t2.adicionarExercicio(e3);

        academia.cadastrarTreino(t2);
    }


    private static int lerInteiro(
            String mensagem) {

        while (true) {

            try {

                System.out.print(
                        mensagem
                );

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (
                    NumberFormatException e) {

                System.out.println(
                        "Digite um numero inteiro valido."
                );
            }
        }
    }


    private static String lerTexto(
            String mensagem) {

        System.out.print(
                mensagem
        );

        return scanner.nextLine();
    }
}
