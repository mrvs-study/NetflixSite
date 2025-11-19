package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Serie;

public class SerieRepository implements IRepository<Serie>{
	
	  private List<Serie> list = new ArrayList<>();

	    @Override
	    public void cadastrar(Serie entity) {
	        list.add(entity);
	    }

	    @Override
	    public void remover(int index) {
	        list.remove(index);
	    }

	    @Override
	    public void alterar(int index, Serie entity) {
	        list.set(index, entity);
	    }

	    @Override
	    public List<Serie> listar() {
	        return list;
	    }

	}



