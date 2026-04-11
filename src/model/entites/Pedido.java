package model.entites;

import model.enums.StatusPedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Integer id;
    private StatusPedido status;

    /*UM PEDIDO POSSUI 1 CLIENTE, RECEBE 1 ENDEREÇO, PERTENCE A 1 RESTAURANTE,
    É ENTREGUE POR 1 ENTREGADOR E COMPÕE VÁRIOS PEDISOS
     */
    private Cliente cliente;
    private Endereco endereco;
    private Restaurante restaurante;
    private Entregador entregador;
    List<ItemPedido> itens = new ArrayList<>();


    // ========== MÉTODOS CONSTRUTORES ==========
    public Pedido(){}

    public Pedido(Integer id, StatusPedido status, Cliente cliente, Endereco endereco, Restaurante restaurante, Entregador entregador, List<ItemPedido> itens) {
        this.id = id;
        this.status = status;
        this.cliente = cliente;
        this.endereco = endereco;
        this.restaurante = restaurante;
        this.entregador = entregador;
        this.itens = itens;
    }
    //===========================================

    // ========================= GETTERS & SETTERS =========================
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
    //===========================================

    //============================= ADICIONAR E REMOVER DAS LISTAS =============================
    public void addItens(ItemPedido item){
        itens.add(item);
    }

    public void removeItens(ItemPedido item){
        itens.remove(item);
    }
}
