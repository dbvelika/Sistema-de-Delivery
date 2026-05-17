package application;

import service.*;
import views.*;

import java.util.Locale;
import java.util.Scanner;

import db.DB;
import java.sql.Connection;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        GerenciadorRestaurante gerRest = new GerenciadorRestaurante();
        GerenciadorProdutos gerProd = new GerenciadorProdutos();
        GerenciadorEntregadores gerEntr = new GerenciadorEntregadores();
        GerenciadorClientes gerCli = new GerenciadorClientes();
        GerenciadorPedidos gerPedidos = new GerenciadorPedidos();


        MenuRestaurantes menuRest = new MenuRestaurantes();
        MenuProdutos menuProd = new MenuProdutos();
        MenuEntregadores menuEntr = new MenuEntregadores();
        MenuClientes menuCli = new MenuClientes();
        MenuPedidos menuPedidos = new MenuPedidos();

        Connection conn = DB.getConnection();

        if(conn != null) {
            System.out.println("Conexão realizada com sucesso!");
        }

        int opcao = 0;
        do{
            Menu.menuInicial();
            opcao = sc. nextInt();

            switch (opcao){
                case 1: menuRest.menuRestaurantes(sc, gerRest); break;
                case 2: menuProd.menuProdutos(sc, gerProd); break;
                case 3: menuCli.menuClientes(sc, gerCli); break;
                case 4: menuEntr.menuEntregadores(sc, gerEntr);
                case 5: menuPedidos.menuPedidos(sc, gerPedidos, gerCli, gerProd, gerRest, gerEntr); break;
                case 6: System.out.println("====== RELATÓRIO ======"); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida!");
            }
        }while(opcao != 0);

        sc.close();
    }
}