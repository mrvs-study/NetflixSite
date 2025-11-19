package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Film;

public class FilmRepository implements IRepository<Film> {

	  private List<Film> list = new ArrayList<>();

	    @Override
	    public void cadastrar(Film entity) {
	        list.add(entity);
	    }

	    @Override
	    public void remover(int index) {
	        list.remove(index);
	    }

	    @Override
	    public void alterar(int index, Film entity) {
	        list.set(index, entity);
	    }

	    @Override
	    public List<Film> listar() {
	        return list;
	    }
	
}
