package com.example.gstioneleve.Exp;

public class IndexOutOfBoundsException extends RuntimeException {

    private static final long serialVersionUID = 234122996006267687L;

    // Constructors

    // Default constructor
    public IndexOutOfBoundsException() {
        super();
    }

    // Constructor with a custom message
    public IndexOutOfBoundsException(String s) {
        super(s);
    }

    // Constructor with a custom message and cause
    public IndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with a cause
    public IndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}

