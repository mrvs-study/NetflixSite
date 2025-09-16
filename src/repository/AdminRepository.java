package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Admin;

public class AdminRepository implements InterfaceRepository<Admin>{
	private List<Admin> list= new ArrayList<>();

	@Override
	public void cadastrar(Admin obj) {
		
		list.add(obj);
		
	}

	@Override
	public void remove(int index) {
		list.remove(index);
		
	}

	@Override
	public void update(int index, Admin obj) {
		
		list.set(index, obj);
		
	}

	@Override
	public List<Admin> listar() {
		
		return list;
	}



}


