package main;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import entities.Admin;
import service.AdminService;

public class Aplication {
	
	public static void main(String[] args ) throws ParseException  {
		  AdminService service = new AdminService();

	        String senha = "admin123";
	        String nome = "Marquin";

	       
	        System.out.println(" Teste de Login ");
	        service.logarAdmin(senha, nome);

	       
	        System.out.println("\n Teste de Cadastro ");
	        Admin admin1 = new Admin(25, "Carlos", "carlos@email.com", 2, new Date());
	        Admin admin2 = new Admin(30, "Ana", "ana@email.com", 1, new Date());

	        service.cadastrar(admin1, senha, nome);
	        service.cadastrar(admin2, senha, nome);
	        System.out.println("cadastrados com sucesso!");

	       
	        System.out.println("\nTeste de Listagem");
	        List<Admin> admins = service.listar();
	        for (int i = 0; i < admins.size(); i++) {
	            Admin a = admins.get(i);
	            System.out.println(i + " - Nome: " + a.getName() + ", Email: " + a.getEmail() + ", Nivel: " + a.getNivelDeAcesso());
	        }

	       
	        System.out.println("\n Teste de Alterar Nível ");
	        service.alterarNivelDeAcesso(0, 3, senha, nome); 

	       
	        System.out.println("\n Teste de Alterar Admin ");
	        Admin adminAlterado = new Admin(26, "Carlos Silva", "carlossilva@email.com", 3, new Date());
	        service.alterar(0, adminAlterado, senha, nome);

	      
	        System.out.println("\n Teste de Remoção ");
	        service.remover(1, senha, nome); 

	       
	        System.out.println("\n Lista Final de Admins ");
	        admins = service.listar();
	        for (int i = 0; i < admins.size(); i++) {
	            Admin a = admins.get(i);
	            System.out.println(i + " - Nome: " + a.getName() + ", Email: " + a.getEmail() + ", Nivel: " + a.getNivelDeAcesso());
	        }
	    }
	}
