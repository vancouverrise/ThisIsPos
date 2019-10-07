package com.iksmarket.thisispos;

public class ItemForReceipt {

    public String name;
    public String barcode;

     ItemForReceipt(String name, String barcode) {
        this.name = name;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }
}