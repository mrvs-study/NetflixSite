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

	        // -------------------- Testar login --------------------
	        System.out.println("=== Teste de Login ===");
	        try {
	            service.logarAdmin(senha, nome);
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }

	        // -------------------- Testar cadastro --------------------
	        System.out.println("\n=== Teste de Cadastro ===");
	        Admin admin1 = new Admin(25, "Carlos", "carlos@email.com", 2, new Date());
	        Admin admin2 = new Admin(30, "Ana", "ana@email.com", 1, new Date());

	        try {
	            service.cadastrar(admin1, senha, nome);
	            service.cadastrar(admin2, senha, nome);
	            System.out.println("Admins cadastrados com sucesso!");
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }

	        // -------------------- Testar listagem --------------------
	        System.out.println("\n=== Teste de Listagem ===");
	        List<Admin> admins = service.listar();
	        for (int i = 0; i < admins.size(); i++) {
	            Admin a = admins.get(i);
	            System.out.println(i + " - Nome: " + a.getName() + ", Email: " + a.getEmail() + ", Nível: " + a.getNivelDeAcesso()+ a.getAge()+a.getDataDeCadastro());
	        }

	        // -------------------- Testar alterar nível de acesso --------------------
	        System.out.println("\n=== Teste de Alterar Nível ===");
	        try {
	            service.alterarNivelDeAcesso(0, 3, senha, nome); // alterar Carlos para nível 3
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }

	        // -------------------- Testar alterar dados de admin --------------------
	        System.out.println("\n=== Teste de Alterar Admin ===");
	        Admin adminAlterado = new Admin(26, "Carlos Silva", "carlossilva@email.com", 3, new Date());
	        try {
	            service.alterar(0, adminAlterado, senha, nome);
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }

	        // -------------------- Testar remoção --------------------
	        System.out.println("\n=== Teste de Remoção ===");
	        try {
	            service.remover(1, senha, nome); // remover Ana
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }

	        // -------------------- Listagem final --------------------
	        System.out.println("\n=== Lista Final de Admins ===");
	        admins = service.listar();
	        for (int i = 0; i < admins.size(); i++) {
	            Admin a = admins.get(i);
	            System.out.println(i + " - Nome: " + a.getName() + ", Email: " + a.getEmail() + ", Nível: " + a.getNivelDeAcesso());
	        }
	    }
	}
