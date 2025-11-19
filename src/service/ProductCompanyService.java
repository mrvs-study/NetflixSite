package service;

import java.util.List;

import entities.Film;
import entities.ProductCompany;
import entities.Serie;
import repository.ProductCompanyRepository;

public class ProductCompanyService {

	private ProductCompanyRepository repository;
	private FilmService filmService;
	private SerieService serieService;


	public ProductCompanyService(FilmService filmService, SerieService serieService) {
	    this.repository = new ProductCompanyRepository();
	    this.filmService = filmService;
	    this.serieService = serieService;
	}


	private void validar(ProductCompany product) {

		validarCampo(product.getDirectorName(), " Nome do diretor ");
		validarCampo(product.getName(), " Nome do filme ");
		validarCampo(product.getPlot(), " Sinopse ");
		validarCampo(product.getCnpj(), " Cnpj ");
		validarCampo(product.getMediaType(), " Tipo de midia ");
		if (product.getReleaseDate() == null) {
		    throw new IllegalArgumentException("Data de lançamento não pode ser nula.");
		}

	}

	private void validarCampo(String valor, String nomeCampo) {
		if (valor == null || valor.isBlank()) {
			throw new IllegalArgumentException(nomeCampo + " Não pode ser vazio:");
		}
	}

	public void cadastrar(ProductCompany product) {
		
		validar(product);
		repository.cadastrar(product);
		System.out.println("Produto cadastrado com sucesso!");
	}

	public void remover(int index) {
		repository.remover(index);
	}

	public void alterar(int index, ProductCompany product) {
		
		validar(product);
		repository.alterar(index, product);
	}

	public List<ProductCompany> listar() {
		return repository.listar();
	}
	
	public List<Film> listarFilmes() {
		return filmService.listar();
	}
	
	public List<Serie> listarSerie() {
		return serieService.listar();
	}

}
