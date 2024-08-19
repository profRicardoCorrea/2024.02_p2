package view;
import java.util.Scanner;

import entidades.Empresa;
import entidades.EmpresaFinanceira;
import entidades.EmpresaTecnologia;
import entidades.EmpresaVarejo;
import entidades.Especialista;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Empresa> empresas = new ArrayList<>();
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
                    listarEmpresas();
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
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        Empresa empresa = null;
        switch (tipo) {
            case 1:
                empresa = new EmpresaTecnologia(nome, endereco, anoFundacao);
                break;
            case 2:
                empresa = new EmpresaVarejo(nome, endereco, anoFundacao);
                break;
            case 3:
                empresa = new EmpresaFinanceira(nome, endereco, anoFundacao);
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        empresas.add(empresa);
        System.out.println("Empresa adicionada com sucesso!");
    }

    private static void listarEmpresas() {
        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa cadastrada.");
        } else {
            for (int i = 0; i < empresas.size(); i++) {
                Empresa e = empresas.get(i);
                System.out.println((i + 1) + ". " + e.getNome() + " - " + e.getEndereco() + " - Fundada em: " + e.getAnoFundacao());
            }
        }
    }

    private static void avaliarEmpresa() {
        listarEmpresas();
        if (!empresas.isEmpty()) {
            System.out.print("Escolha uma empresa para avaliar (número): ");
            int index = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            if (index > 0 && index <= empresas.size()) {
                Empresa empresa = empresas.get(index - 1);
                Especialista especialista = new Especialista("João", "Diversidade e Inclusão", 10);
                especialista.avaliarEmpresa(empresa);
            } else {
                System.out.println("Empresa inválida!");
            }
        }
    }
}
