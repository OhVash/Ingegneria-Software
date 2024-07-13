package it.unipr.informatica.aspects;

import java.io.Serializable;

class MySerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String value;

    public MySerializableObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
