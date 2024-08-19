package servicos;

import java.util.ArrayList;

import entidades.Empresa;
import entidades.EmpresaFinanceira;
import entidades.EmpresaTecnologia;
import entidades.EmpresaVarejo;
import entidades.Especialista;
import entidades.enums.TipoEmpresa;
import exceptions.EmpresaNotFoundException;
import exceptions.InvalidAnoFundacaoException;
import exceptions.InvalidEmpresaTypeException;
import insterfaces.EmpresaRepositoryInterface;
import insterfaces.EmpresaServiceInterface; 

public class EmpresaService implements EmpresaServiceInterface {
    private EmpresaRepositoryInterface empresaRepository;

    public EmpresaService(EmpresaRepositoryInterface empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public void adicionarEmpresa(String nome, String endereco, int anoFundacao, TipoEmpresa tipo) throws InvalidAnoFundacaoException, InvalidEmpresaTypeException {
        if (!validarAnoFundacao(anoFundacao)) {
            throw new InvalidAnoFundacaoException("Ano de fundação inválido! Deve ser entre 1900 e 2024.");
        }

        Empresa empresa = criarEmpresa(nome, endereco, anoFundacao, tipo);
        if (empresa != null) {
            empresaRepository.adicionarEmpresa(empresa);
            System.out.println("Empresa adicionada com sucesso!");
        } else {
            throw new InvalidEmpresaTypeException("Tipo de empresa inválido!");
        }
    }

    private Empresa criarEmpresa(String nome, String endereco, int anoFundacao, TipoEmpresa tipo) {
        switch (tipo) {
            case TECNOLOGIA:
                return new EmpresaTecnologia(nome, endereco, anoFundacao);
            case VAREJO:
                return new EmpresaVarejo(nome, endereco, anoFundacao);
            case FINANCEIRA:
                return new EmpresaFinanceira(nome, endereco, anoFundacao);
            default:
                return null;
        }
    }

    @Override
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

    @Override
    public void avaliarEmpresa(int index) throws EmpresaNotFoundException {
        Empresa empresa = empresaRepository.buscarEmpresaPorIndice(index - 1);
        if (empresa != null) {
            Especialista especialista = new Especialista("João", "Diversidade e Inclusão", 10);
            especialista.avaliarEmpresa(empresa);
        } else {
            throw new EmpresaNotFoundException("Empresa não encontrada para o índice fornecido.");
        }
    }

    @Override
    public boolean validarAnoFundacao(int ano) {
        return ano > 1900 && ano <= 2024;
    }
}
