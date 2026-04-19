package views;

public abstract class Menu {

    public static void menuInicial(){
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
    }
}
