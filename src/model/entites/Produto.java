package model.entites;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;

    //UM PRODUTO COMPÕEM VÁRIOS PEDIDOS E PERTENCE A 1 RESTAURANTE
    private Restaurante restaurante;
    private List<ItemPedido> itens = new ArrayList<>();


    // =============== MÉTODOS CONSTRUTORES ===============
    public Produto(){}

    public Produto(Integer id, String nome, String descricao, Double preco, String categoria, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.restaurante = restaurante;
    }
    //=======================================================

    // =========================== GETTERS & SETTERS ===========================
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<ItemPedido> getItemPedidos() {
        return itens;
    }

    //============================ ADICIONAR E REMOVER DAS LISTAS ============================

    public void addItemPedido(ItemPedido itemPedido){
        itens.add(itemPedido);
    }

    public void removeItemPedido(ItemPedido itemPedido){
        itens.remove(itemPedido);
    }
}
