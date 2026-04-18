package application;

import model.views.*;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        do{
            Menu.menuInicial();
            opcao = sc. nextInt();

            switch (opcao){
                case 1: MenuRestaurantes.menuRestaurantes(sc); break;
                case 2: MenuProdutos.menuProdutos(); break;
                case 3: MenuClientes.menuClientes(); break;
                case 4: MenuEntregadores.menuEntregadores(); break;
                case 5: MenuPedidos.menuPedidos(); break;
                case 6: System.out.println("====== RELATÓRIO ======"); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida!");
            }
        }while(opcao != 0);

        sc.close();
    }
}
