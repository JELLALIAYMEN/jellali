package com.example.gstioneleve.Exp;

public class ResourceNotFoundException extends RuntimeException {

    // Constructeur sans argument
    public ResourceNotFoundException() {
        super();
    }

    // Constructeur avec message d'erreur
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Constructeur avec message d'erreur et cause
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructeur avec cause
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
