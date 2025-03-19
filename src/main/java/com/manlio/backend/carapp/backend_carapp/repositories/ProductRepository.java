package com.manlio.backend.carapp.backend_carapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.manlio.backend.carapp.backend_carapp.models.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{
}
