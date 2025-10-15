package main.entities;

import java.sql.Date;

import entities.Film;

public class FilmMain {

	public static void main(String[] args) {
		
		Film film= new Film();
		Film film1= new Film("O terror da casa 8","Terror",1.30,8.8,Date.valueOf("24/02/2023"));
		Film film2=new Film("O terror da casa 8","Terror");

	}

}
