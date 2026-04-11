package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        do{
            System.out.println("========== SISTEMA DE DELIVERY ==========");
            System.out.println("1 - Gerenciar Restaurantes");
            System.out.println("2 - Gerenciar Produtos");
            System.out.println("3 - Gerenciar Clientes");
            System.out.println("4 - Gerenciar Entregadores");
            System.out.println("5 - Gerenciar Pedidos");
            System.out.println("6 - Gerar Relatório");
            System.out.println("0 - Sair");
            System.out.println("=========================================");
            System.out.print("Escolha uma opção: ");

            opcao = sc. nextInt();

           switch (opcao){
               case 1: System.out.println("====== MENU DE RRESTAURANTESES ======"); break;
               case 2: System.out.println("====== MENU DE PRODUTOS ======"); break;
               case 3: System.out.println("====== MENU DE CLIENTES ======"); break;
               case 4: System.out.println("====== MENU DE ENTREGADORES ======"); break;
               case 5: System.out.println("====== MENU DE PEDIDOS ======"); break;
               case 6: System.out.println("====== RELATÓRIO ======"); break;
               case 0: System.out.println("Encerrando..."); break;
               default: System.out.println("Opção inválida!");
           }
        }while(opcao != 0);

        sc.close();
    }
}
