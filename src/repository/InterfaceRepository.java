package repository;

import java.util.List;

public interface InterfaceRepository<T> {
	
	public void cadastrar(T obj) ;
	public void remove(int index);
	public void update(int index, T obj);
	List<T>listar();

}
