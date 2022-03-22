/*package com.springboot.digitalCupboard.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class GarmentProperties {

    private final String size;
    private final String colour;

    public GarmentProperties(String size, String colour) {
        super();
        this.size = size;
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GarmentProperties that = (GarmentProperties) o;
        return Objects.equals(size, that.size) && Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, colour);
    }

    @Override
    public String toString() {
        return "GarmentProperties{" +
                "size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}*/
