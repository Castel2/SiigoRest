package com.test.rest.excepcion;

public class CrearError extends Error{

    public static final String message = "No se creo el usuario";

    public CrearError (String message, Throwable cause){
        super(message,cause);
    }

}
