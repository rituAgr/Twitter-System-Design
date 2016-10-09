package com;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by anilkumar.r on 05/08/16.
 */
public class AppConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("twtterbase")
    private DataSourceFactory twtterbase;


    @NotNull
    private String login;
    @NotNull
    private String password;

    @JsonProperty
    public String getLogin() {
        return login;
    }
    @JsonProperty
    public String getPassword() {
        return password;
    }

    public DataSourceFactory getTwtterbase() {
        return twtterbase;
    }

    public void setTwtterbase(DataSourceFactory twtterbase) {
        this.twtterbase = twtterbase;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
