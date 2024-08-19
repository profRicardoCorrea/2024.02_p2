package entidades;

public class EmpresaTecnologia extends Empresa {

    public EmpresaTecnologia(String nome, String endereco, int anoFundacao) {
        super(nome, endereco, anoFundacao);
    }

    @Override
    public void avaliarPoliticasAntirracistas() {
        // Implementação específica para empresas de tecnologia
        System.out.println("Avaliando políticas antirracistas para empresa de tecnologia " + getNome());
    }

    @Override
    public double calcularImpactoSocial() {
        // Cálculo específico para empresas de tecnologia
        return getPoliticas().size() * 1.5;
    }
}
