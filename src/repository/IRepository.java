package repository;

import java.util.List;

public interface IRepository <T>{
	
	void cadastrar(T obj);
	void remover(int index);
	void alterar(int index,T obj);
	List <T> listar();


	
}
