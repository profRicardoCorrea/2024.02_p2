

import java.util.Scanner;

//import com.exemplo.entidades.Usuario;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email:");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);
        usuarioDAO.salvar(usuario);

        System.out.println("Usuário salvo com sucesso!");
        scanner.close();
    }
}
