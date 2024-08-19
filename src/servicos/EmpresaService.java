package servicos;

import java.util.ArrayList;

import entidades.Empresa;
import entidades.EmpresaFinanceira;
import entidades.EmpresaTecnologia;
import entidades.EmpresaVarejo;
import entidades.Especialista;
import entidades.enums.TipoEmpresa;
import repositorios.EmpresaRepository;

public class EmpresaService {
    private EmpresaRepository empresaRepository = new EmpresaRepository();

    public void adicionarEmpresa(String nome, String endereco, int anoFundacao, TipoEmpresa tipo) {
        Empresa empresa = null;
        switch (tipo) {
            case TECNOLOGIA:
                empresa = new EmpresaTecnologia(nome, endereco, anoFundacao);
                break;
            case VAREJO:
                empresa = new EmpresaVarejo(nome, endereco, anoFundacao);
                break;
            case FINANCEIRA:
                empresa = new EmpresaFinanceira(nome, endereco, anoFundacao);
                break;
        }
        if (empresa != null) {
            empresaRepository.adicionarEmpresa(empresa);
            System.out.println("Empresa adicionada com sucesso!");
        }
    }

    public void listarEmpresas() {
        ArrayList<Empresa> empresas = empresaRepository.listarEmpresas();
        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa cadastrada.");
        } else {
            for (int i = 0; i < empresas.size(); i++) {
                Empresa e = empresas.get(i);
                System.out.println((i + 1) + ". " + e.getNome() + " - " + e.getEndereco() + " - Fundada em: " + e.getAnoFundacao() + " - Tipo: " + e.getTipo());
            }
        }
    }

    public void avaliarEmpresa(int index) {
        Empresa empresa = empresaRepository.buscarEmpresaPorIndice(index - 1);
        if (empresa != null) {
            Especialista especialista = new Especialista("João", "Diversidade e Inclusão", 10);
            especialista.avaliarEmpresa(empresa);
        } else {
            System.out.println("Empresa inválida!");
        }
    }

    public boolean validarAnoFundacao(int ano) {
        return ano > 1900 && ano <= 2024;
    }
}

