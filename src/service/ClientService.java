package service;

import java.util.List;

import entities.Client;
import entities.Film;
import entities.Serie;
import repository.ClientRepository;

public class ClientService {

	private ClientRepository clientRepo;
	private FilmService filmService;
	private SerieService serieService;

	private void validar(Client client) {
		validarCampo(client.getCpf(),"CPF");
		validarCampo(client.getName(),"Name");
		validarCampo(client.getEmail(),"Email");
		validarCampo(client.getSexuality(),"Sexuality");
		
		if (client.getAge() <=18) {
			throw new IllegalArgumentException("Você não tem a idade necessaria para realizar o cadastro! ");
		}
	}
	
	private void validarCampo(String valor, String nomeCampo) {
		if (valor == null || valor.isBlank()) {
			throw new IllegalArgumentException(nomeCampo + " Não pode ser vazio!!");
		}
	}

	public ClientService(FilmService filmService, SerieService serieService) {
	    this.clientRepo = new ClientRepository();
	    this.filmService = filmService;
	    this.serieService = serieService;
	}

	public void cadastrar(Client product) {
     	validar(product);

		clientRepo.cadastrar(product);
		Client client = new Client();
		client.logar();
	}

	public void remover(int index) {
		clientRepo.remover(index);
	}

	public void alterar(int index, Client product) {
	
		validar(product);
		clientRepo.alterar(index, product);
	}

	public List<Client> listar() {
		return clientRepo.listar();
	}

	public List<Film> listarFilmes() {
		return filmService.listar();
	}

	public List<Film> pesquisarFilmes(String titulo) {
		return filmService.pesquisarPorTitulo(titulo);
	}

	public List<Serie> listarSerie() {
		return serieService.listar();
	}

	public List<Serie> pesquisarSerie(String titulo) {
		return serieService.pesquisarPorTitulo(titulo);
	}
}
