package views;

import dao.RestauranteDAO;
import model.entites.Restaurante;
import service.GerenciadorRestaurante;

import java.util.Scanner;

public class MenuRestaurantes extends Menu{

    public void menuRestaurantes(Scanner sc, RestauranteDAO daoService){
        int opcao = 0;
        do {
            System.out.println("========== GERENCIAR RESTAURANTES ==========");
            System.out.println("1 - Inserir restaurante");
            System.out.println("2 - Atualizar restaurante");
            System.out.println("3 - Excluir restaurante");
            System.out.println("4 - Listar Restaurantes");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            sc.nextLine();

            switch(opcao){
                case 1: menuCadastro(sc, daoService); break;
                case 2: menuAtualizar(sc, daoService); break;
                case 3: menuExcluir(sc, daoService); break;
                case 4: menuListar(sc, daoService); break;
                case 0: break;
                default: System.out.println("Opção Inválida.");
            }
        }while (opcao != 0);
    }

    public void menuCadastro(Scanner sc, RestauranteDAO daoService){
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

        daoService.inserir(restaurante);
        System.out.println("Restaurante "+ restaurante.getNome() +" adicionado com sucesso.");
    }

    public void menuAtualizar(Scanner sc, RestauranteDAO daoService){
        System.out.println("===== ATUALIZAR RESTAURANTE =====");
        daoService.listar();
        System.out.print("Informe o id do restaurante que deseja alterar: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        Restaurante r = daoService.findById(id);

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
                System.out.println("Escolha uma opção para alterar: ");
                aws = sc.nextInt();

                sc.nextLine();
                switch (aws) {
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        String novoNome = sc.nextLine();
                        r.setNome(novoNome);
                        System.out.println("Nome do restaurante alterado com sucesso!");
                        daoService.update(r);
                        System.out.println(r);
                        break;

                    case 2:
                        System.out.print("Informe o novo endereço: ");
                        String novoEndereco = sc.nextLine();
                        r.setEndereco(novoEndereco);
                        System.out.println("Endereço do restaurante alterado com sucesso!");
                        daoService.update(r);
                        System.out.println(r);
                        break;

                    case 3:
                        System.out.print("Informe o novo CNPJ: ");
                        String novoCnpj = sc.nextLine();
                        r.setCnpj(novoCnpj);
                        System.out.println("CNPJ do restaurante alterado com sucesso!");
                        daoService.update(r);
                        System.out.println(r);
                        break;

                    case 4:
                        System.out.print("Informe o novo telefone: ");
                        String novoTel = sc.nextLine();
                        r.setTelefone(novoTel);
                        System.out.println("Telefone do restaurante alterado com sucesso!");
                        daoService.update(r);
                        System.out.println(r);
                        break;

                    case 5:
                        System.out.print("Informe a nova categoria: ");
                        String novaCateg = sc.nextLine();
                        r.setCategoria(novaCateg);
                        System.out.println("Categoria do restaurante alterado com sucesso!");
                        daoService.update(r);
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

    public void menuExcluir(Scanner sc, RestauranteDAO daoService){
        System.out.println("===== REMOVER RESTAURANTE =====");
        daoService.listar();
        System.out.print("Informe o ID do restaurante que deseja remover: ");
        int id = sc.nextInt();
        Restaurante r = daoService.findById(id);

        if (r != null){
            System.out.println("Dados do restaurante: \n"+ r);
            System.out.println("==============================");
            System.out.println("Tem certeza que deseja excluir: (s/n)?");
            char confirm = sc.next().charAt(0);

            if (confirm == 's'){
                daoService.deleteById(id);
                System.out.println("Restaurante excluído.");
            } else if (confirm == 'n') {
                System.out.println("Retornando...");
            }
        }
        else{
            System.out.println("Restaurante não encontrado.");
        }
    }

    public void menuListar(Scanner sc, RestauranteDAO daoService) {

        System.out.println("===== LISTA DE RESTAURANTES =====");

        for(Restaurante r : daoService.listar()){

            System.out.println("----------------------------");
            System.out.println("ID: " + r.getId());
            System.out.println("Nome: " + r.getNome());
            System.out.println("Endereço: " + r.getEndereco());
            System.out.println("CNPJ: " + r.getCnpj());
            System.out.println("Telefone: " + r.getTelefone());
            System.out.println("Categoria: " + r.getCategoria());
        }
    }
}
