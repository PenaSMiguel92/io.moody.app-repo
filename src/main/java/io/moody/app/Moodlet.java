package io.moody.app;

import java.util.Objects;

public class Moodlet {
    private static long _id = 1;
    private long id;
    private int value = 0;
    private String name;
    private long owner_id;
    
    Moodlet() {
        this.id = _id++;
    }

    Moodlet(String name) {
        this.name = name;
        this.id = _id++;
    }

    long getId() {
        return this.id;
    }

    long getOwnerId() {
        return this.owner_id;
    }

    void setOwnerId(long id) {
        this.owner_id = id;
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
        return Objects.hash(this.id, this.name, this.value, this.owner_id);
    }

    @Override
    public String toString() {
        return "Moodlet: [ id: " + this.id + ", name: " + this.name + ", value: " + this.value + " ]";
    }
}
