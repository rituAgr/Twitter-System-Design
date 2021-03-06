package com;

import com.Auth.GreetingAuthenticator;
import com.Auth.User;
import com.Models.Customer;
import com.Models.CustomerFollower;
import com.Models.Tweets;
import com.Util.GuiceInjector;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yammer.metrics.ConsoleReporter;
import com.yammer.metrics.JmxReporter;
import com.yammer.metrics.MetricRegistry;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import resources.user;
import resources.TwitterResource;
import resources.CustomerResource;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ritu on 05/08/16.
 */
public class MainApplication extends Application<AppConfiguration> {

    private static final Logger logger= LoggerFactory.getLogger(MainApplication.class);
    private final HibernateBundle<AppConfiguration> crowdFireApp = new HibernateBundle<AppConfiguration>(Customer.class, CustomerFollower.class, Tweets.class) {

        @Override
        public DataSourceFactory getDataSourceFactory(AppConfiguration appConfiguration) {
            return appConfiguration.getTwtterbase();
        }
        @Override
        protected String name() {
            return "hibernate.crowdFireApp";
        }
    };




    public static void main(String[] args) throws Exception {
        new MainApplication().run(args);

    }



    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {

        bootstrap.addBundle(crowdFireApp);

    }


    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        logger.info( " messgae :: " + configuration.getLogin());

        InjectorModule injectorModule = new InjectorModule(configuration, crowdFireApp.getSessionFactory());
        Injector injector = Guice.createInjector(injectorModule);
        GuiceInjector.assignInjector(injector);

        environment.jersey().register(injector.getInstance(CustomerResource.class));
        environment.jersey().register(injector.getInstance(user.class));
        environment.jersey().register(injector.getInstance(TwitterResource.class));
    }
}

