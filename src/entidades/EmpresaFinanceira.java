package entidades;

public class EmpresaFinanceira extends Empresa {

    public EmpresaFinanceira(String nome, String endereco, int anoFundacao) {
        super(nome, endereco, anoFundacao);
    }

    @Override
    public void avaliarPoliticasAntirracistas() {
        // Implementação específica para empresas financeiras
        System.out.println("Avaliando políticas antirracistas para empresa financeira " + getNome());
    }

    @Override
    public double calcularImpactoSocial() {
        // Cálculo específico para empresas financeiras
        return getPoliticas().size() * 2.0;
    }
}