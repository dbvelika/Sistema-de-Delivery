package views;

import model.entites.Restaurante;
import service.GerenciadorRestaurante;

import java.util.Scanner;

public class MenuRestaurantes extends Menu{

    Restaurante restaurante = new Restaurante();

    public void menuRestaurantes(Scanner sc,GerenciadorRestaurante service){
        int opcao = 0;
        do {
            System.out.println("========== GERENCIAR RESTAURANTES ==========");
            System.out.println("1 - Inserir restaurante");
            System.out.println("2 - Atualizar restaurante");
            System.out.println("3 - Excluir restaurante");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            sc.nextLine();

            switch(opcao){
                case 1: menuCadastro(sc, service); break;
                case 2: menuAtualizar(sc, service); break;
                case 3: menuExcluir(sc, service); break;
                case 0: break;
                default: System.out.println("Opção Inválida.");
            }
        }while (opcao != 0);
    }

    public void menuCadastro(Scanner sc, GerenciadorRestaurante service){
        System.out.println("===== CADASTRAR RESTAURANTE =====");
        System.out.print("Informe o nome do restaurante: ");
        String nome = sc.nextLine();

        System.out.print("Informe o endereço do restaurante: ");
        String endereco = sc.nextLine();

        System.out.print("Informe o CNPJ do restaurante: ");
        String cnpj = sc.nextLine();

        System.out.print("Informe o telefone do restaurante: ");
        String  tel = sc.nextLine();

        System.out.print("Informe a categoria do restaurante: ");
        String categoria = sc.nextLine();

        Restaurante restaurante = new Restaurante(null ,nome, endereco, cnpj, tel, categoria);

        service.cadastrar(restaurante);

        System.out.println("Restaurante "+ restaurante.getNome() +" adicionado com sucesso.");
    }

    public void menuAtualizar(Scanner sc, GerenciadorRestaurante service){
        System.out.println("===== ATUALIZAR RESTAURANTE =====");
        System.out.print("Informe o id do restaurante que deseja alterar: ");
        Integer id = sc.nextInt();
        sc.nextLine();

         Restaurante r = service.buscarPorID(id);

        if(r != null) {
            System.out.println("===== DADOS ATUAIS =====");
            System.out.println(r);

            int aws = 0;
            do {
                System.out.println();
                System.out.println("1 - Nome");
                System.out.println("2 - Endereço");
                System.out.println("3 - CNPJ");
                System.out.println("4 - Telefone");
                System.out.println("5 - Categoria");
                System.out.println("0 - Voltar");
                System.out.println("Escolha uma opção: ");
                aws = sc.nextInt();

                sc.nextLine();
                switch (aws) {
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        String novoNome = sc.nextLine();
                        r.setNome(novoNome);
                        System.out.println("Nome do restaurante alterado com sucesso!");
                        System.out.println(r);
                        break;

                    case 2:
                        System.out.print("Informe o novo endereço: ");
                        String novoEndereco = sc.nextLine();
                        r.setEndereco(novoEndereco);
                        System.out.println("Endereço do restaurante alterado com sucesso!");
                        System.out.println(r);
                        break;

                    case 3:
                        System.out.print("Informe o novo CNPJ: ");
                        String novoCnpj = sc.nextLine();
                        r.setCnpj(novoCnpj);
                        System.out.println("CNPJ do restaurante alterado com sucesso!");
                        System.out.println(r);
                        break;

                    case 4:
                        System.out.print("Informe o novo telefone: ");
                        String novoTel = sc.nextLine();
                        r.setTelefone(novoTel);
                        System.out.println("Telefone do restaurante alterado com sucesso!");
                        System.out.println(r);
                        break;

                    case 5:
                        System.out.print("Informe a nova categoria: ");
                        String novaCateg = sc.nextLine();
                        r.setCategoria(novaCateg);
                        System.out.println("Categoria do restaurante alterado com sucesso!");
                        System.out.println(r);
                        break;

                    case 0: break;

                    default: System.out.println("Opção Inválida!");
                }
            } while (aws != 0);
        }
        else {
            System.out.println("Restaurante não encontrado.");
        }
    }

    public void menuExcluir(Scanner sc, GerenciadorRestaurante service){
        System.out.println("===== REMOVER RESTAURANTE =====");
        System.out.print("Informe o ID do restaurante que deseja remover: ");
        int id = sc.nextInt();
        Restaurante r = service.buscarPorID(id);

        if (r != null){
            System.out.println("Dados do restaurante: \n"+ r);
            System.out.println("==============================");
            System.out.println("Tem certeza que deseja excluir: (s/n)?");
            char confirm = sc.next().charAt(0);

            if (confirm == 's'){
                service.remover(r);
                System.out.println("Restaurante excluído.");
                menuInicial();
            } else if (confirm == 'n') {
                System.out.println("Retornando...");
            }
        }
        else{
            System.out.println("Restaurante não encontrado.");
        }
    }
}
