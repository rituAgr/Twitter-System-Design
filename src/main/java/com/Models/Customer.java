package com.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by anilkumar.r on 05/08/16.
 */
@Entity@AllArgsConstructor
@Table(name = "customer")
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private int customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "last_visited_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastVisitedTime;

    @Column(name = "end_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endTime;

    @Column(name = "is_active")
    private boolean isActive;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private CustomerFollower customerHistory;


    public Customer() {
    }

    public Customer(String name, DateTime lastVisitedTime, DateTime endTime, boolean isActive , String emailId) {
        this.name = name;
        this.lastVisitedTime = lastVisitedTime;
        this.endTime = endTime;
        this.isActive = isActive;
        this.emailId=emailId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getLastVisitedTime() {
        return lastVisitedTime;
    }

    public void setLastVisitedTime(DateTime lastVisitedTime) {
        this.lastVisitedTime = lastVisitedTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
