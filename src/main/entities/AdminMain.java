package main.entities;

import java.sql.Date;

import entities.Admin;

public class AdminMain {

	public static void main(String[] args) {
		
		Admin admin= new Admin();
		Admin admin1= new Admin(4,Date.valueOf("02/02/2024"));
		Admin admin2= new Admin(24,"João","Joao223@Gmail.com",4,Date.valueOf("02/02/2024"));
		

	}

}
