package com.rolobykes.logic;

public class ExcepcionPrestamo extends Exception{
    public ExcepcionPrestamo() {
        super();
    }
    
    public ExcepcionPrestamo(String message) {
        super(message);
    }

    public ExcepcionPrestamo(String message, Throwable cause) {
        super(message, cause);
    }

    
}
