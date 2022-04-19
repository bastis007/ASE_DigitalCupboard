package com.springboot.digitalCupboard.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Colour implements Serializable {

    @Column(name = "colour")
    private final String colour;

    public Colour(String colour) {
        this.colour = colour;
    }

    protected Colour() {
        this.colour = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Colour)) return false;
        Colour colour1 = (Colour) o;
        return colour.equals(colour1.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour);
    }

    @Override
    public String toString() {
        return  colour;
    }

    public static String validate(String colour) { // <7>
        if (!isValid(colour)) {
            throw new IllegalArgumentException("Invalid colour: " + colour);
        }
        return colour;
    }

    public static boolean isValid(String colour) {
        if(colour == null || colour == "" || colour == "undefined"){
            return false;
        }
        else{
            return true;
        }
    }
}
