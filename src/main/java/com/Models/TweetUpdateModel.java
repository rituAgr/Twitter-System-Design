package com.Models;

import com.google.gson.Gson;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * Created by anilkumar.r on 06/08/16.
 */
public class TweetUpdateModel {

    //@Size(max=20, message = "Max length greater than 100")
    private String tweet;
//    private String customername;
    private String customerEmailId;

    public TweetUpdateModel() {
    }

    public TweetUpdateModel(String tweet, String customerEmailId) {
        this.tweet = tweet;
//        this.customername = customername;
        this.customerEmailId = customerEmailId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

//    public String getCustomername() {
//        return customername;
//    }
//
//    public void setCustomername(String customername) {
//        this.customername = customername;
//    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new TweetUpdateModel("tweet 1", "deepanshu@gmail.com")));
    }
}
