package views;

import model.entites.*;
import model.enums.StatusEntregador;
import model.enums.StatusPedido;
import service.*;

import java.util.Scanner;

public class MenuPedidos extends Menu{


    public void menuPedidos(Scanner sc, GerenciadorPedidos service, GerenciadorClientes gerCli, GerenciadorProdutos gerProd, GerenciadorRestaurante gerRest, Restaurante restaurante, GerenciadorEntregadores gerEntregador){
        int opcao = 0;
        do {
            System.out.println("========== GERENCIAR PEDIDOS ==========");
            System.out.println("1 - Criar pedido");
            System.out.println("2 - Adicionar item ao pedido");
            System.out.println("3 - Remover item do pedido");
            System.out.println("4 - Atribuir entregador");
            System.out.println("5 - Atualizar status");
            System.out.println("6 - Listar pedidos");
            System.out.println("0 - Voltar");
            opcao = sc.nextInt();

            sc.nextLine();

            switch(opcao){
                case 1: menuCadastro(sc, service, gerCli, gerProd, gerRest); break;
                case 2: menuAtualizar(sc, service, gerProd); break;
                case 3: menuExcluir(sc, service); break;
                case 4: menuAtribuirEntregador(sc, service, gerEntregador);
                case 6: menuListar(service);break;
                case 0: break;
                default: System.out.println("Opção Inválida.");
            }
        }while (opcao != 0);
    }

    public void menuCadastro(Scanner sc, GerenciadorPedidos service, GerenciadorClientes gerCli, GerenciadorProdutos gerProd, GerenciadorRestaurante gerRest){
        Pedido pedido = new Pedido();

        for(Cliente c : gerCli.listar()){
            System.out.println(c);
        }
        System.out.print("Informe o ID do cliente: ");
        Integer idCliente = sc.nextInt();
        sc.nextLine();

        Cliente cliente = gerCli.buscarPorID(idCliente);
        if (cliente == null){
            System.out.println("Cliente não encontrado.");
            return;
        }
        pedido.setCliente(cliente);

        System.out.println();
        for(Endereco e : cliente.getEnderecos()){
            System.out.println(e);
        }

        System.out.println();
        System.out.print("Escolha um endereço para a entrega: ");
        int idEndereco = sc.nextInt();
        sc.nextLine();

        Endereco enderecoEscolhido = null;
        for(Endereco end : cliente.getEnderecos()){
            if(end.getId().equals(idEndereco)){
                enderecoEscolhido = end;
                break;
            }
        }

        if(enderecoEscolhido != null){
            pedido.setEndereco(enderecoEscolhido);
        }
        else{
            System.out.println("Endereço não encontrado.");
            return;
        }

        System.out.println();
        System.out.print("Escolha o restarurante responsável pelo pedido: ");
        int idRest = sc.nextInt();
        sc.nextLine();

        Restaurante r = gerRest.buscarPorID(idRest);
        if(r != null){
            pedido.setRestaurante(r);
        }
        else {
            System.out.println("Restaurante não encontrado.");
        }

        for (Produto p : r.getProdutos()){
            System.out.println(p);
        }

        char resposta = 0;
        do {
            System.out.println();
            System.out.print("Escolha um produto: ");
            int idProduto = sc.nextInt();
            sc.nextLine();
            Produto produto = gerProd.buscarPorID(idProduto);

            if(!r.getProdutos().contains(produto)){
                System.out.println("Esse produto não pertence ao restaurante.");
                continue;
            }

            if(produto == null){
                System.out.println("Produto não encontrado.");
                continue;
            }

            System.out.print("Informe a quantidade de produtos no pedido: ");
            int quantidade = sc.nextInt();

            ItemPedido item = new ItemPedido(produto, quantidade);
            pedido.adicionarItem(item);
            System.out.println("Item "+ item +" adicionado ao pedido.");
            System.out.println("Deseja adicionar mais produtos? (S/N):");
            resposta = sc.next().charAt(0);
        }while (resposta == 's' || resposta == 'S');

        pedido.calcularTotal();

        System.out.println("===== RESUMO DO PEDIDO =====");
        System.out.println("Subtotal: " + pedido.getSubtotal());
        System.out.println("Desconto: " + pedido.getDesconto());
        System.out.println("Total: " + pedido.getValorTotal());
        System.out.print("Deseja confirmar o pedido (S/N)?: ");
        char confirmacao = sc.next().charAt(0);

        if(confirmacao == 's' || confirmacao == 'S'){
            service.cadastrar(pedido);
            System.out.println("Pedido cadastrado com sucesso!");
        }
        else{
            System.out.println("Retornando ao menu inicial...");
            return;
        }
    }

    public void menuListar(GerenciadorPedidos service) {

        System.out.println("===== LISTA DE PEDIDOS =====");

        if(service.listar().isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        for(Pedido p : service.listar()) {
            p.calcularTotal();
            System.out.println(p);
            System.out.println();
        }
    }

    public void menuAtribuirEntregador(
            Scanner sc,
            GerenciadorPedidos gerPedido,
            GerenciadorEntregadores gerEntregador){

        System.out.println("===== PEDIDOS =====");

        for(Pedido p : gerPedido.listar()){
            System.out.println(p);
        }

        System.out.print("Informe o ID do pedido: ");
        Integer idPedido = sc.nextInt();

        Pedido pedido = gerPedido.buscarPorID(idPedido);

        if(pedido == null){
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("===== ENTREGADORES DISPONÍVEIS =====");

        for(Entregador e : gerEntregador.listar()){

            if(e.getStatus() == StatusEntregador.DISPONIVEL){
                System.out.println(e);
            }
        }

        System.out.print("Informe o ID do entregador: ");
        Integer idEntregador = sc.nextInt();

        Entregador entregador =
                gerEntregador.buscarPorID(idEntregador);

        if(entregador == null){
            System.out.println("Entregador não encontrado.");
            return;
        }

        boolean sucesso =
                pedido.atribuirEntregador(entregador);

        if(sucesso){
            System.out.println("Entregador atribuído com sucesso.");
        }
        else{
            System.out.println("Entregador indisponível.");
        }
    }

    public void menuAtualizarStatus(
            Scanner sc,
            GerenciadorPedidos service){

        System.out.println("===== PEDIDOS =====");

        for(Pedido p : service.listar()){
            System.out.println(p);
        }

        System.out.print("Informe o ID do pedido: ");
        Integer id = sc.nextInt();

        Pedido pedido = service.buscarPorID(id);

        if(pedido == null){
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("===== STATUS =====");
        System.out.println("1 - EM_PREPARO");
        System.out.println("2 - SAIU_PARA_ENTREGA");
        System.out.println("3 - ENTREGUE");
        System.out.println("4 - CANCELADO");

        int opcao = sc.nextInt();

        boolean atualizado = false;

        switch(opcao){

            case 1:
                if (pedido.getStatus() != StatusPedido.ENTREGUE) {
                    pedido.atualizarStatus(StatusPedido.EM_PREPARO);
                    atualizado = true;
                }
                break;

            case 2:
                if (pedido.getStatus() != StatusPedido.ENTREGUE) {
                    pedido.atualizarStatus(StatusPedido.SAIU_PARA_ENTREGA);
                }
                break;

            case 3:
                if(pedido.getStatus() == StatusPedido.SAIU_PARA_ENTREGA){
                    pedido.atualizarStatus(StatusPedido.ENTREGUE);
                    atualizado = true;
                }
                else{
                    System.out.println("Não foi possível entregar. Status atual: "+ pedido.getStatus());
                }
                break;

            case 4:
                if (pedido.getStatus() != StatusPedido.ENTREGUE) {
                    pedido.atualizarStatus(StatusPedido.CANCELADO);
                    atualizado = true;
                }
                else{
                    System.out.println("Não foi possível cancelar: Pedido entregue.");
                }
                break;

            default:
                System.out.println("Opção inválida.");
                return;
        }

        if (atualizado) {
            System.out.println("Status atualizado com sucesso.");
        }
    }

    public void menuExcluir(
            Scanner sc,
            GerenciadorPedidos service){

        System.out.println("===== PEDIDOS =====");

        for(Pedido p : service.listar()){
            System.out.println(p);
        }

        System.out.print("Informe o ID do pedido: ");
        Integer id = sc.nextInt();

        Pedido pedido = service.buscarPorID(id);

        if(pedido == null){
            System.out.println("Pedido não encontrado.");
            return;
        }

        if(pedido.getStatus() == StatusPedido.ENTREGUE
                || pedido.getStatus() ==
                StatusPedido.SAIU_PARA_ENTREGA){

            System.out.println("Não é possível excluir esse pedido.");

            return;
        }

        System.out.print("Deseja realmente excluir? (S/N): ");

        char confirmacao = sc.next().charAt(0);

        if(confirmacao == 's' || confirmacao == 'S'){
            service.remover(pedido);
            System.out.println("Pedido removido com sucesso.");
        }
    }

    public void menuAtualizar(
            Scanner sc,
            GerenciadorPedidos gerPedido,
            GerenciadorProdutos gerProd){

        System.out.println("===== PEDIDOS =====");

        for(Pedido p : gerPedido.listar()){
            System.out.println(p);
        }

        System.out.print("Informe o ID do pedido: ");
        Integer idPedido = sc.nextInt();
        sc.nextLine();

        Pedido pedido = gerPedido.buscarPorID(idPedido);

        if(pedido == null){
            System.out.println("Pedido não encontrado.");
            return;
        }

        // VALIDAÇÃO DE STATUS
        if(pedido.getStatus() == StatusPedido.ENTREGUE
                || pedido.getStatus() == StatusPedido.CANCELADO){

            System.out.println("Não é possível alterar esse pedido.");
            return;
        }

        int opcao = 0;

        do {

            System.out.println();
            System.out.println("===== ATUALIZAR PEDIDO =====");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Remover item");
            System.out.println("3 - Alterar quantidade");
            System.out.println("0 - Voltar");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){

                // ==========================
                // ADICIONAR ITEM
                // ==========================
                case 1:

                    System.out.println("===== PRODUTOS =====");

                    for(Produto p : pedido.getRestaurante().getProdutos()){
                        System.out.println(p);
                    }

                    System.out.print("Informe o ID do produto: ");
                    Integer idProduto = sc.nextInt();
                    sc.nextLine();

                    Produto produto =
                            gerProd.buscarPorID(idProduto);

                    if(produto == null){
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    // VALIDA SE PRODUTO PERTENCE AO RESTAURANTE
                    if(!pedido.getRestaurante().getProdutos().contains(produto)){
                        System.out.println("Produto não pertence ao restaurante.");
                        break;
                    }

                    System.out.print("Informe a quantidade: ");
                    Integer quantidade = sc.nextInt();
                    sc.nextLine();

                    ItemPedido novoItem = new ItemPedido(produto, quantidade);
                    pedido.adicionarItem(novoItem);
                    pedido.calcularTotal();

                    System.out.println("Item adicionado.");
                    break;

                // ==========================
                // REMOVER ITEM
                // ==========================
                case 2:
                    System.out.println("===== ITENS =====");

                    for(ItemPedido item : pedido.getItens()){
                        System.out.println(item);
                    }

                    System.out.print("Informe o ID do produto que deseja remover: ");

                    Integer idRemover = sc.nextInt();
                    sc.nextLine();

                    ItemPedido itemRemover = null;

                    for(ItemPedido item : pedido.getItens()){

                        if(item.getProduto().getId().equals(idRemover)){
                            itemRemover = item;
                            break;
                        }
                    }
                    if(itemRemover != null){
                        pedido.removerItem(itemRemover);
                        pedido.calcularTotal();
                        System.out.println("Item removido.");
                    }
                    else{
                        System.out.println("Item não encontrado.");
                    }
                    break;

                // ==========================
                // ALTERAR QUANTIDADE
                // ==========================
                case 3:

                    System.out.println("===== ITENS =====");

                    for(ItemPedido item : pedido.getItens()){
                        System.out.println(item);
                    }

                    System.out.print("Informe o ID do produto: ");
                    Integer idAlterar = sc.nextInt();
                    sc.nextLine();

                    ItemPedido itemAlterar = null;

                    for(ItemPedido item : pedido.getItens()){

                        if(item.getProduto().getId().equals(idAlterar)){
                            itemAlterar = item;
                            break;
                        }
                    }

                    if(itemAlterar != null){
                        System.out.print("Informe a nova quantidade: ");
                        Integer novaQuantidade = sc.nextInt();
                        sc.nextLine();

                        itemAlterar.setQuantidade(novaQuantidade);
                        pedido.calcularTotal();

                        System.out.println("Quantidade atualizada.");
                    }
                    else{
                        System.out.println("Item não encontrado.");
                    }
                    break;

                case 0: break;

                default: System.out.println("Opção inválida.");
            }

        } while(opcao != 0);
    }
}
