package com.DAO;

import com.Models.Customer;
import com.Models.CustomerFollower;
import com.Models.Tweets;
import com.Util.HSession;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anilkumar.r on 06/08/16.
 */
public class TweetDAO extends AbstractDAO<Tweets> {

    private final static Logger logger = LoggerFactory.getLogger(TweetDAO.class);
    private SessionFactory sessionFactory;

    @Inject
    public TweetDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory=sessionFactory;

    }


    public List<Tweets> getAllTweets(Customer customer)
    {
//        System.out.println(customerId + "check ");
        HSession hSession=new HSession(sessionFactory);
        List<Tweets> tweets=new ArrayList<>();

        try {
            hSession.openWithTransaction();
//            System.out.println(date.minusHours(48));
            Criteria criteria = currentSession().createCriteria(Tweets.class);
            tweets =  criteria.add(Restrictions.eq("customer", customer))
                      .add(Restrictions.ge("tweet_time", DateTime.now().minusHours(24))).list();

            hSession.commit();
        }catch (Exception e){
            logger.error("Error  Occured :: " + e.getMessage(), e);
        }finally {
            hSession.close();
        }

        return tweets;
    }


    @Override
    public Tweets persist(Tweets entity) throws HibernateException {

        HSession hSession=new HSession(sessionFactory);
        Tweets tweets  =null;

        try {
            hSession.openWithTransaction();
            tweets =super.persist(entity);
            hSession.commit();
        }catch (Exception e){
            logger.error("Error  Occured :: " + e.getMessage(), e);
        }finally {
            hSession.close();
        }

        return tweets;
    }
}
