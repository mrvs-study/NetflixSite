package entities;

public class Client{

	
	private String name;
	private String email;
	private int age;
	private String cpf;
	private String sexuality;
	
	
	public Client() {
	}
	
	
	public Client(String name, String email, int age, String cpf, String sexuality) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.cpf = cpf;
		this.sexuality = sexuality;
	}
	


	public Client(String name, String email) {
		this.name = name;
		this.email = email;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexuality() {
		return sexuality;
	}

	public void setSexuality(String sexuality) {
		this.sexuality = sexuality;
	}

	

}
