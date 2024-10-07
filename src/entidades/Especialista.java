package entidades;

public class Especialista {
    private String nome;
    private String areaAtuacao;
    private int anosExperiencia;

    public Especialista(String nome, String areaAtuacao, int anosExperiencia) {
        this.nome = nome;
        this.areaAtuacao = areaAtuacao;
        this.anosExperiencia = anosExperiencia;
    }

    

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public int getAnosExperiencia() {
		return anosExperiencia;
	}

	public void setAnosExperiencia(int anosExperiencia) {
		this.anosExperiencia = anosExperiencia;
	}
    
}
