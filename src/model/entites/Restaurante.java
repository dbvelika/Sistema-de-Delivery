package model.entites;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private Integer id;
    private String nome;
    private String endereco;
    private String cnpj;
    private String telefone;
    private String categoria;


    //Um restaurante possui vários produtos e vários pedidos
    private List<Produto> produtos = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    //======================================================

    // =============== MÉTODOS CONSTRUTORES ===============
    public Restaurante(){}

    public Restaurante(Integer id, String nome, String endereco, String cnpj, String telefone, String categoria) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.categoria = categoria;
    }


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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    //===========================================================================

    public String toString(){
        return "ID: "+ id
                +" \nRestaurante: " + nome
                + " - Categoria: " + categoria
                +"\nEndereço: " + endereco
                +"\nCNPJ: " + cnpj
                + "\nTelefone: " + telefone;
    }

    //============ ADICIONAR E REMOVER DAS LISTAS ============
    public void addProdutos(Produto produto){
        produtos.add(produto);
    }

    public void removeProdutos(Produto produto){
        produtos.remove(produto);
    }

    public void addPedidos(Pedido pedido){
        pedidos.add(pedido);
    }

    public void removePedidos(Pedido pedido){
        pedidos.remove(pedido);
    }
}
