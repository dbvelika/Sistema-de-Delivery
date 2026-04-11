package model.entites;

import model.enums.StatusEntregador;
import model.enums.TipoVeiculo;

public class Entregador extends Pessoa {
    private TipoVeiculo veiculo;
    private StatusEntregador status;


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
}
