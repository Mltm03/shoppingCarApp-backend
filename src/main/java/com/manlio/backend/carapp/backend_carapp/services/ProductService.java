package com.manlio.backend.carapp.backend_carapp.services;
import java.util.List;
import com.manlio.backend.carapp.backend_carapp.models.entities.Product;

//clase que unicamente es declarativa , una interface/contrato que posteriormente se implementa


public interface ProductService {

    List<Product> findAll();
    Product save(Product product);
    Product update(Long id, Product product);

}
