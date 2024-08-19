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
    public Especialista getEspecialista() {
    	return this.especialista;
    }
    public void setEspecialista(Especialista especialista) {
    	this.especialista=especialista;
    }
    
    
    public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public double getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}
	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
	public void gerarRelatorio() {
        System.out.println("Relatório de Avaliação:");
        System.out.println("Especialista: " + especialista.getNome());
        System.out.println("Empresa: " + empresa.getNome());
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Data da Avaliação: " + dataAvaliacao);
    }
}
