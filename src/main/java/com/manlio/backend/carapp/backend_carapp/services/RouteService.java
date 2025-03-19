package com.manlio.backend.carapp.backend_carapp.services;

import java.util.List;

import com.manlio.backend.carapp.backend_carapp.models.entities.Route;

public interface RouteService {

    List<Route> findAll();
    Route save(Route route);


}
