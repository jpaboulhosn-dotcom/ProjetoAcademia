package app.util;

import app.model.Aluno;
import app.service.AcademiaService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import java.lang.reflect.Type;

import java.util.ArrayList;

public class JsonUtil {

    private static final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();


    public static void exportarAlunos(
            AcademiaService academia,
            String caminho)
            throws IOException {

        try (
                Writer writer =
                        new FileWriter(caminho)
        ) {

            gson.toJson(
                    academia.getAlunos(),
                    writer
            );
        }
    }


    public static int importarAlunos(
            AcademiaService academia,
            String caminho)
            throws IOException {

        Type tipoLista =
                new TypeToken<
                        ArrayList<Aluno>>() {
                }.getType();

        try (
                Reader reader =
                        new FileReader(caminho)
        ) {

            ArrayList<Aluno> alunos =
                    gson.fromJson(
                            reader,
                            tipoLista
                    );

            if (alunos == null) {
                return 0;
            }

            int importados = 0;

            for (Aluno aluno : alunos) {

                if (academia
                        .cadastrarAluno(aluno)) {

                    importados++;
                }
            }

            return importados;
        }
    }
}