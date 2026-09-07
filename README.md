# Boas Práticas de Software

Atividade prática da disciplina **Manutenção e Configuração de Software**.

O projeto parte de um sistema simples que calcula a média de duas notas de um aluno
e informa se ele foi aprovado. A versão original foi mantida no histórico do Git e
melhorada na branch `melhoria-boas-praticas`, aplicando boas práticas de nomes,
modularização, código auto comentado e padronização.

## Estrutura do projeto

```
boas-praticas-software/
├── src/
│   ├── Aluno.java      # dados do aluno, cálculo da média e situação
│   └── Sistema.java    # ponto de entrada e exibição do boletim
├── .gitignore
└── README.md
```

## Como executar

```bash
javac -d bin src/*.java
java -cp bin Sistema
```

Saída esperada:

```
Aluno: Carlos
Media: 7.5
Situacao: Aprovado
```

## Código original

```java
public class Sistema {
    public static void main(String[] args) {
        String n = "Carlos";
        double a = 8;
        double b = 7;
        double c = (a + b) / 2;

        System.out.println("Aluno: " + n);
        System.out.println("Media: " + c);

        if (c >= 6) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }
    }
}
```

## Histórico no Git

| Etapa | Descrição |
|-------|-----------|
| Commit inicial na `main` | Código original, sem alterações |
| Branch `melhoria-boas-praticas` | Branch criada para receber as melhorias |
| Commit de refatoração | Nomes descritivos, modularização e padronização |
| Commit do README | Documentação e respostas da questão final |
| Pull Request | Descrição das melhorias realizadas |
| Merge | Branch `melhoria-boas-praticas` integrada à `main` |

## Questão final

### 1. Qual era o principal problema do código original?

O principal problema era a **falta de legibilidade**. Todas as variáveis usavam
nomes de uma única letra (`n`, `a`, `b`, `c`), o que não permitia entender o que
cada valor representava sem ler o código inteiro. Além disso, todo o programa
estava concentrado dentro do método `main`, misturando três responsabilidades
diferentes: guardar os dados do aluno, calcular a média e exibir o resultado.
O número `6`, usado como critério de aprovação, aparecia solto no meio do `if`,
sem indicar seu significado.

### 2. Quais melhorias você realizou?

- **Nomes descritivos**: `n` passou a ser `nome`, `a` e `b` passaram a ser
  `primeiraNota` e `segundaNota`, e `c` passou a ser o resultado do método
  `calcularMedia()`.
- **Modularização**: o programa foi dividido em duas classes. `Aluno` guarda os
  dados e responde pelas regras (`calcularMedia()`, `estaAprovado()`,
  `obterSituacao()`); `Sistema` apenas cria o aluno e chama `exibirBoletim()`.
- **Métodos com nome explícito**: cada método diz exatamente o que faz, sem
  abreviações.
- **Constante nomeada**: o valor `6` virou a constante
  `MEDIA_MINIMA_PARA_APROVACAO`, deixando claro o critério de aprovação e
  centralizando a regra em um único lugar.
- **Padronização**: classes em `PascalCase`, métodos e variáveis em `camelCase`,
  constantes em `UPPER_SNAKE_CASE`, indentação de 4 espaços e arquivos-fonte
  organizados na pasta `src/`.
- **Código auto comentado**: os comentários existentes apenas descrevem o papel
  de cada classe; o restante do código se explica pelos próprios nomes.

### 3. Como a modularização facilitou a organização do código?

Cada parte do código passou a ter uma responsabilidade específica, o que torna
mais fácil localizar onde uma alteração deve ser feita. Mudar o critério de
aprovação exige alterar apenas a constante em `Aluno`; mudar o formato da saída
exige alterar apenas `exibirBoletim()` em `Sistema`. O `main` ficou curto e
mostra o fluxo do programa em duas linhas, funcionando como um resumo do que o
sistema faz. Os métodos também podem ser reaproveitados e testados de forma
isolada, o que não era possível quando tudo estava dentro do `main`.

### 4. Como o Git ajudou a controlar as alterações realizadas no sistema?

O Git preservou a versão original no primeiro commit, permitindo comparar o antes
e o depois com `git diff` e voltar atrás se necessário. A branch
`melhoria-boas-praticas` isolou a refatoração, mantendo a `main` estável enquanto
as mudanças eram feitas. Cada commit registrou uma etapa com uma mensagem
explicando o motivo da alteração, criando um histórico rastreável. O Pull Request
serviu como ponto de revisão antes de integrar o código, e o merge trouxe as
melhorias para a `main` sem perder nenhum passo do processo.
