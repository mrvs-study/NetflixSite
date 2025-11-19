package service;

import java.util.ArrayList;
import java.util.List;

import entities.Film;
import repository.FilmRepository;

public class FilmService {

	private FilmRepository filmRepo;

	public FilmService() {
		this.filmRepo = new FilmRepository();
	}

	private void validar(Film film) {
		validarCampo(film.getGenre(), "Genero");
		validarCampo(film.getTitle(), "Titulo");
		
		if (film.getDuration() < 90) {
			throw new IllegalArgumentException("O horario do filme não pode ser menor que 1:30 H !");
		}
		if (film.getRating() < 0 || film.getRating() > 5) {
			throw new IllegalArgumentException("A avaliação deve estar entre 0 e 5");
		}
		if (film.getReleaseDate() == null) {
			throw new IllegalArgumentException("O campo não pode estar vazio! ");
		}

	}

	private void validarCampo(String valor, String nomeCampo) {
		if (valor == null || valor.isBlank()) {
			throw new IllegalArgumentException(nomeCampo + " Não pode ser vazio:");
		}
	}

	public void cadastrar(Film product) {
	
		validar(product);

		filmRepo.cadastrar(product);
	}

	public void remover(int index) {
		filmRepo.remover(index);
	}

	public void alterar(int index, Film product) {

		validar(product);

		filmRepo.alterar(index, product);
	}

	public List<Film> listar() {
		return filmRepo.listar();
	}

	public List<Film> pesquisarPorTitulo(String titulo) {
		List<Film> resultado = new ArrayList<>();
		for (Film f : filmRepo.listar()) {
			if (f.getTitle().toLowerCase().contains(titulo.toLowerCase())) {
				resultado.add(f);
			}
		}
		return resultado;
	}
}
