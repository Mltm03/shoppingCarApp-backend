package com.manlio.backend.carapp.backend_carapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manlio.backend.carapp.backend_carapp.models.entities.Route;

public interface RouteRepository extends JpaRepository<Route,Long> {
}
