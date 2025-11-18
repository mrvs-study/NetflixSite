package service;

import java.util.List;

import entities.ProductCompany;
import repository.ProductCompanyRepository;

public class ProductCompanyService {

	private ProductCompanyRepository repository;

	public ProductCompanyService() {
		this.repository = new ProductCompanyRepository();
	}

	private void validar(ProductCompany product) {

		validarCampo(product.getDirectorName(), " Nome do diretor ");
		validarCampo(product.getActorName(), " Nome do ator ");
		validarCampo(product.getPlot(), " Sinopse ");
		validarCampo(product.getCnpj(), " Cnpj ");
		validarCampo(product.getMediaType(), " Tipo de midia ");

	}

	private void validarCampo(String valor, String nomeCampo) {
		if (valor == null || valor.isBlank()) {
			throw new IllegalArgumentException(nomeCampo + " Não pode ser vazio:");
		}
	}

	public void cadastrar(ProductCompany product) {
		if (product.getReleaseDate() == null) {
		    throw new IllegalArgumentException("Data de lançamento não pode ser nula.");
		}


		validar(product);
		repository.cadastrar(product);
		System.out.println("Produto cadastrado com sucesso!");
	}

	public void remover(int index) {
		repository.remover(index);
	}

	public void alterar(int index, ProductCompany product) {
		repository.alterar(index, product);
	}

	public List<ProductCompany> listar() {
		return repository.listar();
	}

}
