package entities;

public class Client extends User{

	
	public Client(String name, String email, int age) {
		super(name, email, age);
	}

	@Override
	public void showInfo() {
		System.out.println("Cliente: "+ getName()+" Idade: "+getAge());
		
	}

}
