package com.geeth.modules.module1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	

	@Column
	String someVal;
	
	@Column
	String someVal2;

	public Model1(String someVal, String someVal2) {
		this.someVal = someVal;
		this.someVal2 = someVal2;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the someVal
	 */
	public String getSomeVal() {
		return someVal;
	}

	/**
	 * @param someVal
	 *            the someVal to set
	 */
	public void setSomeVal(String someVal) {
		this.someVal = someVal;
	}

	/**
	 * @return the someVal2
	 */
	public String getSomeVal2() {
		return someVal2;
	}

	/**
	 * @param someVal2
	 *            the someVal2 to set
	 */
	public void setSomeVal2(String someVal2) {
		this.someVal2 = someVal2;
	}

}
