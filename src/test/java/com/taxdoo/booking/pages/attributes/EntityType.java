package com.taxdoo.booking.pages.attributes;

public enum EntityType {

    CORPORATION("legal"),
    HYBRID("partnership_complementary"),
    OTHER_PARTNERSHIP("partnership"),
    SOLE_PROPRIETORSHIP("natural");

    private String name;

    EntityType(String entityName) {
        this.name = entityName;
    }

    public String getName(){
        return name;
    }
}
