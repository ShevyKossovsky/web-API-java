package com.example.webapi.Controllers;

import com.example.webapi.Entities.DB;
import com.example.webapi.Entities.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {


    @GetMapping
    public List<Product> getProducts() {
        return DB.productsList;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {

        return DB.productsList.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {

        DB.productsList.add(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {

        Product existsProduct = DB.productsList.stream().filter(p -> p.getId() == id).findAny().orElse(null);
        if (existsProduct == null)
            DB.productsList.add(product);
        else {
            existsProduct.setId(product.getId());
            existsProduct.setName(product.getName());
            existsProduct.setPrice(product.getPrice());

        }

    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {

       DB.productsList.removeIf(p->p.getId()==id);
    }

}

