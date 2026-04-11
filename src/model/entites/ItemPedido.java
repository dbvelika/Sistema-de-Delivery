package model.entites;

public class ItemPedido {
    private Integer quantidade;
    private Double precoUnitario;

    private Pedido pedido;
    private Produto produto;

    public ItemPedido(){}

    // ========== MÉTODOS CONSTRUTORES ==========
    public ItemPedido(Integer quantidade, Double precoUnitario, Pedido pedido, Produto produto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.pedido = pedido;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    //============================================

    // ========================= GETTERS & SETTERS =========================
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
