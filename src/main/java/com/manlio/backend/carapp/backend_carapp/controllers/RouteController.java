package com.manlio.backend.carapp.backend_carapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.manlio.backend.carapp.backend_carapp.models.entities.Route;
import com.manlio.backend.carapp.backend_carapp.services.RouteServiceImpl;

@RestController
@RequestMapping("/api/distribution-routes")
public class RouteController {

    @Autowired
    private RouteServiceImpl routeService;

    @PostMapping("/create")
    public Route createRoute(@RequestBody Route route) {
        return routeService.save(route);
    }

    @GetMapping("/list")
    public List<Route> listRoutes() {
        return routeService.findAll();
    }



}
