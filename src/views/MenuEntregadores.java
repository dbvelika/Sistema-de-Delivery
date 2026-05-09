package views;

import model.entites.Entregador;
import model.enums.StatusEntregador;
import model.enums.TipoVeiculo;
import service.GerenciadorEntregadores;

import java.util.Scanner;

public class MenuEntregadores extends Menu{

    public void menuEntregadores(Scanner sc, GerenciadorEntregadores service){
        int opcao;
        do{
            System.out.println("========== GERENCIAR ENTREGADORES ==========");
            System.out.println("1 - Inserir entregador");
            System.out.println("2 - Atualizar informações do entregador");
            System.out.println("3 - Excluir entregador");
            System.out.println("4 - Verificar disponibilidade");
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

    public void menuCadastro(Scanner sc, GerenciadorEntregadores service){
        System.out.println("===== CADASTRAR ENTREGADOR =====");
        System.out.print("Informe o nome do entregador: ");
        String nome = sc.nextLine();

        System.out.print("Informe o cpf do entregador: ");
        String cpf = sc.nextLine();

        System.out.print("Informe o telefone do entregador: ");
        String tel = sc.nextLine();

        System.out.print("Informe o veículo do entregador (CARRO/MOTO/BICICLETA): ");
        TipoVeiculo veiculo = TipoVeiculo.valueOf(sc.nextLine());

        System.out.print("Informe o status do entregador (DISPONÍVEL/EM ENTREGA): ");
        StatusEntregador status = StatusEntregador.valueOf(sc.nextLine());

        Entregador entregador = new Entregador(null ,nome, cpf, tel, veiculo, status);

        service.cadastrar(entregador);

        System.out.println("Entregador "+ entregador.getNome() +" adicionado com sucesso.");
    }

    public void menuAtualizar(Scanner sc, GerenciadorEntregadores service){
        System.out.println("===== ATUALIZAR ENTREGADOR =====");
        service.listar();

        System.out.println("Informe o ID do entregador que deseja alterar: ");
        int id = sc.nextInt();

        Entregador e = service.buscarPorID(id);

        if (e.getId() != null){
            System.out.println("===== DADOS ATUAIS =====");
            System.out.println(e);

            int aws = 0;

            do{
                System.out.println();
                System.out.println("1 - Nome");
                System.out.println("2 - Telefone");
                System.out.println("3 - Veiculo");
                System.out.println("0 - Voltar");
                System.out.print("Selecione uma opção para alterar: ");
                aws = sc.nextInt();

                sc.nextLine();
                switch (aws){
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        String novoNome = sc.nextLine();
                        e.setNome(novoNome);
                        System.out.println("Nome alterado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Informe o novo telefone: ");
                        String novoTel = sc.nextLine();
                        e.setTelefone(novoTel);
                        System.out.println("Telefone do entregador alterado com sucesso!");
                        System.out.println(e);
                        break;

                    case 3:
                        System.out.print("Informe o novo veículo (CARRO/MOTO/BICILETA): ");
                        String novoVeiculo = sc.nextLine();
                        e.setVeiculo(TipoVeiculo.valueOf(novoVeiculo));
                        System.out.println("Veículo do entregador alterado com sucesso!");
                        System.out.println(e);
                        break;

                    default: System.out.print("Opção inválida.");
                }
            }while (aws != 0);
        }
        else{
            System.out.println("Entregador não encontrado.");
        }
    }

    public void menuExcluir(Scanner sc, GerenciadorEntregadores service){
        System.out.println("===== EXCLUIR ENTREGADORES =====");
        service.listar();
        System.out.print("Informe o ID do entregador que deseja remover: ");
        int id = sc.nextInt();
        Entregador e = service.buscarPorID(id);

        if(e != null){
            System.out.println("Dados do entregador: \n"+ e);
            System.out.println("Tem certeza que deseja excluir: (s/n)?");
            char confirm = sc.next().charAt(0);

            if (confirm == 's'){
                service.remover(e);
                System.out.println("Entregador excluído.");
                menuInicial();
            } else if (confirm == 'n') {
                System.out.println("Retornando...");
            }
        }
        else{
            System.out.println("Entregador não encontrado.");
        }
    }
}


