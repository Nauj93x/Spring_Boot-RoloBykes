package com.rolobykes.logic;

public class ExcepcionTipoBicicleta extends Exception{
    public ExcepcionTipoBicicleta() {
        super();
    }
    
    public ExcepcionTipoBicicleta(String message) {
        super(message);
    }

    public ExcepcionTipoBicicleta(String message, Throwable cause) {
        super(message, cause);
    }

}
