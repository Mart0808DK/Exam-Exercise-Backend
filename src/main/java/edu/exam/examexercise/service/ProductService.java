package edu.exam.examexercise.service;

import edu.exam.examexercise.entity.Product;
import edu.exam.examexercise.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Optional<Product> updateIfExist(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return Optional.of(productRepository.save(product));
        }
        return Optional.empty();
    }

    public Optional<Product> delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        }
        return product;
    }


}
