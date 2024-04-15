package edu.exam.examexercise.controller;

import edu.exam.examexercise.entity.Product;
import edu.exam.examexercise.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        var products = this.productService.getAll();
        if(products != null){
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        var product = this.productService.getById(id);
        if(product != null){
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        if(product.getName() == null){
            return null;
        }
        return ResponseEntity.ok(this.productService.save(product));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable String name){
        var product = this.productService.findByName(name);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateIfExist(@PathVariable Long id, @RequestBody Product product){
        var updatedProduct = this.productService.updateIfExist(id, product);
        return updatedProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        Optional<Product> product = this.productService.delete(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
