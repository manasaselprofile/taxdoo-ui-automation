package com.taxdoo.booking.pages.attributes;

public enum AddOn {

    OSS_EXPORT("OSS Export"),
    DATEV_EXPORT("DATEV Export"),
    PRO_FORMA_INVOICES("Pro Forma Invoices"),
    IOSS_EXPORT("IOSS Export"),
    VAT_SUBMISSION("Submission of VAT returns by our tax advisors");

    private String value;

    AddOn(String addOn){
        this.value = addOn;
    }

    public String getValue(){
        return value;
    }
}
