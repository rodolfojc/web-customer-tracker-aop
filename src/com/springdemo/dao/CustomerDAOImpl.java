package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//INJECT SESSION FACTORY
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Customer> getCustomers() {
		
		//GET CURRENT HIBERNATE SESSION
		Session currentSession = sessionFactory.getCurrentSession();
		
		//QUERY
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		
		//EXECUTE QUERY
		List<Customer> customers = theQuery.getResultList();
						
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//GET CURRENT HIBERNATE SESSION
		Session currentSession = sessionFactory.getCurrentSession();
		
		//SAVEORUPDATE THE CUSTOMER
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theID) {
		
		//GET CURRENT HIBERNATE SESSION
		Session currentSession = sessionFactory.getCurrentSession();
		
		//GET CUSTOMER
		Customer tempCustomer = currentSession.get(Customer.class, theID);
		
		return tempCustomer;
	}


	@Override
	public void deleteCustomer(int theID) {
		
		//GET CURRENT HIBERNATE SESSION
		Session currentSession = sessionFactory.getCurrentSession();
		
		//DELETE CUSTOMER - OBJECT
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theID);
		
		theQuery.executeUpdate();
		
	}

}
