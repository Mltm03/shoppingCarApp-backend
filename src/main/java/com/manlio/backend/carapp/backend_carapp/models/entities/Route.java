package com.manlio.backend.carapp.backend_carapp.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="routes")
public class Route {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private double originLat;  // Latitud de origen
    private double originLng;  // Longitud de origen
    private double destinationLat;  // Latitud de destino
    private double destinationLng;  // Longitud de destino

    private double distance;  // Distancia en km
    private double duration;  // Tiempo estimado en minutos

    public Route() {
        }

    public Route( double originLat, double originLng, double destinationLat, double destinationLng,double distance, double duration) 
    {
        this.originLat = originLat;
        this.originLng = originLng;
        this.destinationLat = destinationLat;
        this.destinationLng = destinationLng;
        this.distance = distance;
        this.duration = duration;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getOriginLat() {
        return originLat;
    }
    public void setOriginLat(double originLat) {
        this.originLat = originLat;
    }
    public double getOriginLng() {
        return originLng;
    }
    public void setOriginLng(double originLng) {
        this.originLng = originLng;
    }
    public double getDestinationLat() {
        return destinationLat;
    }
    public void setDestinationLat(double destinationLat) {
        this.destinationLat = destinationLat;
    }
    public double getDestinationLng() {
        return destinationLng;
    }
    public void setDestinationLng(double destinationLng) {
        this.destinationLng = destinationLng;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

}
