package com.taxdoo.booking.pages.attributes;

public enum Salutation {

    MR("Mr"),
    MRS("Mrs");

    private String name;


    Salutation(String salutation) {
        this.name = salutation;
    }

    public String getName(){
        return name;
    }
}
