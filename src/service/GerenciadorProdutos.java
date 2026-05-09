package service;

import model.entites.Produto;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos implements Crud<Produto>{

    private Integer proximoId = 1;

    List<Produto> produtos = new ArrayList<>();

    @Override
    public void cadastrar(Produto produto) {
        produto.setId(proximoId);
        proximoId++;
        produtos.add(produto);
    }

    @Override
    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    @Override
    public Produto buscarPorID(int id) {
        for(Produto p : produtos){
            if (p.getId() != null){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Produto> listar() {
        return produtos;
    }
}
