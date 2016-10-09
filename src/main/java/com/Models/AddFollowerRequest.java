package com.Models;

import com.google.gson.Gson;

/**
 * Created by anilkumar.r on 06/08/16.
 */

public class AddFollowerRequest {
    private String fromCustomerEmailId;
    private String toCustomerEmailId;
    private int photoId;

    public AddFollowerRequest(String from_customer_name , String to_customer_name , int i) {
        this.fromCustomerEmailId =from_customer_name;
        this.toCustomerEmailId =to_customer_name;
        this.photoId =i;
    }

    public AddFollowerRequest() {
    }

    public String getToCustomerEmailId() {
        return toCustomerEmailId;
    }

    public String getFrom_customer_name() {
        return fromCustomerEmailId;
    }

    public void setFrom_customer_name(String from_customer_name) {
        this.fromCustomerEmailId = from_customer_name;
    }

    public void setToCustomerEmailId(String toCustomerEmailId) {
        this.toCustomerEmailId = toCustomerEmailId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getFromCustomerEmailId() {
        return fromCustomerEmailId;
    }

    public void setFromCustomerEmailId(String fromCustomerEmailId) {
        this.fromCustomerEmailId = fromCustomerEmailId;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new AddFollowerRequest("agrawal@gmail.com","hrithik@gmail.com",1)));
    }
}
