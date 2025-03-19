package com.manlio.backend.carapp.backend_carapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manlio.backend.carapp.backend_carapp.models.entities.Product;
import com.manlio.backend.carapp.backend_carapp.services.ProductServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private  ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> list(){
        return productService.findAll();

    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update/{id}")
    public Product postMethodName(@PathVariable Long id , @RequestBody Product product) {
        product.setId(id); // Asegúrate de que el ID del path coincida con el del objeto para que de a fuerzas no se repita
        //debido a que no hay una actualización como tal se manipúla para que dandole el mismo id que otro producto lo sobreescriba
        Product updatedProduct = productService.update(id, product);
        return updatedProduct;

    }
    




}
