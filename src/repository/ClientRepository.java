package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Client;

public class ClientRepository implements IRepository<Client>{
	
	List<Client> list = new ArrayList<>();

	@Override
	public void cadastrar(Client product) {
	    
		list.add(product);
	}

	@Override
	public void remover(int index) {
		
		list.remove(index);
		
	}

	@Override
	public void alterar(int index, Client entity) {

		list.set(index, entity);
		
	}

	@Override
	public List<Client> listar() {
	
		return listar();
	}

	
	

}
