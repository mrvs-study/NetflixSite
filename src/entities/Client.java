package entities;

public class Client extends Usuario{

	private String cpf;
	private String sexuality;
	
	
	public Client() {
	}

	public Client(int age, String name, String email, String cpf, String sexuality) {
		super(age, name, email);
		this.cpf = cpf;
		this.sexuality = sexuality;
	}


	public Client(String cpf, String sexuality) {
		this.cpf = cpf;
		this.sexuality = sexuality;
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

	@Override
	public void logar() {
		System.out.println("Seu login foi um sucesso!! ");
	}

	

}
