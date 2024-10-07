package insterfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Empresa;

public interface IEmpresaRepository{
     
	void salvar(Empresa empresa) throws SQLException;
	void alterar(Empresa empresa) throws SQLException;
	Empresa listarPorCodigo(int condigo) throws SQLException;
	ArrayList<Empresa> persquisarPorNome(String nome);
	ArrayList<Empresa> persquisarTipo();
	ArrayList<Empresa> listarTodos() throws SQLException;
	void excluir(Empresa Empresa);
}
