package com.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by anilkumar.r on 05/08/16.
 */


@Entity
@Table(name = "customerFollower")
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerFollower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private int id;


    @ManyToOne(fetch = FetchType.EAGER)                                      // @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="from_customer_id", referencedColumnName = "id")
    @Cascade(CascadeType.ALL)
    private Customer from_customer;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="to_customer_id", referencedColumnName = "id")
    @Cascade(CascadeType.ALL)
    private Customer to_customer;


    @Column(name = "photo_name")
    private String photo_name;

    @Column(name = "last_visited_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastVisitedTime;

    @Column(name = "end_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endTime;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "photo_id")
    private int photoId;


    public CustomerFollower(Customer from_customer, Customer to_customer, String photo_name, DateTime lastVisitedTime, DateTime endTime, boolean isActive, int photoId) {
        this.from_customer = from_customer;
        this.to_customer = to_customer;
        this.photo_name = photo_name;
        this.lastVisitedTime = lastVisitedTime;
        this.endTime = endTime;
        this.isActive = isActive;
        this.photoId = photoId;
    }


    public CustomerFollower(Customer to_customer, String photo_name, DateTime lastVisitedTime, DateTime endTime, boolean isActive, int photoId) {
//        this.from_customer = from_customer;
        this.to_customer = to_customer;
        this.photo_name = photo_name;
        this.lastVisitedTime = lastVisitedTime;
        this.endTime = endTime;
        this.isActive = isActive;
        this.photoId = photoId;
    }

    public CustomerFollower() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getTo_customer() {
        return to_customer;
    }

    public void setTo_customer(Customer to_customer) {
        this.to_customer = to_customer;
    }

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name;
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

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    @JsonIgnore
    public Customer getFrom_customer() {
        return from_customer;
    }

    public void setFrom_customer(Customer from_customer) {
        this.from_customer = from_customer;
    }
}
