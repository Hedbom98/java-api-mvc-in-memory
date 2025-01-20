package com.booleanuk.api.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductRepository theProducts;

    public ProductController(){
        this.theProducts = new ProductRepository();
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return this.theProducts.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        return this.theProducts.create(product);
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable int id){
        return this.theProducts.getProductById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProductById(@PathVariable int id, @RequestBody Product product){
        return this.theProducts.updateProductById(id, product);
    }

    @DeleteMapping("{id}")
    public Product deleteProductById(@PathVariable int id){
        return this.theProducts.deleteProductById(id);
    }
}
