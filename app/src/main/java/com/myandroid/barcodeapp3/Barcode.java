package com.myandroid.barcodeapp3;

import com.google.gson.annotations.SerializedName;

public class Barcode {
    @SerializedName("barcode") private String barcode;
    @SerializedName("food_name") private String food_name;
    @SerializedName("company_name") private String company_name;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
