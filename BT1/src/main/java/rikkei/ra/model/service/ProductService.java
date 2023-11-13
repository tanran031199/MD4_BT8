package rikkei.ra.model.service;

import rikkei.ra.model.dao.ProductDAOImpl;
import rikkei.ra.model.entity.Product;

import java.util.List;

public class ProductService implements IGenericService<Product, Integer> {
    private final ProductDAOImpl productDAOImpl = new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        return productDAOImpl.findAll();
    }

    @Override
    public Boolean save(Product product) {
        return productDAOImpl.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDAOImpl.findById(id);
    }

    @Override
    public Boolean update(Product product, Integer id) {
        return productDAOImpl.update(product, id);
    }

    @Override
    public Boolean delete(Integer id) {
        return productDAOImpl.delete(id);
    }
}
