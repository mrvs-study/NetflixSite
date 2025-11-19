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
		
		if (admin.getDataDeCadastro() == null) {
			throw new IllegalArgumentException("Data de cadastro não pode ser nula.");
		}
		if (admin.getAge() <=18) {
			throw new IllegalArgumentException("Idade não pode ser menor que 18");
		}
		if (admin.getNivelDeAcesso() < 1 || admin.getNivelDeAcesso() > 3) {
			throw new IllegalArgumentException("O nivel de acesso deve estar entre 1 e 3");
		}
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

	 public void cadastrar(Admin admin, String senhaDigitada, String nomeDigitado) {
	        validarAcesso(senhaDigitada, nomeDigitado);
	        validar(admin);
	        repository.cadastrar(admin);
	        System.out.println("Administrador cadastrado!");
	    }

	    public void remover(int index, String senhaDigitada, String nomeDigitado) {
	        validarAcesso(senhaDigitada, nomeDigitado);
	        validarIndice(index);
	        repository.remover(index);
	        System.out.println("Administrador removido!");
	    }

	    public void alterar(int index, Admin admin, String senhaDigitada, String nomeDigitado) {
	        validarAcesso(senhaDigitada, nomeDigitado);
	        validarIndice(index);
	        validar(admin);
	        repository.alterar(index, admin);
	        System.out.println("Admin alterado!");
	    }

	    public void alterarNivelDeAcesso(int index, int novoNivel, String senhaDigitada, String nomeDigitado) {
	        validarAcesso(senhaDigitada, nomeDigitado);
	        validarIndice(index);

	        if (novoNivel < 1 || novoNivel > 3) {
	            throw new IllegalArgumentException("Nível deve ser entre 1 e 3.");
	        }

	        Admin admin = repository.listar().get(index);
	        admin.alterarAcesso(novoNivel, true);
	    }

	    public List<Admin> listar() {
	        return repository.listar();
	    }
	}
