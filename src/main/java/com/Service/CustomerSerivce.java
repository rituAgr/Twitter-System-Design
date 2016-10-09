package com.Service;

import com.DAO.CustomerDAO;
import com.DAO.CustomerFollowerDAO;
import com.DAO.TweetDAO;
import com.Models.*;
import com.google.inject.Inject;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by anilkumar.r on 05/08/16.
 */
public class CustomerSerivce {

    private final static Logger logger = LoggerFactory.getLogger(CustomerSerivce.class);
    private CustomerDAO customerDAO;
    private CustomerFollowerDAO customerFollowerDAO;
    private TweetDAO tweetDAO;


    @Inject
    public CustomerSerivce(CustomerDAO customerDAO , CustomerFollowerDAO customerFollowerDAO , TweetDAO tweetDAO) {
        this.customerDAO = customerDAO;
        this.customerFollowerDAO = customerFollowerDAO;
        this.tweetDAO=tweetDAO;
    }

    public Customer getCustomer(String name)
    {
     return customerDAO.getCustomer(name);
    }

    public List<Tweets> getAllTweets(String emailId)
    {
        Customer customer = customerDAO.getCustomerFromCustomerEmailId(emailId);
        return tweetDAO.getAllTweets(customer);
    }

    public List<Customer> getCustomerDate(String name, String date)
    {
        DateTime dateTime = DateTime.parse(date);
        dateTime = dateTime.withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);

        return customerDAO.getCustomerwithDate(name, dateTime);
    }


    public CustomerFollower addFollower(AddFollowerRequest addFollowerRequest)
    {

        Customer  customerto = customerDAO.getCustomerFromCustomerEmailId(addFollowerRequest.getToCustomerEmailId());

        Customer  customerfrom = customerDAO.getCustomerFromCustomerEmailId(addFollowerRequest.getFrom_customer_name());

//            Customer fromCustomer=new Customer(addFollowerRequest.getFrom_customer_name(),DateTime.now(),DateTime.now(),true , "abc@gmail.com");
//            Customer customer=new Customer(addFollowerRequest.getToCustomerEmailId(),DateTime.now(),DateTime.now(),true , "abc@gmail.com");
        return customerFollowerDAO.persist(new CustomerFollower(customerfrom, customerto,"def",DateTime.now(),DateTime.now(),true, addFollowerRequest.getPhotoId()));
    }

    public void createUser(CreateUserModel createUserModel)
    {
        Customer customer=new Customer(createUserModel.getCustomername(),DateTime.now(),DateTime.now(),true , createUserModel.getCustomerEmailId());
        customerDAO.persist(customer);
//        customerFollowerDAO.persist(new CustomerFollower(customer,"def",DateTime.now(),DateTime.now(),true,1));
    }

    public List<Customer> getAllFollower(String emailId)
    {
        Customer customer  =   customerDAO.getCustomerFromCustomerEmailId(emailId);
        System.out.println("value of customer: " + customer.getEmailId());
        //List<CustomerFollower>  customerFollowerList = customerFollowerDAO.getCustomerFollowerListFromCustomerId(customer);
        List<Customer>  customerFollowerList = customerFollowerDAO.getCustomerFollowerListFromCustomerId(customer);
        return  customerFollowerList;

    }

    public Tweets tweetUpdate(TweetUpdateModel tweetUpdateModel )
    {
        Customer customer = customerDAO.getCustomerFromCustomerEmailId(tweetUpdateModel.getCustomerEmailId());
        return tweetDAO.persist(new Tweets(customer,tweetUpdateModel.getTweet(), DateTime.now()));
    }
}
