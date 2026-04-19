package service;

import model.entites.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorRestaurante {

    private Integer proximoId = 1;
    List<Restaurante> restaurantes = new ArrayList<>();

    public void cadastrar(Restaurante restaurante){
        restaurante.setId(proximoId);
        proximoId++;
        restaurantes.add(restaurante);
    }

    public List<Restaurante> listar(){
        return restaurantes;
    }

    public void remover(Restaurante restaurante){
        restaurantes.remove(restaurante);
    }


    public Restaurante buscarPorID(int id){
        for(Restaurante r : restaurantes){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }
}
