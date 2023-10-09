package com.rolobykes.logic;

public class UsuarioException extends Exception {

    public UsuarioException() {
        super();
    }
    
    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException(String message, Throwable cause) {
        super(message, cause);
    }

}