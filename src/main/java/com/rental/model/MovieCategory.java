package com.rental.model;

public enum MovieCategory {
    REGULAR("regular"),
    NEW_RELEASE("new"),
    CHILDREN("children");

    private final String code;

    MovieCategory(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
