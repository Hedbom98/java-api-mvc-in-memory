package com.booleanuk.api.products;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository(){
        this.products = new ArrayList<>(){{
            add(new Product("Harry Potter and the goblet of fire", "Book", 10));
            add(new Product("Antilop", "Chair", 59));
            add(new Product("Hobbit", "Book", 15));
        }};
    }

    public List<Product> getAll(){
        return this.products;
    }

    public Product create(Product newProduct){
        this.products.add(newProduct);
        return newProduct;
    }

    public Product getProductById(int id){
        Product product = null;
        for(Product aProduct : this.products){
            if(id == aProduct.getId()){
                product = aProduct;
                return product;
            }
        }
        return product;
    }

    public Product updateProductById(int id, Product productToUpdate){
        for(Product aProduct : this.products){
            if(aProduct.getId() == id){
                aProduct.setName(productToUpdate.getName());
                aProduct.setCategory(productToUpdate.getCategory());
                aProduct.setPrice(productToUpdate.getPrice());

                return aProduct;
            }
        }
        return null;
    }

    public Product deleteProductById(int id){
        for(Product aProduct : this.products){
            if(aProduct.getId() == id){
                this.products.remove(aProduct);
                return aProduct;
            }
        }
        return null;
    }
}
