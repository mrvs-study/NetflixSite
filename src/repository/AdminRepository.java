package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Admin;

public class AdminRepository implements IRepository<Admin> {

	  private List<Admin> list = new ArrayList<>();

	    @Override
	    public void cadastrar(Admin entity) {
	        list.add(entity);
	    }

	    @Override
	    public void remover(int index) {
	        list.remove(index);
	    }

	    @Override
	    public void alterar(int index, Admin entity) {
	        list.set(index, entity);
	    }

	    @Override
	    public List<Admin> listar() {
	        return list;
	    }

}
