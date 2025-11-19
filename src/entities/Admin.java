package entities;

import java.util.Date;

public class Admin extends Usuario {

	private int nivelDeAcesso;
	private Date dataDeCadastro;

	public Admin() {

	}

	public Admin(int age, String name, String email, int nivelDeAcesso, Date dataDeCadastro) {
		super(age, name, email);
		this.nivelDeAcesso = nivelDeAcesso;
		this.dataDeCadastro = dataDeCadastro;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public int getNivelDeAcesso() {
		return nivelDeAcesso;
	}

	public void setNivelDeAcesso(int nivelDeAcesso) {
		this.nivelDeAcesso = nivelDeAcesso;
	}

	public void alterarAcesso(int novoNivel) {
		this.nivelDeAcesso = novoNivel;
	}

	public void alterarAcesso(int novoNivel, Boolean msg) {

		this.nivelDeAcesso = novoNivel;
		if (msg) {
			System.out.println("Seu novo nivel de acesso é: " + novoNivel);
		}
	}

	@Override
	public void logar() {
		System.out.println("O administrador logou com sucesso!!");
	}

	@Override
	public String toString() {
		return ", Name " + getName() + ", Email " + getEmail()+ ", Age " + getAge() + "Admin nivelDeAcesso " + nivelDeAcesso
				+ ", dataDeCadastro " + dataDeCadastro ;

	}

}
