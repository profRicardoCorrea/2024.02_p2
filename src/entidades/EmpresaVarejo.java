package entidades;

import entidades.enums.TipoEmpresa;

public class EmpresaVarejo extends Empresa {
    public EmpresaVarejo(String nome, String endereco, int anoFundacao) {
        super(nome, endereco, anoFundacao, TipoEmpresa.VAREJO);
    }

    @Override
    public void avaliarPoliticasAntirracistas() {
        System.out.println("Avaliando políticas antirracistas para empresa de varejo " + getNome());
    }

    @Override
    public double calcularImpactoSocial() {
        return getPoliticas().size() * 1.2;
    }
}