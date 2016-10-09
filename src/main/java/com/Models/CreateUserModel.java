package com.Models;

import com.google.gson.Gson;

/**
 * Created by anilkumar.r on 06/08/16.
 */

public class CreateUserModel {
    private String customername;
    private String customerEmailId;

    public CreateUserModel() {
    }

    public CreateUserModel(String customername, String customerEmailId) {
        this.customername = customername;
        this.customerEmailId = customerEmailId;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new CreateUserModel("Meenakshi", "meenakshi@gmail.com")));
    }
}
