package model.entites;

public final class Endereco {

    private Integer id;
    private Integer numero;
    private String rua;
    private String cidade;
    private Integer cep;

    //Endereço possui 1 cliente e 1 restaurante
    private Cliente cliente;
    private Restaurante restaurante;

    // =============== MÉTODOS CONSTRUTORES ===============
    public Endereco(){}

    public Endereco(Integer id, Integer numero, String rua, String cidade, Integer cep) {
        this.id = id;
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
    }
    //======================================================


    // =========================== GETTERS & SETTERS ===========================
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String toString(){
        return "ID: "+ getId()
                +"\nRua: "+ getRua()
                +", Nº"+ getNumero()
                +", "+getCidade()
                +" - "+getCep();
    }

    public Endereco buscarPorID(int id) {
        for(Endereco e : cliente.getEnderecos()){
            if(e.getId() != null){
                return e;
            }
        }
        return null;
    }
}
