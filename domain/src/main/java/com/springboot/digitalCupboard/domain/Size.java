package com.springboot.digitalCupboard.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Size implements Serializable {

    @Column(name = "size")
    private final String size;

    public Size(String size) {
        this.size = size;
    }

    protected Size() {
        this.size = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Size)) return false;
        Size size1 = (Size) o;
        return size.equals(size1.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return size;
    }

    public static String validate(String size) { // <7>
        if (!isValid(size)) {
            throw new IllegalArgumentException("Invalid size: " + size);
        }
        return size;
    }

    public static boolean isValid(String size) {
        if(size == null || size == "" || size == "undefined"){
            return false;
        }
        else{
            return true;
        }
    }
}
