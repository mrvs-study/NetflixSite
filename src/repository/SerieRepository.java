package repository;

import java.util.ArrayList;
import java.util.List;

import entities.Series;

public class SerieRepository implements InterfaceRepository<Series> {
	private List<Series> list= new ArrayList<>();

	@Override
	public void cadastrar(Series obj) {
		
		list.add(obj);
		
	}

	@Override
	public void remove(int index) {
		
		list.remove(index);
		
	}

	@Override
	public void update(int index, Series obj) {
		
		list.set(index, obj);
		
	}

	@Override
	public List<Series> listar() {
		
		return list;
	}
	
	

}
