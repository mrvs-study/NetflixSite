package service;

import java.util.ArrayList;
import java.util.List;

import entities.Serie;
import repository.SerieRepository;

public class SerieService {

	private SerieRepository serieRepo;

	public SerieService() {
		this.serieRepo = new SerieRepository();
	}
	 private void validar(Serie serie) {
	        validarCampo(serie.getTitle(), "Título");
	        validarCampo(serie.getGenre(), "Gênero");
	        
	        if (serie.getSeasons() <= 0) {
	            throw new IllegalArgumentException("A série deve possuir pelo menos 1 temporada!");
	        }

	        if (serie.getEpisodes() <= 0) {
	            throw new IllegalArgumentException("A série deve possuir pelo menos 1 episódio!");
	        }

	        if (serie.getRating() < 0 || serie.getRating() > 5) {
	            throw new IllegalArgumentException("A avaliação deve estar entre 0 e 5.");
	        }

	        if (serie.getReleaseDate() == null) {
	            throw new IllegalArgumentException("A data de lançamento não pode ser nula.");
	        }
	    }

	private void validarCampo(String valor, String nomeCampo) {
		if (valor == null || valor.isBlank()) {
			throw new IllegalArgumentException(nomeCampo + " Não pode ser vazio:");
		}
	}

	public void cadastrar(Serie serie) {
		validar(serie);
		serieRepo.cadastrar(serie);
	}

	public void remover(int index) {
		serieRepo.remover(index);
	}

	public void alterar(int index, Serie serie) {
		validar(serie);
		serieRepo.alterar(index, serie);
	}

	public List<Serie> listar() {
		return serieRepo.listar();
	}

	public List<Serie> pesquisarPorTitulo(String titulo) {
		List<Serie> resultado = new ArrayList<>();
		for (Serie f : serieRepo.listar()) {
			if (f.getTitle().toLowerCase().contains(titulo.toLowerCase())) {
				resultado.add(f);
			}
		}
		return resultado;
	}

}