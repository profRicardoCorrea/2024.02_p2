package entidades;

public class EmpresaVarejo extends Empresa {

    public EmpresaVarejo(String nome, String endereco, int anoFundacao) {
        super(nome, endereco, anoFundacao);
    }

    @Override
    public void avaliarPoliticasAntirracistas() {
        // Implementação específica para empresas de varejo
        System.out.println("Avaliando políticas antirracistas para empresa de varejo " + getNome());
    }

    @Override
    public double calcularImpactoSocial() {
        // Cálculo específico para empresas de varejo
        return getPoliticas().size() * 1.2;
    }
}