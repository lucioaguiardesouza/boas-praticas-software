/**
 * Ponto de entrada do sistema: cria o aluno e exibe o resultado do seu boletim.
 */
public class Sistema {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Carlos", 8.0, 7.0);
        exibirBoletim(aluno);
    }

    private static void exibirBoletim(Aluno aluno) {
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Media: " + aluno.calcularMedia());
        System.out.println("Situacao: " + aluno.obterSituacao());
    }
}
