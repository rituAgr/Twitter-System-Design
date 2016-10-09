package com;

import com.DAO.CustomerDAO;
import com.DAO.CustomerFollowerDAO;
import com.DAO.TweetDAO;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.hibernate.SessionFactory;

/**
 * Created by anilkumar.r on 05/08/16.
 */
public class InjectorModule implements Module {

    private AppConfiguration configuration;
    private SessionFactory excaliburSessionFactory;

    public InjectorModule(AppConfiguration configuration, SessionFactory excaliburSessionFactory) {
        this.configuration = configuration;
        this.excaliburSessionFactory = excaliburSessionFactory;
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(AppConfiguration.class).toInstance(configuration);
//      binder.bind(HibernateBundle.class).toInstance(excaliburBundle);
//      binder.bind(HibernateBundle.class).toInstance(flipconnectBundle);
    }



    @Provides
    public CustomerDAO getCustomerDAO()
    {
        return new CustomerDAO(excaliburSessionFactory);
    }

    @Provides
    public CustomerFollowerDAO getCustomerHistoryDAO()
    {
        return new CustomerFollowerDAO(excaliburSessionFactory);
    }

    @Provides
    public TweetDAO  getTweetDAO()
    {
        return new TweetDAO(excaliburSessionFactory);
    }
//
//    @Provides
//    public UserDAO getUserDAO()
//    {
//        return new UserDAO(narsilSessionFactory);
//    }
//
//    @Provides
//    public TeamsDAO getTeamsDAO()
//    {
//        return new TeamsDAO(narsilSessionFactory);
//    }
//
//    @Provides
//    public RolesDAO getRolesDAO()
//    {
//        return new RolesDAO(narsilSessionFactory);
//    }
//
//    @Provides
//    public UserTeamRoleDAO getUserTeamRoleDAO()
//    {
//        return new UserTeamRoleDAO(narsilSessionFactory);
//    }

}
