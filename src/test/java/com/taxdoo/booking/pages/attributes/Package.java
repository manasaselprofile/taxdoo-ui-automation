package com.taxdoo.booking.pages.attributes;

public enum Package {

    STARTER("starter"),
    PROFESSIONAL("professional"),
    PREMIUM("premium");

    private String id;

    Package (String id){
        this.id=id;
    }

    public String getId(){
        return id;
    }
}
