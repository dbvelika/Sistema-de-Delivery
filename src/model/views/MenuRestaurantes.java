package model.views;

import model.entites.Restaurante;

import java.util.Scanner;

public class MenuRestaurantes extends Menu{

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
                case 1:
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

                    System.out.println("Restaurante "+ restaurante.getNome() +" adicionado com sucesso.");
                    break;
            }
        }while (opcao != 0);
    }
}
