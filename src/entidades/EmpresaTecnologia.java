package entidades;

import entidades.enums.TipoEmpresa;

public class EmpresaTecnologia extends Empresa {
    public EmpresaTecnologia(String nome, String endereco, int anoFundacao) {
        super(nome, endereco, anoFundacao, TipoEmpresa.TECNOLOGIA);
    }

    @Override
    public void avaliarPoliticasAntirracistas() {
        System.out.println("Avaliando políticas antirracistas para empresa de tecnologia " + getNome());
    }

    @Override
    public double calcularImpactoSocial() {
        return getPoliticas().size() * 1.5;
    }
}
