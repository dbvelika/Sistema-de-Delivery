package views;

import model.entites.Restaurante;
import service.GerenciadorRestaurante;

import java.util.Scanner;

public class MenuRestaurantes extends Menu{

    Restaurante restaurante = new Restaurante();
    GerenciadorRestaurante gerenciador = new GerenciadorRestaurante();

    public static void menuRestaurantes(Scanner sc){
        int opcao = 0;
        do {
            System.out.println("========== GERENCIAR RESTAURANTES ==========");
            System.out.println("1 - Inserir restaurante");
            System.out.println("2 - Atualizar restaurante");
            System.out.println("3 - Excluir restaurante");
            System.out.println("0 - Voltar");

            System.out.println("Escolha uma opção: ");
            opcao = sc.nextInt();

            sc.nextLine();

            switch(opcao){
                case 1:  break;
            }
        }while (opcao != 0);
    }

    public void menuCadastro(Scanner sc){
        System.out.print("Informe o nome do restaurante: ");
        String nome = sc.nextLine();

        System.out.print("Informe o endereço do restaurante: ");
        String endereco = sc.nextLine();

        System.out.print("Informe o CNPJ do restaurante: ");
        Integer cnpj = sc.nextInt();

        System.out.print("Informe o telefone do restaurante: ");
        Integer tel = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe a categoria do restaurante: ");
        String categoria = sc.nextLine();

        Restaurante restaurante = new Restaurante(1 ,nome, endereco, cnpj, tel, categoria);

        gerenciador.cadastrar(restaurante);

        System.out.println("Restaurante "+ restaurante.getNome() +" adicionado com sucesso.");
    }

    public void menuAtualizar(Scanner sc){
        System.out.print("Informe o id do restaurante que deseja alterar: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        gerenciador.buscar(id);
        System.out.println("ID: "+ restaurante.getId());
        System.out.println("Restaurante: " +restaurante.getNome()+ " - Categoria: "+ restaurante.getCategoria());
        System.out.println("Endereço: "+ restaurante.getEndereco());
        System.out.println("CNPJ e Tel: "+ restaurante.getCnpj() +", "+ restaurante.getTelefone());

        int aws = 0;
        do {
            System.out.println();
            System.out.print("Qual campo deseja alterar?: ");
            System.out.print("1 - Nome");
            System.out.print("2 - Endereço");
            System.out.print("3 - CNPJ");
            System.out.print("4 - Telefone");
            System.out.print("5 - Categoria");
            System.out.print("0 - Voltar");
            aws = sc.nextInt();

            if (aws == 0){
                menuInicial();
            }
        }while (aws != 0);
    }
}
