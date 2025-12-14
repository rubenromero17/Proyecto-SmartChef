package com.example.SmartChef_Backend.exception;

public class EliminarNoExistenteException extends RuntimeException {


    public EliminarNoExistenteException(String mensaje){
        super(mensaje);
    }

}