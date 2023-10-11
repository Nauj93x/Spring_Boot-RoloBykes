package com.rolobykes.logic;

public class ExcepcionUsuario extends Exception {

    public ExcepcionUsuario() {
        super();
    }
    
    public ExcepcionUsuario(String message) {
        super(message);
    }

    public ExcepcionUsuario(String message, Throwable cause) {
        super(message, cause);
    }

}