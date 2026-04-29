package service;

import java.util.List;

public interface Test Crud<T>{
    void cadastrar(T obj);
    void remover(T obj);
    T buscarPorId(int id);
    List<T> listar();
}
