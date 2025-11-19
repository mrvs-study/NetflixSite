package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.*;
import service.*;

public class Aplication {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		FilmService filmService = new FilmService();
		SerieService serieService = new SerieService();
		ClientService clientService = new ClientService(filmService, serieService);
		ProductCompanyService companyService = new ProductCompanyService(filmService, serieService);
		AdminService adminService = new AdminService();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Film f1 = new Film("Vingadores", "Ação", 142, 4.5, sdf.parse("12/12/2012"));
		Film f2 = new Film("Invocação do Mal", "Terror", 112, 4.2, sdf.parse("04/12/2025"));
		Film f3 = new Film("Interestelar", "Ficção", 169, 4.35, sdf.parse("07/11/2014"));
		filmService.cadastrar(f1);
		filmService.cadastrar(f2);
		filmService.cadastrar(f3);

		Serie s1 = new Serie("Breaking bad ", "Drama ", 5, 62, 5, sdf.parse("20/01/2008"));
		serieService.cadastrar(s1);
		Serie s2 = new Serie("Stranger Things ", "ficção ", 4, 34, 4.6, sdf.parse("15/07/2016"));
		serieService.cadastrar(s2);
		Serie s3 = new Serie("IT Welcome to the Darry ", "terror ", 1, 4, 3.85, sdf.parse("26/11/2025"));
		serieService.cadastrar(s3);
		
		

		int opcao = -1;

		while (opcao != 0) {

			System.out.println("\n=== IDENTIFIQUE-SE ===");
			System.out.println("1 - Cliente");
			System.out.println("2 - Administrador");
			System.out.println("3 - Empresa Produtora");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");

			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 1) {
				menuCliente(sc, clientService);

			} else if (opcao == 2) {
				menuAdmin(sc, adminService, filmService, serieService);

			} else if (opcao == 3) {
				menuEmpresa(sc, companyService, filmService, serieService);

			} else if (opcao != 0) {
				System.out.println("Opção inválida!");
			}
		}

		sc.close();
	}

	public static void menuCliente(Scanner sc, ClientService clientService) {

		int opcao = -1;

		while (opcao != 0) {
			System.out.println("\n=== MENU CLIENTE ===");
			System.out.println("1 - Listar Filmes");
			System.out.println("2 - Pesquisar Filme");
			System.out.println("3 - Listar Séries");
			System.out.println("4 - Pesquisar Série");
			System.out.println("0 - Voltar");
			System.out.print("Opção: ");

			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 1) {
				System.out.println(clientService.listarFilmes());

			} else if (opcao == 2) {
				System.out.print("Título: ");
				String titulo = sc.nextLine();
				System.out.println(clientService.pesquisarFilmes(titulo));

			} else if (opcao == 3) {
				System.out.println(clientService.listarSerie());

			} else if (opcao == 4) {
				System.out.print("Título: ");
				String titulo = sc.nextLine();
				System.out.println(clientService.pesquisarSerie(titulo));

			} else if (opcao != 0) {
				System.out.println("Opção inválida!");
			}
		}
	}

	public static void menuAdmin(Scanner sc, AdminService adminService, FilmService filmService,
	        SerieService serieService) throws ParseException {

	    System.out.print("Nome do admin: ");
	    String nome = sc.nextLine();

	    System.out.print("Senha: ");
	    String senha = sc.nextLine();

	    adminService.logarAdmin(senha, nome);

	    int opcao = -1;

	    while (opcao != 0) {

	        System.out.println("\n=== MENU ADMINISTRADOR ===");
	        System.out.println("1 - Cadastrar Filme");
	        System.out.println("2 - Alterar Filme");
	        System.out.println("3 - Remover Filme");
	        System.out.println("4 - Listar Filme");
	        System.out.println("5 - Cadastrar Serie");
	        System.out.println("6 - Alterar Serie");
	        System.out.println("7- Remover Serie");
	        System.out.println("8 - Listar Séries");
	        System.out.println("9 - Cadastrar Admin");
	        System.out.println("10 - Remover Admin");
	        System.out.println("11 - Alterar Admin");
	        System.out.println("12 - Alterar Nível de Acesso");
	        System.out.println("13 - Listar Admins");
	        System.out.println("0 - Voltar");
	        System.out.print("Opção: ");

	        opcao = sc.nextInt();
	        sc.nextLine();


	        if (opcao == 1) {
	            Film f = criarFilme(sc);
	            filmService.cadastrar(f);

	        } else if (opcao == 2) {
	            System.out.print("Index do filme: ");
	            int idx = sc.nextInt();
	            sc.nextLine();
	            filmService.alterar(idx, criarFilme(sc));

	        } else if (opcao == 3) {
	            System.out.print("Index do filme: ");
	            filmService.remover(sc.nextInt());
	            sc.nextLine();

	        } 
	        else if (opcao == 4) {
	            System.out.println(filmService.listar());

	        } else if (opcao == 5) {
	            serieService.cadastrar(criarSerie(sc));

	        } else if (opcao == 6) {
	            System.out.print("Index da série: ");
	            int idx = sc.nextInt();
	            sc.nextLine();
	            serieService.alterar(idx, criarSerie(sc));

	        } else if (opcao == 7) {
	            System.out.print("Index da série: ");
	            serieService.remover(sc.nextInt());
	            sc.nextLine();

	        } else if (opcao == 8) {
	            System.out.println(serieService.listar());

	        } else if (opcao == 9) {
	            System.out.print("Nome do admin autorizador: ");
	            String nomeOp = sc.nextLine();

	            System.out.print("Senha: ");
	            String senhaOp = sc.nextLine();

	            Admin novo = criarAdmin(sc);
	            adminService.cadastrar(novo, senhaOp, nomeOp);
	        }
 
	          else if (opcao == 10) {
	        System.out.print("Nome do admin autorizador: ");
	        String nomeOp = sc.nextLine();

	        System.out.print("Senha: ");
	        String senhaOp = sc.nextLine();

	        System.out.print("Index do admin: ");
	        int idx = sc.nextInt();
	        sc.nextLine();

	        adminService.remover(idx, senhaOp, nomeOp);
	        }
              else if (opcao == 11) {
            	  System.out.print("Nome do admin autorizador: ");
            	    String nomeAutorizador = sc.nextLine();

            	    System.out.print("Senha do admin autorizador: ");
            	    String senhaAutorizador = sc.nextLine();
            	    
            	    System.out.print("Índice do admin a alterar: ");
            	    int indxAlt = sc.nextInt();
            	    sc.nextLine();
            	    
            	    Admin alt = criarAdmin(sc);
            	    
            	    adminService.alterar(indxAlt, alt, senhaAutorizador, nomeAutorizador);

            	    System.out.println("Operação concluída: admin alterado.");



            } else if (opcao == 12) {
	            System.out.print("Nome do admin autorizador: ");
	            String nomeOp = sc.nextLine();

	            System.out.print("Senha: ");
	            String senhaOp = sc.nextLine();

	            System.out.print("Index do admin: ");
	            int idx = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Novo nível (1-3): ");
	            int nivel = sc.nextInt();
	            sc.nextLine();

	            adminService.alterarNivelDeAcesso(idx, nivel, senhaOp, nomeOp);
	        }
              else if (opcao == 13) {
	            System.out.println(adminService.listar());

	        } else if (opcao != 0) {
	            System.out.println("Opção inválida!");
	        }
	    }
	}


	public static void menuEmpresa(Scanner sc, ProductCompanyService companyService, FilmService filmService,
			SerieService serieService) throws ParseException {

		int opcao = -1;

		while (opcao != 0) {

			System.out.println("\n=== MENU EMPRESA PRODUTORA ===");
			System.out.println("1 - Cadastrar Filme");
			System.out.println("2 - Alterar Filme");
			System.out.println("3 - Remover Filme");
			System.out.println("4 - Listar Filme");
			System.out.println("5 - Cadastrar Serie");
			System.out.println("6 - Alterar Serie");
			System.out.println("7 - Remover Serie");
			System.out.println("8 - Listar Série");
			System.out.println("0 - Voltar");
			System.out.print("Opção: ");

			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 1) {
				filmService.cadastrar(criarFilme(sc));

			} else if (opcao == 2) {
				System.out.print("Index do filme: ");
				int idx = sc.nextInt();
				sc.nextLine();
				filmService.alterar(idx, criarFilme(sc));

			} else if (opcao == 3) {
				System.out.print("Index do filme: ");
				filmService.remover(sc.nextInt());
				sc.nextLine();

			} else if (opcao == 4) {
				System.out.println(filmService.listar());
			} 
			else if (opcao == 5) {
				serieService.cadastrar(criarSerie(sc));
            } 
			else if (opcao == 6) {
				System.out.print("Index da série: ");
				int idx = sc.nextInt();
				sc.nextLine();
				serieService.alterar(idx, criarSerie(sc));
			}
			else if (opcao == 7) {
				System.out.print("Index da série: ");
				serieService.remover(sc.nextInt());
				sc.nextLine();
			}
			else if (opcao == 8) {
				System.out.println(serieService.listar());
			} 
			else if (opcao != 0) {
				System.out.println("Opção inválida!");
			}
		}
	}
	
	public static Admin criarAdmin(Scanner sc) {
	    Admin a = new Admin();

	    System.out.print("Nome: ");
	    a.setName(sc.nextLine());

	    System.out.print("Email: ");
	    a.setEmail(sc.nextLine());

	    System.out.print("Idade: ");
	    a.setAge(sc.nextInt());
	    sc.nextLine();

	    System.out.print("Nível de acesso (1-3): ");
	    int nivel = sc.nextInt();
	    sc.nextLine();
	    a.alterarAcesso(nivel);

	    a.setDataDeCadastro(new Date());
	    return a;
	}


	public static Film criarFilme(Scanner sc) throws ParseException {

		Film f = new Film();
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Título: ");
		f.setTitle(sc.nextLine());

		System.out.print("Gênero: ");
		f.setGenre(sc.nextLine());

		System.out.print("Duração em minutos: ");
		f.setDuration(sc.nextDouble());
		sc.nextLine();

		System.out.print("Nota (0-5): ");
		f.setRating(sc.nextDouble());
		sc.nextLine();
		
		System.out.println("Data de lançamento (dd/MM/yyyy): ");
		String dataDigitada = sc.nextLine();
		Date dataLancamento = sdf.parse(dataDigitada);
		f.setReleaseDate(dataLancamento);
		
		return f;
	}

	public static Serie criarSerie(Scanner sc) throws ParseException {

		Serie s = new Serie();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Título: ");
		s.setTitle(sc.nextLine());

		System.out.print("Gênero: ");
		s.setGenre(sc.nextLine());

		System.out.print("Temporadas: ");
		s.setSeasons(sc.nextInt());

		System.out.print("Episódios: ");
		s.setEpisodes(sc.nextInt());

		System.out.print("Nota (0-5): ");
		s.setRating(sc.nextDouble());
		sc.nextLine();

		System.out.println("Data de lançamento (dd/MM/yyyy): ");
		String dataDigitada = sc.nextLine();
		Date dataLancamento = sdf.parse(dataDigitada);
		s.setReleaseDate(dataLancamento);
		return s;
	}

}
