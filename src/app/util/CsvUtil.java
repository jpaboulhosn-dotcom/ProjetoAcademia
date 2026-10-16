package app.util;

import app.model.Aluno;
import app.service.AcademiaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvUtil {

    public static void exportarAlunos(
            AcademiaService academia,
            String caminho)
            throws IOException {

        try (
                PrintWriter writer =
                        new PrintWriter(
                                new FileWriter(caminho)
                        )
        ) {

            writer.println(
                    "id;nome;cpf;ativo"
            );

            for (Aluno a :
                    academia.getAlunos()) {

                writer.println(
                        a.getId()
                                + ";"
                                + a.getNome()
                                + ";"
                                + a.getCpf()
                                + ";"
                                + a.isAtivo()
                );
            }
        }
    }


    public static int importarAlunos(
            AcademiaService academia,
            String caminho)
            throws IOException {

        int importados = 0;

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(caminho)
                        )
        ) {

            
            reader.readLine();

            String linha;

            while ((linha =
                    reader.readLine()) != null) {

                String[] partes =
                        linha.split(";");

                if (partes.length >= 4) {

                    int id =
                            Integer.parseInt(
                                    partes[0]
                            );

                    String nome =
                            partes[1];

                    String cpf =
                            partes[2];

                    boolean ativo =
                            Boolean.parseBoolean(
                                    partes[3]
                            );

                    Aluno aluno =
                            new Aluno(
                                    id,
                                    nome,
                                    cpf
                            );

                    if (academia
                            .cadastrarAluno(aluno)) {

                        if (!ativo) {
                            aluno.desativar();
                        }

                        importados++;
                    }
                }
            }
        }

        return importados;
    }
}
