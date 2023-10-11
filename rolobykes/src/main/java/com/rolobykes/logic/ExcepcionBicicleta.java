package com.rolobykes.logic;

public class ExcepcionBicicleta extends Exception{
    public ExcepcionBicicleta() {
        super();
    }
    
    public ExcepcionBicicleta(String message) {
        super(message);
    }

    public ExcepcionBicicleta(String message, Throwable cause) {
        super(message, cause);
    }
}
