package entidades;

public class PoliticaAntirracista {
    private String nome;
    private String descricao;
    private int anoImplementacao;
    private int efetividade;

    public PoliticaAntirracista(String nome, String descricao, int anoImplementacao, int efetividade) {
        this.nome = nome;
        this.descricao = descricao;
        this.anoImplementacao = anoImplementacao;
        this.efetividade = efetividade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAnoImplementacao() {
        return anoImplementacao;
    }

    public int getEfetividade() {
        return efetividade;
    }
}
