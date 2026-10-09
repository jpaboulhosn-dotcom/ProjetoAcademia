Sistema de Gerenciamento de Academia

1. Definicao do problema

Academias pequenas muitas vezes precisam controlar alunos, professores, planos, treinos, exercicios e pagamentos de forma organizada.

Este projeto cria uma aplicacao Java simples para ajudar nesse controle. O sistema permite cadastrar e consultar alunos, associar planos e treinos, controlar pagamentos e gerar indicadores e relatorios.

Possiveis usuarios

● funcionarios da recepcao;

● administradores da academia;

● professores que desejem consultar treinos cadastrados.

2. Classes de dominio

O projeto possui 6 classes principais de dominio:

1. Aluno

2. Professor

3. Plano

4. Treino

5. Exercicio

6. Pagamento

Tambem existem:

● Academia: organiza as listas e concentra as operacoes principais do sistema;

● Main: possui o menu e permite a interacao com o usuario pelo terminal.

3. Relacionamentos entre classes

Os principais relacionamentos sao:

● Um Aluno possui um Plano.

● Um Aluno possui varios Treino.

● Um Aluno possui varios Pagamento.

● Um Treino possui um Professor responsavel.

● Um Treino possui varios Exercicio.

Exemplo:

Aluno -> Plano

Aluno -> varios Treinos

Aluno -> varios Pagamentos

Treino -> Professor

Treino -> varios Exercicios

O projeto usa composicao e associacao entre objetos, sem necessidade de heranca.

4. Uso de colecoes

O projeto utiliza ArrayList em varias classes.

Classe Aluno

Possui:

private ArrayList<Treino> treinos;

private ArrayList<Pagamento> pagamentos;

Classe Treino

Possui:

private ArrayList<Exercicio> exercicios;

Classe Academia

Mantem colecoes de alunos, professores, planos, treinos e exercicios.

5. Encapsulamento

Todos os atributos das classes sao privados.

O acesso aos dados ocorre por construtores, getters, setters e metodos especificos.

Exemplo:

private String nome;



public String getNome() {

    return nome;

}



public void setNome(String nome) {

    this.nome = nome;

}

6. Operacoes obrigatorias implementadas

Cadastrar

O sistema permite cadastrar:

● alunos;

● professores;

● planos;

● exercicios;

● treinos.

Consultar

E possivel consultar um aluno pelo ID.

Editar

E possivel editar o nome e o CPF de um aluno.

Listar

O sistema lista alunos e tambem apresenta listas auxiliares de planos, professores, exercicios e treinos.

Remover ou desativar

Foi escolhida a opcao de desativar um aluno.

Isso evita apagar o registro completamente e representa melhor um sistema real.

Associar objetos

O sistema permite:

● associar um plano a um aluno;

● associar um exercicio a um treino;

● associar um treino a um aluno.

Pesquisar objetos

E possivel pesquisar alunos por nome ou por parte do nome.

Ordenar objetos

Os alunos podem ser listados em ordem alfabetica pelo nome.

Executar regras de negocio

Uma das regras de negocio e a geracao de pagamentos.

Um pagamento so pode ser criado se:

● o aluno existir;

● o aluno estiver ativo;

● o aluno possuir um plano.

O valor da mensalidade e obtido automaticamente do plano associado ao aluno.

Outra regra e que um treino so pode ser criado com um professor ativo.

Calcular indicadores

O sistema calcula:

● quantidade de alunos ativos;

● quantidade de pagamentos pendentes;

● valor total arrecadado.

Gerar relatorios

O relatorio geral apresenta:

● total de alunos;

● alunos ativos;

● professores cadastrados;

● planos cadastrados;

● treinos cadastrados;

● exercicios cadastrados;

● pagamentos pendentes;

● total arrecadado.

7. Como executar

No terminal, dentro da pasta do projeto:

javac *.java

java Main

Tambem e possivel abrir a pasta em uma IDE como IntelliJ IDEA, Eclipse ou VS Code.

8. Explicacao simples da organizacao

A ideia principal do projeto e separar responsabilidades:

● Aluno guarda informacoes do aluno e suas listas de treinos e pagamentos.

● Professor guarda os dados do professor.

● Plano guarda informacoes de preco e duracao.

● Exercicio representa um exercicio individual.

● Treino agrupa exercicios e possui um professor responsavel.

● Pagamento controla uma mensalidade.

● Academia guarda os cadastros e realiza operacoes que envolvem mais de uma classe.

● App mostra o menu e recebe os dados digitados pelo usuario.

Essa divisao facilita a explicacao do projeto porque cada classe possui uma responsabilidade clara.
