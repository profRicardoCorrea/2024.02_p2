package entidades;

import entidades.enums.TipoEmpresa;

public class EmpresaFinanceira extends Empresa {
    public EmpresaFinanceira(String nome, String endereco, int anoFundacao) {
        super(nome, endereco, anoFundacao, TipoEmpresa.FINANCEIRA);
    }

    @Override
    public void avaliarPoliticasAntirracistas() {
        System.out.println("Avaliando políticas antirracistas para empresa financeira " + getNome());
    }

    @Override
    public double calcularImpactoSocial() {
        return getPoliticas().size() * 2.0;
    }
}