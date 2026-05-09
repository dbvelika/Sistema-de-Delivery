package service;

import model.entites.Entregador;
import model.entites.Pedido;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorEntregadores implements Crud<Entregador>{
    private Integer proximoId = 1;
    private List<Entregador> entregadores = new ArrayList<>();


    @Override
    public void cadastrar(Entregador entregador) {
        Integer id = entregador.setId(proximoId);
        proximoId++;
        entregadores.add(entregador);

    }

    @Override
    public void remover(Entregador entregador) {
        entregadores.remove(entregador);
    }

    @Override
    public Entregador buscarPorID(int id) {
        for(Entregador e : entregadores){
            if(e.getId() != null){
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Entregador> listar() {
        System.out.println("Entregadores disponíveis: ");
        return entregadores;
    }

    public void atribuirPedido(Pedido pedido){

    }
}
