package com.onlineshop.multistrat.entities;

public enum Category {

    HOODIE("hoodie"), BLOUSE("blouse"), PANTS("pants");

    private final String value;

    Category(String value) {
        this.value = value;
    }
}
