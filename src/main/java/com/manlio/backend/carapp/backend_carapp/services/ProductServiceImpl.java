package com.manlio.backend.carapp.backend_carapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manlio.backend.carapp.backend_carapp.models.entities.Product;
import com.manlio.backend.carapp.backend_carapp.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;  //inyectamos la dependencia (el repository) con autowired

    @Override
    @Transactional(readOnly = true) //para especificar que este metodo solo hace acciones de lectura en la bd
    public List<Product> findAll() {
        return (List<Product>)repository.findAll();   //se pone al inicio (List<Product>) porque estamos haciendo e casting para devolver un list
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    @Transactional
    public Product update(Long id, Product product) {
        System.out.print("--aquiiii--"+product.getId());
        if(repository.existsById(id)){

            return repository.save(product);
        }else{
            throw new RuntimeException("El producto con ID"+ id +"no existe, favor de crearlo");
        }
    }

}
