package service;

import model.entites.Cliente;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorClientes implements Crud<Cliente>{
    private Integer proximoId = 1;
    private List<Cliente> clientes = new ArrayList<>();


    @Override
    public void cadastrar(Cliente cliente) {
        Integer id = cliente.setId(proximoId);
        proximoId++;
        clientes.add(cliente);

    }

    @Override
    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public Cliente buscarPorID(int id) {
        for(Cliente c : clientes){
            if(c.getId() != null){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        System.out.println("Clientes: ");
        return clientes;
    }
}
