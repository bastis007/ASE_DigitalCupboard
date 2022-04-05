package com.springboot.digitalCupboard.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Garment {

    @Id
    private String id;
    private String type;
    private String size;
    private String colour;

    public Garment(String id, String type, String size, String colour) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.colour = colour;
    }

    public Garment(String type, String size, String colour) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.size = size;
        this.colour = colour;
    }

    protected Garment() {}

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id='%s', type='%s', size='%s', colour='%s']",
                id, type, size, colour);
    }
}
