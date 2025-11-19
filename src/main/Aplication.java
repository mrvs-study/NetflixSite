package main;

import java.util.Date;
import java.util.Scanner;

import entities.*;
import service.*;

public class Aplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FilmService filmService = new FilmService();
        SerieService serieService = new SerieService();
        ClientService clientService = new ClientService(filmService, serieService);
        ProductCompanyService companyService = new ProductCompanyService(filmService, serieService);
        AdminService adminService = new AdminService();

        // =============================================================
        // CADASTRO INICIAL — FILMES E SÉRIES PADRÃO
        // =============================================================

        // Filmes iniciais
        Film f1 = new Film("Vingadores", "Ação", 142, 4.5, new Date());
        Film f2 = new Film("Invocação do Mal", "Terror", 112, 4.2, new Date());
        filmService.cadastrar(f1);
        filmService.cadastrar(f2);

        // Séries iniciais
        Serie s1 = new Serie();
        s1.setTitle("Breaking Bad");
        s1.setGenre("Drama");
        s1.setSeasons(5);
        s1.setEpisodes(62);
        s1.setRating(5);
        s1.setReleaseDate(new Date());
        serieService.cadastrar(s1);

        Serie s2 = new Serie();
        s2.setTitle("Stranger Things");
        s2.setGenre("Ficção");
        s2.setSeasons(4);
        s2.setEpisodes(34);
        s2.setRating(4.6);
        s2.setReleaseDate(new Date());
        serieService.cadastrar(s2);

        // MENU PRINCIPAL
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

    // MENU CLIENTE
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

    // MENU ADMINISTRADOR
    public static void menuAdmin(Scanner sc, AdminService adminService, FilmService filmService, SerieService serieService) {

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
            System.out.println("4 - Cadastrar Série");
            System.out.println("5 - Alterar Série");
            System.out.println("6 - Remover Série");
            System.out.println("7 - Listar Filmes");
            System.out.println("8 - Listar Séries");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                Film f = criarFilme(sc);
                filmService.cadastrar(f);

            } else if (opcao == 2) {
                System.out.print("Index do filme: ");
                int idx = sc.nextInt(); sc.nextLine();
                filmService.alterar(idx, criarFilme(sc));

            } else if (opcao == 3) {
                System.out.print("Index do filme: ");
                filmService.remover(sc.nextInt()); sc.nextLine();

            } else if (opcao == 4) {
                serieService.cadastrar(criarSerie(sc));

            } else if (opcao == 5) {
                System.out.print("Index da série: ");
                int idx = sc.nextInt(); sc.nextLine();
                serieService.alterar(idx, criarSerie(sc));

            } else if (opcao == 6) {
                System.out.print("Index da série: ");
                serieService.remover(sc.nextInt()); sc.nextLine();

            } else if (opcao == 7) {
                System.out.println(filmService.listar());

            } else if (opcao == 8) {
                System.out.println(serieService.listar());

            } else if (opcao != 0) {
                System.out.println("Opção inválida!");
            }
        }
    }

    // MENU EMPRESA PRODUTORA
    public static void menuEmpresa(Scanner sc, ProductCompanyService companyService, FilmService filmService, SerieService serieService) {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n=== MENU EMPRESA PRODUTORA ===");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Alterar Filme");
            System.out.println("3 - Remover Filme");
            System.out.println("4 - Cadastrar Série");
            System.out.println("5 - Alterar Série");
            System.out.println("6 - Remover Série");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                filmService.cadastrar(criarFilme(sc));

            } else if (opcao == 2) {
                System.out.print("Index do filme: ");
                int idx = sc.nextInt(); sc.nextLine();
                filmService.alterar(idx, criarFilme(sc));

            } else if (opcao == 3) {
                System.out.print("Index do filme: ");
                filmService.remover(sc.nextInt()); sc.nextLine();

            } else if (opcao == 4) {
                serieService.cadastrar(criarSerie(sc));

            } else if (opcao == 5) {
                System.out.print("Index da série: ");
                int idx = sc.nextInt(); sc.nextLine();
                serieService.alterar(idx, criarSerie(sc));

            } else if (opcao == 6) {
                System.out.print("Index da série: ");
                serieService.remover(sc.nextInt()); sc.nextLine();

            } else if (opcao != 0) {
                System.out.println("Opção inválida!");
            }
        }
    }

    // MÉTODOS AUXILIARES
    public static Film criarFilme(Scanner sc) {

        Film f = new Film();

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

        f.setReleaseDate(new Date());
        return f;
    }

    public static Serie criarSerie(Scanner sc) {

        Serie s = new Serie();

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

        s.setReleaseDate(new Date());
        return s;
    }
}
