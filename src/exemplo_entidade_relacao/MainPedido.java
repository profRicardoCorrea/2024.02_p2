package exemplo_entidade_relacao;

public class MainPedido {
	public static void main(String[] args) {
		Cliente c1=new Cliente();
		c1.cpf="c01";
		c1.nome="c01";
		
		Vendedor v1 = new Vendedor();
		v1.matricula=1;
		v1.nome="v01";
		
		Produto p1=new Produto();
		p1.codigo=01;
		p1.nome="TV32";
		p1.preco=1000.99;
		p1.qtd=10;
		
		Pedido pd1=new Pedido();
		Cliente c1c=new Cliente();
		c1c.cpf=c1.cpf;
		pd1.cliente=c1c;
		
		pd1.produto=new Produto();
		pd1.produto.codigo=p1.codigo;
		
		pd1.vendedor=new Vendedor();
		pd1.vendedor.matricula=v1.matricula;
		pd1.valor=1200;
		 
		
	}

}
