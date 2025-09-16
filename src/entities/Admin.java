package entities;

public class Admin extends User {
	
	public Admin() {
		
	}

	public Admin(String name, String email, int age) {
		super(name, email, age);
	}

	@Override
	public void showInfo() {
		
		System.out.println("Admin: "+ getName());
		
	}

	
}
