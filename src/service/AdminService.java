package service;

import java.util.List;

import entities.Admin;
import repository.AdminRepository;

public class AdminService {

	private AdminRepository repository;

	private static String SENHAMESTRA = "admin123";
	private static String ADMINNAME = "Marquin";

	public AdminService() {
		this.repository = new AdminRepository();
	}

	private void validar(Admin admin) {
		validarCampo(admin.getName(), "Nome ");
		validarCampo(admin.getEmail(), "Email ");
	}

	private void validarCampo(String valor, String nomeCampo) {
		if (valor == null || valor.isBlank()) {
			throw new IllegalArgumentException(nomeCampo + " Não pode ser vazio:");
		}

	}
	private void validarAcesso(String senhaDigitada, String nomeDigitado) {
	    if (!senhaDigitada.equals(SENHAMESTRA) || !nomeDigitado.equals(ADMINNAME)) {
	        throw new IllegalArgumentException("Nome ou senha incorretos!");
	    }
	}
	private void validarIndice(int index) {
	    if (index < 0 || index >= repository.listar().size()) {
	        throw new IllegalArgumentException("Posição inválida");
	    }
	}

	public void logarAdmin(String senhaDigitada, String nomeDigitado) {
		validarAcesso(senhaDigitada,nomeDigitado);
		Admin admin = new Admin();
		admin.logar();
	}

	public void alterarNivelDeAcesso(int index, int novoNivel, String senhaDigitada, String nomeDigitado) {

		validarAcesso(senhaDigitada,nomeDigitado);

	    if (index < 0 || index >= repository.listar().size()) {
	        throw new IllegalArgumentException("posição invalida");
	    }

	    if (novoNivel < 1 || novoNivel > 3) {
	        throw new IllegalArgumentException("O nivel de acesso deve estar entre 1 e 3");
	    }

	    Admin admin = repository.listar().get(index);
	    admin.alterarAcesso(novoNivel, true);
	}


	public void cadastrar(Admin admin, String senhaDigitada, String nomeDigitado) {

		validarAcesso(senhaDigitada,nomeDigitado);

		validar(admin);

		if (admin.getDataDeCadastro() == null) {
			throw new IllegalArgumentException("Data de cadastro não pode ser nula.");
		}
		if (admin.getAge() <= 18) {
			throw new IllegalArgumentException("Idade não pode ser menor ou igual a 18");
		}
		if (admin.getNivelDeAcesso() < 1 || admin.getNivelDeAcesso() > 3) {
			throw new IllegalArgumentException("O nivel de acesso deve estar entre 1 e 3");
		}

		repository.cadastrar(admin);
	}

	public void remover(int index, String senhaDigitada, String nomeDigitado) {
		validarAcesso(senhaDigitada,nomeDigitado);
		validarIndice(index);
		repository.remover(index);
	}

	public void alterar(int index, Admin product, String senhaDigitada, String nomeDigitado) {

		validarAcesso(senhaDigitada,nomeDigitado);
		validarIndice(index);
		repository.alterar(index, product);
	}

	public List<Admin> listar() {
		return repository.listar();
	}

}
