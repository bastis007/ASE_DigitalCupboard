package com.springboot.digitalCupboard.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Type implements Serializable {

    @Column(name = "type")
    private final String type;

    public Type(String type) {
        this.type = type;
    }

    protected Type() {
        this.type = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type)) return false;
        Type type1 = (Type) o;
        return type.equals(type1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type;
    }

    public static String validate(String type) { // <7>
        if (!isValid(type)) {
            throw new IllegalArgumentException("Invalid type: " + type);
        }
        return type;
    }

    public static boolean isValid(String type) {
        if(type == null || type == "" || type == "undefined"){
            return false;
        }
        else{
            return true;
        }
    }
}
