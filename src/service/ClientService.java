package service;

import java.util.ArrayList;
import java.util.List;

import entities.Client;
import entities.Film;
import repository.ClientRepository;
import repository.FilmRepository;

public class ClientService {

	private ClientRepository clientRepo;
	private FilmRepository filmRepo;

	public ClientService() {
		this.clientRepo = new ClientRepository();
		this.filmRepo = new FilmRepository();
	}

	public void cadastrar(Client product) {

		clientRepo.cadastrar(product);
		Client client = new Client();
		client.logar();
	}

	public void remover(int index) {
		clientRepo.remover(index);
	}

	public void alterar(int index, Client product) {
		clientRepo.alterar(index, product);
	}

	public List<Client> listar() {
		return clientRepo.listar();
	}

	public List<Film> listarFilmes() {
		return filmRepo.listar();
	}
	
	public List<Film> pesquisarFilme(String titulo){
		List<Film> resultado= new ArrayList<>();
		for (Film f : filmRepo.listar()) {
			if (f.getTitle().toLowerCase().contains(titulo.toLowerCase())){
				resultado.add(f);
			}
		}
		return resultado;
	}

}
