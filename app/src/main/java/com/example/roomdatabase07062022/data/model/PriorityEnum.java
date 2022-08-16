package com.example.roomdatabase07062022.data.model;

/**
 * Created by pphat on 8/16/2022.
 */
public enum PriorityEnum {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String name;

    PriorityEnum(String s) {
        name = s;
    }

    public String toString() {
        return name;
    }
}
