package view;

import entidades.enums.TipoEmpresa;

public class MainEnum {
public static void main(String[] args) {
	TipoEmpresa te=TipoEmpresa.TECNOLOGIA;
	System.out.println(te);
	System.out.println(te.name());
	System.out.println(te.ordinal());
	
	if(te=="FINAMCSEIRA")
		System.out.println("EMP. TECNOLOGIA");
	else
		System.out.println("EMP DIF TECNOLOGIA");
}
}
