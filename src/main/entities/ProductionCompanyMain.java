package main.entities;

import java.sql.Date;

import entities.ProductionCompany;

public class ProductionCompanyMain {

	public static void main(String[] args) {
		
		ProductionCompany prod = new ProductionCompany();
		ProductionCompany prod1 = new ProductionCompany(
				"Antonio Gabriel"
				,"Gabriel"
				,"Um professor de quimica vira fabricante de drogas"
				,Date.valueOf("22/02/2021")
				,"45.678.912/0001-55"
				,"Serie");
		ProductionCompany prod2 = new ProductionCompany("Everton", "Mateus Guilherme");
		

	}

}
