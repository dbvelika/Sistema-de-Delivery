package views;

import model.entites.Cliente;
import model.entites.Endereco;
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
                case 2: menuAtualizar(sc, service, new Endereco()); break;
                case 3: menuExcluir(sc, service); break;
                case 0: break;
                default: System.out.println("Opção Inválida.");
            }
        }while (opcao != 0);
    }

    public void menuCadastro(Scanner sc, GerenciadorClientes service){
        Cliente cliente = new Cliente();
        System.out.println("===== CADASTRAR CLIENTE =====");
        System.out.print("Informe o nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Informe o cpf do cliente: ");
        String cpf = sc.nextLine();

        System.out.print("Informe o telefone do cliente: ");
        String tel = sc.nextLine();

        System.out.print("Informe email do cliente: ");
        String email = sc.nextLine();

        char resposta = 'a';
        do{
            System.out.print("Informe o número do endereço: ");
            int numero = sc.nextInt();
            sc.nextLine();

            System.out.print("Informe o nome da rua: ");
            String rua = sc.nextLine();

            System.out.print("Informe o nome da cidade: ");
            String nomeCidade = sc.nextLine();

            System.out.print("Informe o CEP:");
            Integer cep = sc.nextInt();

            Endereco e = new Endereco(null, numero, rua, nomeCidade, cep);
            cliente.addEndereco(e);

            cliente = new Cliente(null, nome, cpf, tel, email, e);

            System.out.print("Deseja adicionar outro endereço? (S/N): ");
            resposta = sc.next().charAt(0);
        }while (resposta != 'n' && resposta != 'N');

        service.cadastrar(cliente);
        System.out.println("Cliente "+ cliente.getNome() +" adicionado com sucesso.");
        System.out.println();
    }

    public void menuAtualizar(Scanner sc, GerenciadorClientes service, Endereco endereco){
        System.out.println("===== ATUALIZAR CLIENTE =====");
        service.listar();

        System.out.print("Informe o ID do cliente que deseja alterar: ");
        int id = sc.nextInt();

        Cliente c = service.buscarPorID(id);

        if (c != null){
            System.out.println("===== DADOS ATUAIS =====");
            System.out.println(c);

            int aws = 0;

            do{
                System.out.println();
                System.out.println("1 - Nome");
                System.out.println("2 - Telefone");
                System.out.println("3 - Email");
                System.out.println("4 - Endereço");
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
                        break;

                    case 4:
                        System.out.print("Endereços do cliente: ");
                        for (Endereco e : c.getEnderecos()) {
                            System.out.println(e);
                        }
                        System.out.println("Escolha um endereço para alterar: ");
                        int idEndereco = sc.nextInt();
                        sc.nextLine();

                        Endereco e = endereco.buscarPorID(idEndereco);
                        if(e != null){
                            int opcao = 0;
                            do {
                                System.out.println("ENDEREÇO SELECIONADO:");
                                System.out.println(e);
                                System.out.println("1 - Rua");
                                System.out.println("2 - Número");
                                System.out.println("3 - Cidade");
                                System.out.println("4 - CEP");
                                System.out.println("5 - Remover endereço");
                                System.out.println("0 - Voltar");
                                System.out.print("Qual informação deseja alterar?: ");
                                opcao = sc.nextInt();
                                sc.nextLine();

                                switch (opcao){
                                    case 1:
                                        System.out.print("Digite a nova rua: ");
                                        String novaRua = sc.nextLine();
                                        e.setRua(novaRua);
                                        System.out.println("Rua alterada com sucesso! \nNova rua: "+ e.getRua());
                                        break;

                                    case 2:
                                        System.out.print("Digite o novo número: ");
                                        int novoNumero = sc.nextInt();
                                        e.setNumero(novoNumero);
                                        System.out.println("Número alterado com sucesso. \nNovo número:"+ e.getNumero());
                                        break;

                                    case 3:
                                        System.out.print("Digite a nova cidade: ");
                                        String novaCidade = sc.nextLine();
                                        e.setCidade(novaCidade);
                                        System.out.println("Cidade alterada com sucesso! \nNova cidade: "+ e.getCidade());
                                        break;

                                    case 4:
                                        System.out.print("Digite o novo CEP");
                                        Integer novoCep = sc.nextInt();
                                        e.setCep(novoCep);
                                        System.out.println("CEP alterado com sucesso! \nNovo CEP: "+ e.getCep());
                                        break;

                                    case 5:
                                        System.out.print("Tem certeza que deseja excluir o endereço? (S/N):");
                                        char resposta = sc.next().charAt(0);
                                        if(resposta == 's' || resposta == 'S'){
                                            c.removeEndereco(e);
                                            System.out.println("Endereço excluído.");
                                        }
                                        else{
                                            return;
                                        }
                                        break;

                                    case 0: return;

                                    default:
                                        System.out.println("Opção invlálida.");
                                        System.out.println(); break;
                                }
                            }while (opcao != 0);
                        }

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

            if (confirm == 's' || confirm == 'S'){
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
