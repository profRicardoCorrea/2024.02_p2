package view;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Empresa;
import entidades.PoliticaAntirracista;
import entidades.enums.TipoEmpresa;
import repositorios.EmpresaRepository;

public class MainRepositorioEmpresaPolitica {
	
	    public static void main(String[] args) throws SQLException {
	       
	        // Criar uma nova empresa com políticas antirracistas
	        Empresa novaEmpresa = new Empresa("TechCorp", "Rua Principal, 123", 2000, TipoEmpresa.TECNOLOGIA);
	        PoliticaAntirracista politica = new PoliticaAntirracista("Inclusão racial", "Política de inclusão", 2015, 90);
	        novaEmpresa.adicionarPolitica(politica);
	        new EmpresaRepository().salvar(novaEmpresa);

	        // Listar todas as empresas
	        ArrayList<Empresa> empresas = new EmpresaRepository().listarTodos();
	        empresas.forEach(e -> System.out.println(e.getNome()));
	    }
	

}
