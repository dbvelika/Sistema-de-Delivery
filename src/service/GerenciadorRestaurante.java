package service;

import model.entites.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorRestaurante {

    List<Restaurante> restaurantes = new ArrayList<>();

    public void cadastrar(Restaurante restaurante){
        restaurantes.add(restaurante);
    }

    public List<Restaurante> listar(){
        return restaurantes;
    }

    public void remover(Restaurante restaurante){
        restaurantes.remove(restaurante);
    }

    public void atualizar(int id,String nome, String endereco, Integer cnpj, Integer telefone, String categoria, int aws){
    }

    public Restaurante buscar(int id){
        for(Restaurante r : restaurantes){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }
}
