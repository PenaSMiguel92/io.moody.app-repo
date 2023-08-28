package io.moody.app;

import java.util.Objects;

public class Moodlet {
    private long id;
    private int value;
    private String name;
    private long owner_id;
    
    Moodlet() {
    }

    Moodlet(String name) {
        this.name = name;
    }

    long getId() {
        return this.id;
    }

    void setId(long id) {
        this.id = id;
    }

    int getValue() {
        return this.value;
    }

    void setValue(int value) {
        this.value = value;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (this.getClass() != other.getClass())
            return false;

        Moodlet otherObj = (Moodlet) other;

        if (otherObj.id == this.id)
            return true;

        return otherObj.name == this.name && otherObj.value == this.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.value);
    }

    @Override
    public String toString() {
        return "Moodlet: [ id: " + this.id + ", Name: " + this.name + ", Value: " + this.value + " ]";
    }
}
