package com.springboot.digitalCupboard.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Garment {

    @Id
    private String id;
    @Embedded
    private Type type;
    @Embedded
    private Size size;
    @Embedded
    private Colour colour;

    public Garment(String id, Type type, Size size, Colour colour) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.colour = colour;
    }

    public Garment(Type type, Size size, Colour colour) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.size = size;
        this.colour = colour;
    }

    protected Garment() {}

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public Colour getColour() {
        return colour;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id='%s', type='%s', size='%s', colour='%s']",
                id, type, size, colour);
    }
}
