package com.rolobykes.logic;

public class ExcepcionReserva extends Exception{

    public ExcepcionReserva() {
        super();
    }
    
    public ExcepcionReserva(String message) {
        super(message);
    }

    public ExcepcionReserva(String message, Throwable cause) {
        super(message, cause);
    }

}
