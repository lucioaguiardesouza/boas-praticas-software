/**
 * Representa um aluno e as notas usadas para definir sua situacao no semestre.
 */
public class Aluno {

    private static final double MEDIA_MINIMA_PARA_APROVACAO = 6.0;

    private final String nome;
    private final double primeiraNota;
    private final double segundaNota;

    public Aluno(String nome, double primeiraNota, double segundaNota) {
        this.nome = nome;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
    }

    public String getNome() {
        return nome;
    }

    public double calcularMedia() {
        return (primeiraNota + segundaNota) / 2;
    }

    public boolean estaAprovado() {
        return calcularMedia() >= MEDIA_MINIMA_PARA_APROVACAO;
    }

    public String obterSituacao() {
        if (estaAprovado()) {
            return "Aprovado";
        }
        return "Reprovado";
    }
}
