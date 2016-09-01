package com.bridgelabz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	@GeneratedValue
	@Column(name = "CTRY_ID")
	private Integer id;

	@Column(name = "CTRY_NAME")
	private String name;

	@Column(name = "CTRY_AREA")
	private Integer area;

	@Column(name = "CTRY_POP")
	private Long population;

	@Column(name = "POP_UPD_ON")
	private Date populationLastUpdated;

	@Column(name = "CURRENCY")
	private String currency;

	public Country() {
	}

	public Country(Integer id, String name, Integer area, Long population, Date populationLastUpdated,
			String currency) {
		setId(id);
		setName(name);
		setArea(area);
		setPopulation(population);
		setPopulationLastUpdated(populationLastUpdated);
		setCurrency(currency);
	}

	public boolean isNew() {
		return id == null;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getArea() {
		return area;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulationLastUpdated(Date populationLastUpdated) {
		this.populationLastUpdated = populationLastUpdated;
	}

	public Date getPopulationLastUpdated() {
		return populationLastUpdated;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

}
