package com.door;

public class  Duck {

    private String duckName;

    public Duck(String duckName) {
        this.duckName = duckName;
    }

    @Override
    public String toString() {
        return duckName ;
    }
}
