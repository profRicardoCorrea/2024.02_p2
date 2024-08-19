package view;
import java.util.Scanner;

import entidades.enums.TipoEmpresa;
import exceptions.EmpresaNotFoundException;
import exceptions.InvalidAnoFundacaoException;
import exceptions.InvalidEmpresaTypeException;
import servicos.EmpresaService;

public class Main {
    private static EmpresaService empresaService = new EmpresaService(null);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Empresa");
            System.out.println("2. Listar Empresas");
            System.out.println("3. Avaliar Empresa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    adicionarEmpresa();
                    break;
                case 2:
                    empresaService.listarEmpresas();
                    break;
                case 3:
                    avaliarEmpresa();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private static void adicionarEmpresa() {
        try {
            System.out.print("Nome da Empresa: ");
            String nome = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Ano de Fundação: ");
            int anoFundacao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            System.out.println("Tipo de Empresa:");
            System.out.println("1. Tecnologia");
            System.out.println("2. Varejo");
            System.out.println("3. Financeira");
            int tipoOpcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            TipoEmpresa tipo = null;
            switch (tipoOpcao) {
                case 1:
                    tipo = TipoEmpresa.TECNOLOGIA;
                    break;
                case 2:
                    tipo = TipoEmpresa.VAREJO;
                    break;
                case 3:
                    tipo = TipoEmpresa.FINANCEIRA;
                    break;
                default:
                    throw new InvalidEmpresaTypeException("Tipo de empresa inválido!");
            }

            empresaService.adicionarEmpresa(nome, endereco, anoFundacao, tipo);

        } catch (InvalidAnoFundacaoException | InvalidEmpresaTypeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void avaliarEmpresa() {
        try {
            empresaService.listarEmpresas();
            System.out.print("Escolha uma empresa para avaliar (número): ");
            int index = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha
            empresaService.avaliarEmpresa(index);
        } catch (EmpresaNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
