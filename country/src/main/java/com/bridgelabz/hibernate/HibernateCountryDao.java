package com.bridgelabz.hibernate;

import java.util.Collection;

import com.bridgelabz.hibernate.CountryDao;
import com.bridgelabz.model.Country;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateCountryDao implements CountryDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public Country getById(int countryId) {
		return (Country) sessionFactory.getCurrentSession().get(Country.class, countryId);
	}

	@Transactional(readOnly = true)
	public Country getByName(String countryName) {
		return (Country) sessionFactory.getCurrentSession()
				.createQuery("from Country ctry " + "where ctry.name = :name").setParameter("name", countryName)
				.uniqueResult();
	}

	@Transactional(readOnly = true)
	public Collection<Country> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Country").list();
	}

	public void save(Country country) {
		sessionFactory.getCurrentSession().merge(country);
	}

	public void delete(Country country) {
		sessionFactory.getCurrentSession().delete(country);
	}

}
