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

    public void avaliarEmpresa(Empresa empresa) {
        System.out.println("Especialista " + nome + " está avaliando a empresa " + empresa.getNome());
        empresa.avaliarPoliticasAntirracistas();
    }
}
