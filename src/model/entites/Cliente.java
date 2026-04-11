package model.entites;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private String email;

    //Cliente possui vários endereços e pedidos
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    // =============== MÉTODOS CONSTRUTORES ===============
    public Cliente(){}

    public Cliente(Integer id, String nome, String cpf, String telefone, String email) {
        super(id, nome, cpf, telefone);
        this.email = email;
    }
    //======================================================


    // =========================== GETTERS & SETTERS ===========================
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Endereco> getEnderco() {
        return enderecos;
    }
    //===========================================================================


    //============ ADICIONAR E REMOVER DAS LISTAS ============
    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public void removePedido(Pedido pedido){
        pedidos.remove(pedido);
    }

    public void addEndereco(Endereco endereco){
        enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco){
        enderecos.remove(endereco);
    }
}
