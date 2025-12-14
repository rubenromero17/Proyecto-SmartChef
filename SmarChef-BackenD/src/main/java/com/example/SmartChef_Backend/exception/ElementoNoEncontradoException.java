package com.example.SmartChef_Backend.exception;

public class ElementoNoEncontradoException  extends RuntimeException{

    public ElementoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}