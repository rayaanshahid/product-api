package com.example.api.productapi.Services;

import com.example.api.productapi.Models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public Product insertProduct(Product product){
        products.add(product);
        return product;
    }

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(String id) throws Exception {
        for (Product i : products) {
            if(id.equals(i.getId())) {
                return i;
            }
        }
        throw new Exception();
    }

    public Product deleteProductById(String id) throws Exception {
        for (Product i : products) {
            if(id.equals(i.getId())) {
                products.remove(i);
                return i;
            }
        }
        throw new Exception();
    }

    public Product updateProductById(String id, Product product) throws Exception {
        for (Product i : products) {
            if(id.equals(i.getId())) {
                i.setPrice(product.getPrice());
                return i;
            }
        }
        throw new Exception();
    }
}
