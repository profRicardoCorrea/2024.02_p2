
import java.util.Scanner;

//import com.exemplo.entidades.Usuario;

public class Main {
	public static Scanner scanner = new Scanner(System.in);

	public static Usuario cadastrarUsuario() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		System.out.println("Digite o Login:");
		String nome = scanner.nextLine();

		System.out.println("Digite o email:");
		String email = scanner.nextLine();

		System.out.println("Digite o senha:");
		String senha = scanner.nextLine();

		Usuario usuario = new Usuario(nome, email, senha);
		usuarioDAO.salvar(usuario);

		System.out.println("Usuário salvo com sucesso!");
		return usuario;
	}

	public static void listarUsuarios() {
		Scanner scanner = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		for (Usuario usu : usuarioDAO.listarTodos()) {
			System.out.println("Usuario Nome:" + usu.getLogin());
			System.out.println("Usuario email:" + usu.getEmail());
			System.out.println("Usuario Id:" + usu.getId());
			System.out.println("----------------------");
		}
	}

	public static void listarUsuario(long id) {
		Scanner scanner = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (id == 0) {
			System.out.println("Digite o id do Registro:");
			id = scanner.nextInt();
		}
		Usuario usu = usuarioDAO.buscarPorId(id);
		System.out.println("Usuario Nome:" + usu.getLogin());
		System.out.println("Usuario email:" + usu.getEmail());

	}

	public static void deletarUsuario() {
		Scanner scanner = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println("Digite o id do Registro a ser removido:");
		long id = scanner.nextInt();
		usuarioDAO.deletarPorId(id);
		listarUsuarios();

	}

	public static void listarPessoas() {
		Scanner scanner = new Scanner(System.in);
		PessoaDAO pessoaDAO = new PessoaDAO();
		for (Pessoa pess : pessoaDAO.listarTodos()) {
			System.out.println("PEssoa Nome:" + pess.getNome());
			System.out.println("Pessoa CPF:" + pess.getCpf());
			System.out.println("Pessoa Id:" + pess.getId());
			listarUsuario(pess.getUsuario().getId());

			System.out.println("----------------------");
		}
	}

	public static void cadastrarPessoa(Usuario usuario) {

		PessoaDAO pessoaDAO = new PessoaDAO();

		System.out.println("Digite o Nome:");
		String nome = scanner.nextLine();

		System.out.println("Digite o CPF:");
		String cpf = scanner.nextLine();
 

		 
		Pessoa pessoa = new Pessoa(nome, cpf, usuario);
		pessoaDAO.salvar(pessoa);

		System.out.println("PEssoa salva com sucesso!");

	}

	public static void main(String[] args) {
		// cadastrarUsuario();
		// cadastrarUsuario();
		// cadastrarUsuario();
		// cadastrarUsuario();
		// cadastrarUsuario();
		// cadastrarUsuario();
		// cadastrarUsuario();
		// cadastrarUsuario();
		// listarUsuarios();
		// listarUsuario();
		// deletarUsuario();
		cadastrarPessoa(cadastrarUsuario());

	}
}
