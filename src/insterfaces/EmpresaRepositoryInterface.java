package insterfaces;

import java.util.ArrayList;

import entidades.Empresa;

public interface EmpresaRepositoryInterface {
    void adicionarEmpresa(Empresa empresa);
    ArrayList<Empresa> listarEmpresas();
    Empresa buscarEmpresaPorIndice(int index);
}
