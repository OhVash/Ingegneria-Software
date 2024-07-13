package it.unipr.informatica.aspects;

import java.io.Serializable;

public class MyReloadable implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;

    public MyReloadable() {
        this.message = "Hello, I am reloadable!";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
