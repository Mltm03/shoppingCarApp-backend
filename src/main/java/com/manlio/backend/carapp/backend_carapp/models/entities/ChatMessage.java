package com.manlio.backend.carapp.backend_carapp.models.entities;

public class ChatMessage {
    private String content;   // Contenido del mensaje
    private String sender;    // Nombre del usuario que envía el mensaje
    private MessageType type; // Tipo de mensaje (CHAT, JOIN, LEAVE)

    // Enum para los diferentes tipos de mensajes
    public enum MessageType {
        CHAT,   // Mensaje normal de chat
        JOIN,   // Usuario se une al chat
        LEAVE   // Usuario se desconecta
    }

    // Constructor vacío necesario para la serialización JSON
    public ChatMessage() {}

    public ChatMessage(String content, String sender, MessageType type) {
        this.content = content;
        this.sender = sender;
        this.type = type;
    }

    // Getters y Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
