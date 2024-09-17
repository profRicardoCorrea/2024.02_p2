package repositorios;

import java.util.ArrayList;

import entidades.Empresa;

public class EmpresaPilhaRepository extends PilhaRepository<Empresa>{
    
    public EmpresaPilhaRepository(ArrayList<Empresa> empresas) {
		super(empresas);
	} 
     
}
