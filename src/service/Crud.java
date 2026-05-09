package service;

import model.entites.Restaurante;

import java.util.List;

public interface Crud<T>{
    void cadastrar(T obj);
    void remover(T obj);
    T buscarPorID(int id);
    List<T> listar();
}
