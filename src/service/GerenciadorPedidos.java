package service;

import model.entites.*;
import model.enums.StatusPedido;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos implements Crud<Pedido>{
    private Integer proximoId = 1;
    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void cadastrar(Pedido pedido) {
        pedido.setId(proximoId++);
        pedidos.add(pedido);
    }

    @Override
    public void remover(Pedido pedido) {
        pedidos.remove(pedido);
    }

    @Override
    public Pedido buscarPorID(int id) {
        for(Pedido p : pedidos){
            if(p.getId() != null){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Pedido> listar() {
        return List.of();
    }
}
