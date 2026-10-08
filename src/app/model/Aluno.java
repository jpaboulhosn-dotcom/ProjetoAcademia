package app.model;
import java.util.ArrayList;

public class Aluno {
    private int id;
    private String nome;
    private String cpf;
    private boolean ativo;
    private Plano plano;
    private ArrayList<Treino> treinos;
    private ArrayList<Pagamento> pagamentos;

    public Aluno(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ativo = true;
        this.treinos = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Plano getPlano() {
        return plano;
    }

    public ArrayList<Treino> getTreinos() {
        return treinos;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void desativar() {
        this.ativo = false;
    }

    public void associarPlano(Plano plano) {
        this.plano = plano;
    }

    public boolean adicionarTreino(Treino treino) {
        for (Treino t : treinos) {
            if (t.getId() == treino.getId()) {
                return false;
            }
        }

        treinos.add(treino);
        return true;
    }

    public boolean adicionarPagamento(Pagamento pagamento) {
        for (Pagamento p : pagamentos) {
            if (p.getMesReferencia()
                    .equalsIgnoreCase(pagamento.getMesReferencia())) {

                return false;
            }
        }

        pagamentos.add(pagamento);
        return true;
    }

    public double calcularTotalPago() {
        double total = 0;

        for (Pagamento p : pagamentos) {
            if (p.isPago()) {
                total += p.getValor();
            }
        }

        return total;
    }

    public int contarPagamentosPendentes() {
        int total = 0;

        for (Pagamento p : pagamentos) {
            if (!p.isPago()) {
                total++;
            }
        }

        return total;
    }

    @Override
    public String toString() {
        String nomePlano =
                plano == null ? "Sem plano" : plano.getNome();

        return "Aluno{id=" + id
                + ", nome='" + nome
                + "', cpf='" + cpf
                + "', ativo=" + ativo
                + ", plano='" + nomePlano
                + "', treinos=" + treinos.size()
                + ", pagamentos=" + pagamentos.size()
                + "}";
    }
}
