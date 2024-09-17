package view;

import java.util.ArrayList;

import entidades.Empresa;
import entidades.enums.TipoEmpresa;
import repositorios.EmpresaPilhaRepository;

public class MainEmpresa {
	public static ArrayList<Empresa> empresas=new ArrayList<Empresa>();
	public static void main(String[] args) {
		EmpresaPilhaRepository erPilha=new EmpresaPilhaRepository(empresas); 
		Empresa emp1=new Empresa("Fulano","Rua 1",2000,TipoEmpresa.FINANCEIRA);
		Empresa emp2=new Empresa("Ciclano","Rua 2",2000,TipoEmpresa.TECNOLOGIA);
		
		erPilha.push(emp1);
		System.out.println("NOME:"+erPilha.stackpop().getNome());
		erPilha.push(emp2);
		System.out.println("NOME:"+erPilha.stackpop().getNome());
		System.out.println("REMOVE -> NOME:"+erPilha.pop().getNome());
		
		System.out.println("NOME:"+erPilha.stackpop().getNome());
	}
}
