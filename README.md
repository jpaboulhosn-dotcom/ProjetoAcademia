# Sistema de Gerenciamento e Análise de Academia

 Integrantes

| Integrante | Responsabilidade |
|---|---|
| João Paulo Hosn | Responsável pelas classes do pacote `model`, README e pela implementação das tecnologias externas, incluindo CSV e JSON. |
| Davi Ribeiro | Responsável pelas classes `AcademiaService`, `App`, pelo arquivo `pom.xml` e também o README. 

---

 # Descrição do problema

O projeto consiste em um sistema de gerenciamento de academia desenvolvido em Java utilizando Programação Orientada a Objetos.

O sistema foi criado para organizar informações relacionadas a alunos, professores, planos, treinos, exercícios e pagamentos.

Em uma academia, o gerenciamento manual dessas informações pode causar dificuldades no controle de mensalidades, organização de treinos, cadastro de alunos e geração de informações administrativas.

O sistema busca centralizar essas informações e facilitar o gerenciamento da academia por meio de um menu interativo no terminal.

Os possíveis usuários do sistema são funcionários da recepção, administradores da academia e responsáveis pelo controle financeiro.

---

 # Funcionalidades

O sistema possui as seguintes funcionalidades:

- cadastrar alunos;
- consultar alunos por ID;
- editar dados de alunos;
- listar alunos;
- desativar alunos;
- pesquisar alunos pelo nome;
- ordenar alunos alfabeticamente;
- associar planos aos alunos;
- associar treinos aos alunos;
- associar exercícios aos treinos;
- gerar mensalidades;
- registrar pagamentos;
- realizar matrícula completa;
- gerar relatórios e indicadores;
- exportar alunos para CSV;
- importar alunos de CSV;
- exportar alunos para JSON;
- importar alunos de JSON.

---

 Principais classes

 # Aluno

Representa um aluno cadastrado na academia.

Possui informações como:

- ID;
- nome;
- CPF;
- situação ativa ou inativa;
- plano;
- lista de treinos;
- lista de pagamentos.

A classe utiliza `ArrayList` para armazenar os treinos e pagamentos relacionados ao aluno.

---

# Professor

Representa um professor da academia.

Possui:

- ID;
- nome;
- especialidade;
- situação ativa ou inativa.

O professor pode ser associado a um treino.

---

# Plano

Representa um plano oferecido pela academia.

Possui:

- ID;
- nome;
- valor mensal;
- duração em meses;
- situação ativa ou inativa.

O plano pode ser associado a um aluno e seu valor é utilizado na geração das mensalidades.

---

# Treino

Representa um treino da academia.

Possui:

- ID;
- nome;
- professor responsável;
- lista de exercícios.

A classe utiliza `ArrayList<Exercicio>` para armazenar os exercícios que fazem parte do treino.

---

# Exercicio

Representa um exercício físico.

Possui:

- ID;
- nome;
- grupo muscular;
- quantidade de séries;
- quantidade de repetições.

---

# Pagamento

Representa uma mensalidade ou pagamento realizado pelo aluno.

Possui:

- ID;
- mês de referência;
- valor;
- situação do pagamento.

O pagamento pode estar pendente ou pago.

---

# AcademiaService

É a classe responsável pelas principais operações e regras de negócio do sistema.

Entre suas responsabilidades estão:

- cadastro;
- consulta;
- edição;
- pesquisa;
- ordenação;
- associação de objetos;
- geração de mensalidades;
- registro de pagamentos;
- cálculo de indicadores;
- geração de relatórios.

Essa classe evita que toda a lógica do sistema fique concentrada na classe `App`.

---

# CsvUtil

Responsável pela importação e exportação de dados utilizando arquivos CSV.

Permite transformar objetos Java em dados de arquivo e também ler dados do arquivo para criar novos objetos no sistema.

---

# JsonUtil

Responsável pela importação e exportação de dados utilizando JSON.

Para trabalhar com JSON, o projeto utiliza a biblioteca Gson.

---

# App

É a classe principal do sistema.

Possui o método:

```java
public static void main(String[] args)

Essa classe é responsável por:
- mostrar o menu;
- receber os dados digitados pelo usuário;
- chamar os métodos das outras classes.
Relacionamentos entre as classes
As principais relações do sistema são:
Aluno → possui um Plano
Aluno → possui vários Treinos
Aluno → possui vários Pagamentos
Treino → possui um Professor
Treino → possui vários Exercícios

Essas relações demonstram o uso de associação, composição e coleções de objetos.
Regras de negócio
O sistema possui diferentes regras de negócio relacionadas ao funcionamento de uma academia.
1. CPF único
Não é permitido cadastrar dois alunos com o mesmo CPF.
2. Professor ativo
Um treino só pode ser cadastrado caso o professor responsável esteja ativo.
3. Associação de plano
Um plano só pode ser associado quando:
- o aluno existe;
- o aluno está ativo;
- o plano existe;
- o plano está ativo.
4. Treino duplicado
O mesmo treino não pode ser associado duas vezes ao mesmo aluno.
5. Exercício duplicado
O mesmo exercício não pode ser adicionado duas vezes ao mesmo treino.
6. Geração de mensalidade
Uma mensalidade só pode ser gerada se:
- o aluno estiver ativo;
- possuir um plano;
- o plano estiver ativo.
O valor da mensalidade é definido automaticamente de acordo com o valor do plano do aluno.
Também não é permitido gerar uma mensalidade repetida para o mesmo mês.
7. Pagamento duplicado
Um pagamento que já foi registrado como pago não pode ser pago novamente.
Funcionalidade principal
A principal funcionalidade do projeto é o processo de matrícula completa.
O fluxo é:
Aluno
↓
Plano
↓
Pagamento
↓
Treino

Durante esse processo:
1. o aluno é cadastrado;
2. um plano é associado ao aluno;
3. uma mensalidade é criada;
4. um treino é associado.
Essa funcionalidade envolve diferentes classes do sistema.
Relatórios e indicadores
O sistema possui os seguintes indicadores:
Média das mensalidades
Calcula a média dos valores dos planos associados aos alunos.
Total arrecadado
Calcula o total de pagamentos que foram efetivamente registrados como pagos.
Plano com maior valor
Identifica o plano que possui o maior valor mensal.
Ranking de alunos
Ordena os alunos de acordo com o valor total pago.
Taxa de inadimplência
Calcula a porcentagem de alunos que possuem pagamentos pendentes.
Tecnologias utilizadas
O projeto utiliza:
- Java;
- Programação Orientada a Objetos;
- ArrayList;
- Maven;
- CSV;
- JSON;
- Gson;
- Git;
- GitHub.
Maven
O Maven é utilizado para organização do projeto e gerenciamento de dependências.
O arquivo responsável pela configuração é:
pom.xml

A principal dependência externa utilizada é a biblioteca Gson:
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
</dependency>

Tecnologias externas
CSV
O sistema permite exportar e importar alunos utilizando arquivos CSV.
Exemplo:
id;nome;cpf;ativo
1;Joao;12345678900;true
2;Maria;98765432100;true

A exportação transforma os objetos Java em linhas de texto.
A importação faz o processo inverso, lendo os dados do arquivo e criando objetos Aluno.
JSON
O sistema também permite exportar e importar alunos utilizando arquivos JSON.
Exemplo:
[
  {
    "id": 1,
    "nome": "Joao",
    "cpf": "12345678900",
    "ativo": true
  }
]

A biblioteca Gson é responsável pela conversão entre objetos Java e JSON.
Instruções para configuração
Para executar o projeto é necessário possuir:
- Java JDK instalado;
- Maven instalado;
- VS Code ou outra IDE compatível com Java.
Para verificar o Java:
java -version

Para verificar o Maven:
mvn -version

# Instruções para execução

Abra o terminal na pasta onde está localizado o arquivo pom.xml.
Para compilar:
mvn compile

Para executar:
mvn exec:java

O menu do sistema será exibido no terminal.
Exemplos de utilização
Cadastro de aluno
Selecione a opção de cadastrar aluno.
Exemplo:
ID: 1
Nome: Joao
CPF: 12345678900

Resultado esperado:
Aluno cadastrado.

Consulta de aluno
Selecione a opção de consultar aluno por ID.
Exemplo:
ID do aluno: 1

O sistema exibirá os dados do aluno cadastrado.
Associação de plano
Exemplo:
ID do aluno: 1
ID do plano: 3

Resultado:
Plano associado.

Geração de mensalidade
Exemplo:
ID do aluno: 1
ID do pagamento: 1
Mes de referencia: 10/2026

O sistema utiliza automaticamente o valor do plano associado ao aluno.
Registro de pagamento
Exemplo:
ID do aluno: 1
ID do pagamento: 1

Resultado:
Pagamento registrado.

Relatório geral
O sistema pode gerar uma saída semelhante a:
Alunos cadastrados: 2
Alunos ativos: 2
Media das mensalidades: R$ 125.00
Total arrecadado: R$ 100.00
Plano mais caro: Premium - R$ 150.00
Taxa de inadimplencia: 50.00%

Ranking por total pago:
1º Joao - R$ 100.00
2º Davi - R$ 0.00

Exportação para CSV
Ao selecionar a opção de exportação, o sistema gera:
alunos.csv

Esse arquivo pode ser aberto em editores de texto ou programas de planilha.
Importação de CSV
O sistema pode ler o arquivo alunos.csv e cadastrar os alunos encontrados nele.
Exportação para JSON
Ao selecionar a opção correspondente, o sistema gera:
alunos.json

O arquivo contém os dados dos alunos no formato JSON.
Importação de JSON
O sistema utiliza a biblioteca Gson para ler o arquivo alunos.json e transformar os dados em objetos Java.

Utilização de IA
Ferramenta	Objetivo	Resumo do uso	Revisão pelo Dev
ChatGPT	Correção de erros e implementação das tecnologias externas	Auxiliou na identificação e correção de erros de compilação e execução, configuração do Maven e implementação das funcionalidades de importação e exportação em CSV e JSON com a biblioteca Gson.
As alterações foram revisadas e testadas manualmente pela equipe, incluindo testes de compilação, execução, CSV e JSON.
ChatGPT	Documentação e README	Auxiliou na organização da documentação, descrição das funcionalidades, regras de negócio, tecnologias, instruções de execução e exemplos de utilização.
O conteúdo foi revisado pelos integrantes e ajustado de acordo com os requisitos definidos para o projeto.


Conceitos de Programação Orientada a Objetos utilizados
O projeto utiliza:
- classes;
- objetos;
- atributos;
- métodos;
- construtores;
- encapsulamento;
- atributos privados;
- getters e setters;
- composição;
- associação entre objetos;
- coleções com ArrayList;
- separação de responsabilidades.
Considerações finais
O Sistema de Gerenciamento e Análise de Academia foi desenvolvido com o objetivo de aplicar os conceitos de Programação Orientada a Objetos estudados durante a disciplina.
O projeto apresenta diferentes classes com responsabilidades específicas, regras de negócio, relacionamentos entre objetos, relatórios, indicadores e integração com tecnologias externas através de CSV e JSON.
