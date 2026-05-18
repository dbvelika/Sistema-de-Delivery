package views;

import dao.ProdutoDAO;
import dao.RestauranteDAO;
import model.entites.Produto;
import model.entites.Restaurante;
import service.GerenciadorProdutos;
import service.GerenciadorRestaurante;

import java.util.Scanner;

public class MenuProdutos extends Menu{
    Restaurante restaurante;
    GerenciadorRestaurante gerRest;

    public void menuProdutos(Scanner sc, ProdutoDAO daoService, RestauranteDAO restauranteDAO){

        int opcao = 0;
        do{
            System.out.println("========== GERENCIAR PRODUTOS ==========");
            System.out.println("1 - Inserir produto");
            System.out.println("2 - Atualizar produto");
            System.out.println("3 - Excluir produto");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            sc.nextLine();

            switch(opcao){
                case 1: menuCadastro(sc, daoService, restauranteDAO); break;
                case 2: menuAtualizar(sc, daoService, restauranteDAO); break;
                case 3: menuExcluir(sc, daoService, restauranteDAO); break;
                case 0: break;
                default: System.out.println("Opção Inválida.");
            }
        }while (opcao != 0);
    }

    public void menuCadastro(Scanner sc, ProdutoDAO daoService, RestauranteDAO restauranteDao){
        System.out.println("===== CADASTRAR PRODUTO =====");

        System.out.println("LISTA DE RESTAURANTES: : ");
        for (Restaurante r : restauranteDao.listar()){
            System.out.println(r);
        }
        System.out.println("==============================================================");
        System.out.print("Esclha o id do restaurante onde o produro será cadastrado: ");
        Integer idRest = sc.nextInt();
        sc.nextLine();

        if (restauranteDao.findById(idRest) == null){
            System.out.println("Restaurante não encontrado.");
            return;
        }
        Restaurante restaurante = new Restaurante();

        System.out.print("Informe o nome do produto: ");
        String nome = sc.nextLine();

        System.out.print("Informe uma breve descrição do produto: ");
        String descricao = sc.nextLine();

        System.out.print("Informe o preço do produto: ");
        Double preco = sc.nextDouble();

        System.out.print("Informe a categoria do produto: ");
        String categoria = sc.nextLine();

        Produto produto = new Produto(null, nome, descricao, preco, categoria, restaurante);

        daoService.insert(produto);

        System.out.println("Produto "+ produto.getNome() +" adicionado com sucesso.");
    }

    public void menuAtualizar(Scanner sc, ProdutoDAO daoService, RestauranteDAO restauranteDAO){
        System.out.println("===== ATUALIZAR PRODUTO =====");
        System.out.print("Informe o id do produto que deseja alterar: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        Produto p = daoService.findById(id);

        if(p != null) {
            System.out.println("===== DADOS ATUAIS =====");
            System.out.println(p);

            int aws = 0;
            do {
                System.out.println();
                System.out.println("1 - Nome");
                System.out.println("2 - Descrição");
                System.out.println("3 - Preço");
                System.out.println("4 - Categoria");
                System.out.println("5 - Restaurante");
                System.out.println("0 - Voltar");
                System.out.println("Escolha uma opção: ");
                aws = sc.nextInt();

                sc.nextLine();
                switch (aws) {
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        String novoNome = sc.nextLine();
                        p.setNome(novoNome);
                        daoService.update(p);
                        System.out.println("Nome do produto alterado com sucesso!");
                        System.out.println(p);
                        break;

                    case 2:
                        System.out.print("Informe a nova descrição: ");
                        String novaDescricao = sc.nextLine();
                        p.setDescricao(novaDescricao);
                        daoService.update(p);
                        System.out.println("Descrição do produto alterada com sucesso!");
                        System.out.println(p);
                        break;

                    case 3:
                        System.out.print("Informe o novo preço: ");
                        Double novoPreco = sc.nextDouble();
                        p.setPreco(novoPreco);
                        daoService.update(p);
                        System.out.println("Preço do produto alterado com sucesso!");
                        System.out.println(p);
                        break;

                    case 4:
                        System.out.print("Informe a nova categoria: ");
                        String novaCateg = sc.nextLine();
                        p.setCategoria(novaCateg);
                        daoService.update(p);
                        System.out.println("Categoria do produto alterada com sucesso!");
                        System.out.println(p);
                        break;

                    case 5:
                        System.out.println("LISTA DE RESTAURANTES: : ");
                        for (Restaurante r : restauranteDAO.listar()){
                            System.out.println(r);
                        }
                        System.out.println("==============================================================");
                        System.out.print("Esclha o id do restaurante que o produto será atualizado: ");
                        Integer idRest = sc.nextInt();

                        if (restauranteDAO.findById(idRest) == null){
                            System.out.println("Restaurante não encontrado.");
                            return;
                        }
                        p.setRestaurante(restaurante);

                        daoService.update(p);
                        System.out.println("Restaurante do produto alterado com sucesso!");

                        System.out.println(p);
                        sc.nextLine();

                    case 0: break;

                    default: System.out.println("Opção Inválida!");
                }
            } while (aws != 0);
        }
        else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void menuExcluir(Scanner sc, ProdutoDAO daoService, RestauranteDAO restauranteDAO){
        System.out.println("===== REMOVER PRODUTO =====");
        daoService.listar();
        System.out.print("Informe o ID do produto que deseja remover: ");
        int id = sc.nextInt();
        Produto p = daoService.findById(id);

        if (p != null){
            System.out.println("Dados do produto: \n"+ p);
            System.out.println("==============================");
            System.out.println("Tem certeza que deseja excluir: (s/n)?");
            char confirm = sc.next().charAt(0);

            if (confirm == 's'){
                daoService.deleteById(id);
                System.out.println("Produto excluído.");
            } else if (confirm == 'n') {
                System.out.println("Retornando...");
            }
        }
        else{
            System.out.println("Produto não encontrado.");
        }
    }
}
