package views;

import model.entites.Cliente;
import service.GerenciadorClientes;

import java.util.Scanner;

public class MenuClientes extends Menu{

    public void menuClientes(Scanner sc, GerenciadorClientes service){
        int opcao;
        do{
            System.out.println("========== GERENCIAR CLIENTES ==========");
            System.out.println("1 - Inserir cliente");
            System.out.println("2 - Atualizar infromações do cliente");
            System.out.println("3 - Excluir cliente");
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

    public void menuCadastro(Scanner sc, GerenciadorClientes service){
        System.out.println("===== CADASTRAR CLIENTE =====");
        System.out.print("Informe o nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Informe o cpf do cliente: ");
        String cpf = sc.nextLine();

        System.out.print("Informe o telefone do cliente: ");
        String tel = sc.nextLine();

        System.out.print("Informe email do cliente: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(null, nome, cpf, tel, email);

        service.cadastrar(cliente);
        System.out.println("Cliente "+ cliente.getNome() +" adicionado com sucesso.");
    }

    public void menuAtualizar(Scanner sc, GerenciadorClientes service){
        System.out.println("===== ATUALIZAR CLIENTE =====");
        service.listar();

        System.out.println("Informe o ID do cliente que deseja alterar: ");
        int id = sc.nextInt();

        Cliente c = service.buscarPorID(id);

        if (c.getId() != null){
            System.out.println("===== DADOS ATUAIS =====");
            System.out.println(c);

            int aws = 0;

            do{
                System.out.println();
                System.out.println("1 - Nome");
                System.out.println("2 - Telefone");
                System.out.println("3 - Email");
                System.out.println("0 - Voltar");
                System.out.print("Selecione uma opção para alterar: ");
                aws = sc.nextInt();

                sc.nextLine();
                switch (aws){
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        String novoNome = sc.nextLine();
                        c.setNome(novoNome);
                        System.out.println("Nome alterado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Informe o novo telefone: ");
                        String novoTel = sc.nextLine();
                        c.setTelefone(novoTel);
                        System.out.println("Telefone do cliente alterado com sucesso!");
                        System.out.println(c);
                        break;

                    case 3:
                        System.out.print("Informe o novo email: ");
                        String email = sc.nextLine();

                    default: System.out.print("Opção inválida.");
                }
            }while (aws != 0);
        }
        else{
            System.out.println("Cliente não encontrado.");
        }
    }

    public void menuExcluir(Scanner sc, GerenciadorClientes service){
        System.out.println("===== EXCLUIR CLIENTES =====");
        service.listar();
        System.out.print("Informe o ID do cliente que deseja remover: ");
        int id = sc.nextInt();
        Cliente c = service.buscarPorID(id);

        if(c != null){
            System.out.println("Dados do cliente: \n"+ c);
            System.out.println("Tem certeza que deseja excluir: (s/n)?");
            char confirm = sc.next().charAt(0);

            if (confirm == 's'){
                service.remover(c);
                System.out.println("Cliente excluído.");
                menuInicial();
            } else if (confirm == 'n') {
                System.out.println("Retornando...");
            }
        }
        else{
            System.out.println("Cliente não encontrado.");
        }
    }
}
