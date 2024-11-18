

import java.util.Scanner;

//import com.exemplo.entidades.Usuario;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	public static void cadastrarUsuario() {
		
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email:");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);
        usuarioDAO.salvar(usuario);

        System.out.println("Usuário salvo com sucesso!");
        
	}
	public static void listarUsuarios() {
		Scanner scanner = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
        for (Usuario  usu : usuarioDAO.listarTodos()) {
        	System.out.println("Usuario Nome:"+usu.getNome());
        	System.out.println("Usuario email:"+usu.getEmail());
        	System.out.println("Usuario Id:"+usu.getId());
        	System.out.println("----------------------");
		}         
	}
	public static void listarUsuario() {
		Scanner scanner = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println("Digite o id do Registro:");
        long  id = scanner.nextInt();
        Usuario  usu = usuarioDAO.buscarPorId(id);
        	System.out.println("Usuario Nome:"+usu.getNome());
        	System.out.println("Usuario email:"+usu.getEmail());
		         
	}
	public static void deletarUsuario() {
		Scanner scanner = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println("Digite o id do Registro a ser removido:");
        long  id = scanner.nextInt();
        usuarioDAO.deletarPorId(id);
        listarUsuarios();	 
		         
	}
    public static void main(String[] args) {
        //cadastrarUsuario();
        //cadastrarUsuario();
    	//cadastrarUsuario();
        //cadastrarUsuario();
    	//cadastrarUsuario();
        //cadastrarUsuario();
    	//cadastrarUsuario();
        //cadastrarUsuario();
        listarUsuarios();
        listarUsuario();
        deletarUsuario();
        
        
    }
}
