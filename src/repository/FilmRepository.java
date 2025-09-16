package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Film;

public class FilmRepository implements InterfaceRepository<Film>{
	private List<Film> list= new ArrayList<>();

	@Override
	public void cadastrar(Film obj) {
		
		list.add(obj);
		
	}

	@Override
	public void remove(int index) {
		
		list.remove(index);
		
	}

	@Override
	public void update(int index, Film obj) {
		list.set(index, obj);
		
	}

	@Override
	public List<Film> listar() {
		
		return list;
	}

}
