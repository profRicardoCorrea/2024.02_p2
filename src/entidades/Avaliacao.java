package entidades;
import java.util.Date;

class Avaliacao {
    private Especialista especialista;
    private Empresa empresa;
    private double pontuacao;
    private Date dataAvaliacao;

    public Avaliacao(Especialista especialista, Empresa empresa, double pontuacao) {
        this.especialista = especialista;
        this.empresa = empresa;
        this.pontuacao = pontuacao;
        this.dataAvaliacao = new Date();
    }

    public void gerarRelatorio() {
        System.out.println("Relatório de Avaliação:");
        System.out.println("Especialista: " + especialista.getNome());
        System.out.println("Empresa: " + empresa.getNome());
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Data da Avaliação: " + dataAvaliacao);
    }
}
