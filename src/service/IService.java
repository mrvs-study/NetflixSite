package service;

import java.util.List;

public interface IService <T> {
	
	void cadastrar(T obj);
	void remover(int index);
	void alterar(T obj,int index);
    List<T> listar();

}
