package com.manlio.backend.carapp.backend_carapp.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //tomar en cuenta que se suprimieron los warnings en esta clase 
    // quitar el '@SuppressWarnings("null")'

    @Override
    public void configureMessageBroker( @SuppressWarnings("null") MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Mensajes serán enviados a "/topic"
        config.setApplicationDestinationPrefixes("/app"); // Mensajes entrantes usan "/app"
    } 

    @Override
    public void registerStompEndpoints( @SuppressWarnings("null") StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").setAllowedOrigins("http://localhost:8080").withSockJS();  //.setAllowedOrigins("*").withSockJS(); esto va??
    }
}
