package io.moody.app;

import java.util.Objects;

public class Moodlet {
    private static int _id;
    private int id;
    private int value;
    private String name;

    Moodlet() {
    }

    Moodlet(String name) {
        this.name = name;
        this.id = _id++;
    }

    int getId() {
        return this.id;
    }

    void setId(int id) {
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
        return "Moodlet: " + this.id + "\n Name: " + this.name + "\n Value: " + this.value;
    }
}
