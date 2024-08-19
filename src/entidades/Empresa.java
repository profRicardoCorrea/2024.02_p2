package entidades;
import java.util.ArrayList;

public abstract class Empresa {
    private String nome;
    private String endereco;
    private int anoFundacao;
    private ArrayList<PoliticaAntirracista> politicas;

    public Empresa(String nome, String endereco, int anoFundacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.anoFundacao = anoFundacao;
        this.politicas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public ArrayList<PoliticaAntirracista> getPoliticas() {
        return politicas;
    }

    public void adicionarPolitica(PoliticaAntirracista politica) {
        this.politicas.add(politica);
    }

    public abstract void avaliarPoliticasAntirracistas();
    public abstract double calcularImpactoSocial();
}
