package entidades;
import java.util.ArrayList;

import entidades.enums.TipoEmpresa;

public abstract class Empresa {
    private String nome;
    private String endereco;
    private int anoFundacao;
    private TipoEmpresa tipo;
    private ArrayList<PoliticaAntirracista> politicas;

    public Empresa(String nome, String endereco, int anoFundacao, TipoEmpresa tipo) {
        this.nome = nome;
        this.endereco = endereco;
        this.anoFundacao = anoFundacao;
        this.tipo = tipo;
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

    public TipoEmpresa getTipo() {
        return tipo;
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