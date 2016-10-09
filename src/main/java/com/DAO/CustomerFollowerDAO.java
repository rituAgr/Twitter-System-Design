package com.DAO;

import com.Models.Customer;
import com.Models.CustomerFollower;
import com.Util.HSession;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anilkumar.r on 05/08/16.
 */
public class CustomerFollowerDAO extends AbstractDAO<CustomerFollower> {

    private final static Logger logger = LoggerFactory.getLogger(CustomerFollowerDAO.class);
    private SessionFactory sessionFactory;

    @Inject
    public CustomerFollowerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory=sessionFactory;

    }


    @Override
    public CustomerFollower persist(CustomerFollower entity) throws HibernateException {

        HSession hSession=new HSession(sessionFactory);
        CustomerFollower customerFollower =null;

        try {
            hSession.openWithTransaction();
            customerFollower =super.persist(entity);
            hSession.commit();
        }catch (Exception e){
            logger.error("Error  Occured :: " + e.getMessage(), e);
        }finally {
            hSession.close();
        }

        return customerFollower;
    }

    public List<Customer> getCustomerFollowerListFromCustomerId(Customer customer)
    {
        HSession hSession=new HSession(sessionFactory);
        List<CustomerFollower> customerFollowerList=new ArrayList<>();
       List<Customer> followerList=new ArrayList<>();

        try {
            hSession.openWithTransaction();
            Criteria criteria = currentSession().createCriteria(CustomerFollower.class);
            customerFollowerList = criteria.add(Restrictions.eq("to_customer", customer)).list(); //HQL
            hSession.commit();
        }catch (Exception e){
            logger.error("Error  Occured :: " + e.getMessage(), e);
        }finally {
            hSession.close();
        }

//        logger.info("wfmConfigList size :: "+ wfmConfigList.size());
        for(CustomerFollower cus:customerFollowerList)
            followerList.add(cus.getFrom_customer());
        return followerList;
        //return customerFollowerList;
    }
}
