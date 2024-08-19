package repositorios;

import java.util.ArrayList;

import entidades.Empresa;
import insterfaces.EmpresaRepositoryInterface;

class EmpresaRepository implements EmpresaRepositoryInterface {
    private ArrayList<Empresa> empresas = new ArrayList<>();

    @Override
    public void adicionarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    @Override
    public ArrayList<Empresa> listarEmpresas() {
        return empresas;
    }

    @Override
    public Empresa buscarEmpresaPorIndice(int index) {
        if (index >= 0 && index < empresas.size()) {
            return empresas.get(index);
        }
        return null;
    }
}