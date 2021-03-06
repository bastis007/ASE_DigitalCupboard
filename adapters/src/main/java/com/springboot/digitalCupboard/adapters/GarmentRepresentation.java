package com.springboot.digitalCupboard.adapters;

import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = {})
public class GarmentRepresentation {

    private String id;
    private final String type;
    private final String size;
    private final String colour;

    public GarmentRepresentation(String id, String type, String size, String colour) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.colour = colour;
    }

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

    public void setId(String id) {
        this.id = id;
    }
}
