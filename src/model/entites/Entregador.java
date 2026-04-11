package model.entites;

import model.enums.StatusEntregador;
import model.enums.TipoVeiculo;

import java.util.ArrayList;
import java.util.List;

public class Entregador extends Pessoa {
    private TipoVeiculo veiculo;
    private StatusEntregador status;

    // Um entregador entrega vários pedidos
    List<Pedido> pedidos = new ArrayList<>();

    // ========== MÉTODOS CONSTRUTORES ==========
    public Entregador() {}

    public Entregador(TipoVeiculo veiculo, StatusEntregador status) {
        this.veiculo = veiculo;
        this.status = status;
    }

    public Entregador(Integer id, String nome, String cpf, String telefone, TipoVeiculo veiculo, StatusEntregador status) {
        super(id, nome, cpf, telefone);
        this.veiculo = veiculo;
        this.status = status;
    }
    //===========================================

    // ========================= GETTERS & SETTERS =========================
    public TipoVeiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(TipoVeiculo veiculo) {
        this.veiculo = veiculo;
    }

    public StatusEntregador getStatus() {
        return status;
    }

    public void setStatus(StatusEntregador status) {
        this.status = status;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // ============================= ADICIONAR E REMOVER DA LISTA =============================
    public void addPedidos(Pedido pedido){
        pedidos.add(pedido);
    }

    public void removePedidos(Pedido pedido){
        pedidos.remove(pedido);
    }
}
