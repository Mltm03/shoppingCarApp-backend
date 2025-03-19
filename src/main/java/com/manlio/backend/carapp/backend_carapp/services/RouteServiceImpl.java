package com.manlio.backend.carapp.backend_carapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manlio.backend.carapp.backend_carapp.models.entities.Route;
import com.manlio.backend.carapp.backend_carapp.repositories.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;


    @Override
    @Transactional(readOnly = true) 
    public List<Route> findAll() {
      return (List<Route>)routeRepository.findAll();
    }

    @Override
    @Transactional
    public Route save(Route route) {
       return routeRepository.save(route);
    }
    
}
