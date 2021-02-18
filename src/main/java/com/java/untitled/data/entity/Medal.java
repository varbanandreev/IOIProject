package com.java.untitled.data.entity;

public enum Medal {
    GOLD(1), SILVER(2), BRONZE(3), None(4);

    private final int id;
    Medal(int id) { this.id = id; }
    public int getValue() { return id; }
}
