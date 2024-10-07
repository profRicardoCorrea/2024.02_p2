package insterfaces;

import java.util.ArrayList;

import entidades.enums.TipoEmpresa;
import exceptions.EmpresaNotFoundException;
import exceptions.InvalidAnoFundacaoException;
import exceptions.InvalidEmpresaTypeException;

public interface IEmpresaService{
    void adicionarEmpresa(String nome, String endereco, int anoFundacao, TipoEmpresa tipo) throws InvalidAnoFundacaoException, InvalidEmpresaTypeException;
    void listarEmpresas();
    void avaliarEmpresa(int index) throws EmpresaNotFoundException;
    boolean validarAnoFundacao(int ano);
}
