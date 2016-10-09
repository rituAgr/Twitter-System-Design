package com.DAO;

import com.Models.Customer;
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
 * Created by anilkumar.r on 05/08/16.
 */
public class CustomerDAO extends AbstractDAO<Customer> {

    private final static Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
    private SessionFactory sessionFactory;

    @Inject
    public CustomerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory=sessionFactory;

    }

    public Customer getCustomer(String name)
    {
        HSession hSession=new HSession(sessionFactory);
        Customer customer=new Customer();

        try {
            hSession.openWithTransaction();
            Criteria criteria = currentSession().createCriteria(Customer.class);
            customer = (Customer) criteria.add(Restrictions.eq("name", name)).uniqueResult();
            hSession.commit();
        }catch (Exception e){
            logger.error("Error  Occured :: " + e.getMessage(), e);
        }finally {
            hSession.close();
        }

//        logger.info("wfmConfigList size :: "+ wfmConfigList.size());

        return customer;
    }


    public Customer getCustomerFromCustomerEmailId(String emailId)
    {
        HSession hSession=new HSession(sessionFactory);
        Customer customer=new Customer();

        try {
            hSession.openWithTransaction();
            Criteria criteria = currentSession().createCriteria(Customer.class);
            customer = (Customer) criteria.add(Restrictions.eq("emailId", emailId)).uniqueResult();
            hSession.commit();
        }catch (Exception e){
            logger.error("Error  Occured :: " + e.getMessage(), e);
        }finally {
            hSession.close();
        }

//        logger.info("wfmConfigList size :: "+ wfmConfigList.size());

        return customer;
    }


    public List<Customer> getCustomerwithDate(String name, DateTime date)
    {
        HSession hSession=new HSession(sessionFactory);
        List<Customer> customer=new ArrayList<>();

        try {
            hSession.openWithTransaction();
            System.out.println(date.minusHours(48));
            Criteria criteria = currentSession().createCriteria(Customer.class);
            customer =  criteria.add(Restrictions.eq("name", name)).
                    add(Restrictions.ge("endTime",date.minusHours(48))).
                    list();
            hSession.commit();
        }catch (Exception e){
            logger.error("Error  Occured :: " + e.getMessage(), e);
        }finally {
            hSession.close();
        }

//        logger.info("wfmConfigList size :: "+ wfmConfigList.size());

        return customer;
    }

    @Override
    public Customer persist(Customer entity) throws HibernateException {
        return super.persist(entity);
    }
}
