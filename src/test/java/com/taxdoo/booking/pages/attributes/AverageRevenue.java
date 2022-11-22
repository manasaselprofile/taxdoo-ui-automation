package com.taxdoo.booking.pages.attributes;

public enum AverageRevenue {

    AVERAGE_GROSS_1000("average-gross-1000"),
    AVERAGE_GROSS_10000("average-gross-10000"),
    AVERAGE_GROSS_25000("average-gross-25000"),
    AVERAGE_GROSS_50000("average-gross-50000"),
    AVERAGE_GROSS_100000("average-gross-100000"),
    AVERAGE_GROSS_200000("average-gross-200000");

    private String value;

    AverageRevenue(String revenue){
        this.value = revenue;
    }

    public String getValue(){
        return value;
    }
}
