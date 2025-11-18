package repository;

import java.util.ArrayList;
import java.util.List;

import entities.ProductCompany;

public class ProductCompanyRepository implements IReposity<ProductCompany> {
    
    private List<ProductCompany> list = new ArrayList<>();

    @Override
    public void cadastrar(ProductCompany entity) {
        list.add(entity);
    }

    @Override
    public void remover(int index) {
        list.remove(index);
    }

    @Override
    public void alterar(int index, ProductCompany entity) {
        list.set(index, entity);
    }

    @Override
    public List<ProductCompany> listar() {
        return list;
    }



}
