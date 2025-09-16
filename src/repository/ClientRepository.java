package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Client;

public class ClientRepository implements InterfaceRepository<Client>{
	private List<Client> list= new ArrayList<>();

	@Override
	public void cadastrar(Client obj) {
		
		list.add(obj);
		
	}

	@Override
	public void remove(int index) {
		list.remove(index);
		
	}

	@Override
	public void update(int index, Client obj) {
		
		list.set(index, obj);
		
	}

	@Override
	public List<Client> listar() {
		
		return list;
	}

}
