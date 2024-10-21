package view;

import java.sql.SQLException;

import entidades.Empresa;
import entidades.enums.TipoEmpresa;
import repositorios.EmpresaMySQLRepository;

public class MainSql {
	public static void main(String[] args) throws SQLException {
		EmpresaMySQLRepository empresaRepositorio=new EmpresaMySQLRepository();
		Empresa emp1 = new Empresa("Unifacol","ENdereco Unifacol", 2001,TipoEmpresa.ENSINO);
		empresaRepositorio.salvar(emp1);
		for (Empresa emp : empresaRepositorio.listarTodos()) {
			System.out.println("NOME>>"+emp.getNome());
		}
		
	}

}
