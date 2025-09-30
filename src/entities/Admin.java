package entities;

import java.sql.Date;

public class Admin {

	private int age;
	private String name;
	private String email;
	private int nivelDeAcesso;
	private Date dataDeCadastro;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNivelDeAcesso() {
		return nivelDeAcesso;
	}

	public void setNivelDeAcesso(int nivelDeAcesso) {
		this.nivelDeAcesso = nivelDeAcesso;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

}
