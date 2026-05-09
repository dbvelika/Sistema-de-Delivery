package service;

import model.entites.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorRestaurante implements Crud<Restaurante> {

    private Integer proximoId = 1;
    private List<Restaurante> restaurantes = new ArrayList<>();

    @Override
    public void cadastrar(Restaurante restaurante){
        restaurante.setId(proximoId);
        proximoId++;
        restaurantes.add(restaurante);
    }

    public List<Restaurante> listar(){
        return restaurantes;
    }

    @Override
    public void remover(Restaurante restaurante){
        restaurantes.remove(restaurante);
    }

    @Override
    public Restaurante buscarPorID(int id){
        for(Restaurante r : restaurantes){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }
}
