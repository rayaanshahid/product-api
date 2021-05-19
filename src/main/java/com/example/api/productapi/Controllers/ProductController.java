package com.example.api.productapi.Controllers;

import com.example.api.productapi.Models.Product;
import com.example.api.productapi.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    //private List<Product> products = new ArrayList<>();

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/insertproduct")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product){
       Product responseProduct = this.productService.insertProduct(product);
       //return responseProduct;
       return new ResponseEntity<>(responseProduct,HttpStatus.CREATED);
    }

    @GetMapping("/getproducts")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = this.productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        try {
            Product product = this.productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product Not Found", ex);
        }
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable String id){
        try {
            Product product = this.productService.deleteProductById(id);
            return ResponseEntity.ok(product);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product Not Found", ex);
        }
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable String id, @RequestBody Product product){
        try {
            Product responseProduct = this.productService.updateProductById(id,product);
            return ResponseEntity.ok(responseProduct);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product Not Found", ex);
        }
    }
}
