package repositorios;

import java.util.ArrayList;

import entidades.Empresa;

public class EmpresaRepository {
    private ArrayList<Empresa> empresas = new ArrayList<>();

    public void adicionarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public ArrayList<Empresa> listarEmpresas() {
        return empresas;
    }

    public Empresa buscarEmpresaPorIndice(int index) {
        if (index >= 0 && index < empresas.size()) {
            return empresas.get(index);
        }
        return null;
    }
}
