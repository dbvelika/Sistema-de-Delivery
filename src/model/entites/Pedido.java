package model.entites;

import model.enums.StatusPedido;

public class Pedido {

    private Integer id;
    private StatusPedido status;

    public Pedido(){}

    public Pedido(Integer id, StatusPedido status) {
        this.id = id;
        this.status = status;
    }

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
}
