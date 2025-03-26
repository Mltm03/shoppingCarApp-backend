package com.manlio.backend.carapp.backend_carapp.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.manlio.backend.carapp.backend_carapp.models.entities.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")  // Cliente envía aquí los mensajes
    @SendTo("/topic/public")  // Mensaje se reenvía a los clientes suscritos
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("📩 Mensaje recibido en el backend: " + message.getContent());
        return message;  // Devuelve el mensaje a todos los suscriptores de /topic/public
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage message) {
        message.setType(ChatMessage.MessageType.JOIN);
        return message;
    }
}