package model.entites;

import model.enums.StatusEntregador;
import model.enums.StatusPedido;

import java.util.ArrayList;
import java.util.List;

public final class Pedido {

    private Integer id;
    private StatusPedido status;
    private static final double TAXA_ENTREGA = 8.0;
    private Double subtotal;
    private Double desconto;
    private Double valorTotal;

    /*UM PEDIDO POSSUI 1 CLIENTE, RECEBE 1 ENDEREÇO, PERTENCE A 1 RESTAURANTE,
    É ENTREGUE POR 1 ENTREGADOR E COMPÕE VÁRIOS PEDISOS
     */
    private Cliente cliente;
    private Endereco endereco;
    private Restaurante restaurante;
    private Entregador entregador;
    private List<ItemPedido> itens = new ArrayList<>();


    // ========== MÉTODOS CONSTRUTORES ==========
    public Pedido(){}

    public Pedido(Integer id, StatusPedido status, Cliente cliente, Endereco endereco, Restaurante restaurante, Entregador entregador, List<ItemPedido> itens) {
        this.id = id;
        this.status = StatusPedido.AGUARDANDO_CONFIRMACAO;
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

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nCliente: " + cliente.getNome() +
                "\nRestaurante: " + restaurante.getNome() +
                "\nStatus: " + status +
                "\nTotal: R$ " + String.format("%.2f", valorTotal);
    }

    public String gerarResumo() {

        StringBuilder sb = new StringBuilder();

        sb.append("===== PEDIDO =====\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");

        for(ItemPedido item : itens){
            sb.append(item).append("\n");
        }

        sb.append("Total: ").append(valorTotal);

        return sb.toString();
    }

    //============================= ADICIONAR E REMOVER DAS LISTAS =============================

    public void adicionarItem(ItemPedido item){
        itens.add(item);
        calcularTotal();
    }

    public void removerItem(ItemPedido item){
        itens.remove(item);
    }

    //===================== REGRAS DE NEGÓCIO ======================

    public Double calcularSubtotal(){
        double soma = 0.0;

        for(ItemPedido item : itens){
            soma+= item.getPrecoUnitario()*item.getQuantidade();
        }
        return soma;
    }

    public double calcularDesconto(double subtotal){
        if(subtotal > 300) {
            return subtotal * 0.15;
        }

        else if(subtotal > 200) {
            return subtotal * 0.10;
        }

        else if(subtotal > 100) {
            return subtotal * 0.05;
        }

        return 0.0;
    }

    public double calcularTotal(){
        subtotal = calcularSubtotal();

        desconto = calcularDesconto(subtotal);

        valorTotal = subtotal - desconto + TAXA_ENTREGA;

        return valorTotal;
    }

    public boolean atribuirEntregador(Entregador entregador) {

        if(entregador.getStatus() == StatusEntregador.DISPONIVEL){

            this.entregador = entregador;

            entregador.setStatus(StatusEntregador.EM_ENTREGA);

            this.status = StatusPedido.SAIU_PARA_ENTREGA;

            return true;
        }

        return false;
    }

    public void atualizarStatus(StatusPedido novoStatus){
        this.status = novoStatus;

        if(novoStatus == StatusPedido.ENTREGUE && entregador != null){
            entregador.setStatus(StatusEntregador.DISPONIVEL);
        }
    }
}
