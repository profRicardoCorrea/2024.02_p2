package view;

import java.util.ArrayList;

import entidades.Empresa;
import entidades.enums.TipoEmpresa;
import repositorios.EmpresaPilhaRepository;

public class MainEmpresa {
	public static ArrayList<Empresa> empresas=new ArrayList<Empresa>();
	public static ArrayList<Empresa> empresasTemp=new ArrayList<Empresa>();
	public static void main(String[] args) {
		EmpresaPilhaRepository erPilha=new EmpresaPilhaRepository(empresas); 
		EmpresaPilhaRepository erPilhaTEMP=new EmpresaPilhaRepository(empresasTemp); 
		
		Empresa emp1=new Empresa("Fulano","Rua 1",2000,TipoEmpresa.FINANCEIRA);
		Empresa emp2=new Empresa("Ciclano","Rua 2",2000,TipoEmpresa.TECNOLOGIA);
		Empresa emp3=new Empresa("E3");
		Empresa emp4=new Empresa("E4");
		Empresa emp5=new Empresa("E5");
		erPilha.push(emp1);
		System.out.println("topo NOME:"+erPilha.stackpop().getNome());
		erPilha.push(emp2);
		System.out.println("topo NOME:"+erPilha.stackpop().getNome());
		//System.out.println("REMOVE -> NOME:"+erPilha.pop().getNome());
		
		//System.out.println("topo NOME:"+erPilha.stackpop().getNome());
		erPilha.push(emp3);
		System.out.println("topo NOME:"+erPilha.stackpop().getNome());
		erPilha.push(emp4);
		System.out.println("topo NOME:"+erPilha.stackpop().getNome());
		erPilha.push(emp5);
		//erPilha.pop();
		System.out.println("topo NOME:"+erPilha.stackpop().getNome());
		Empresa emp=null;
		do {
			System.out.println("TAMANHO:"+erPilha.size());
			emp=erPilha.pop();
			if(!emp.getNome().equals("E3"))
				erPilhaTEMP.push(emp);
			
			System.out.println("REMOVE NOME"+emp.getNome());
			
		}while(!emp.getNome().equals("E3"));
		
		
		Empresa empTemp=null;
		do {
			
			if(empTemp!=null)
				System.out.println("topo TEMP NOME:"+empTemp.getNome());
			empTemp=null;
			empTemp=erPilhaTEMP.pop();
			erPilha.push(empTemp);
			
		}
		while(empTemp!=null);
		erPilhaTEMP=null;
		System.out.println("topo NOME:"+erPilha.stackpop().getNome());
		
	}
}
