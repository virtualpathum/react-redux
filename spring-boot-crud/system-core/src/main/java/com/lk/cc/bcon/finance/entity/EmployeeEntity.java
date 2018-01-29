package com.lk.cc.bcon.finance.entity;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class EmployeeEntity extends AbstractEntity{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9157969392013803110L;

	/** The id. */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;

	/** The first name. */
	@NotEmpty
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	/** The last name. */
	@NotNull
	@Column(name="last_name", nullable=false)
	private String lastName;

	/** The age. */
	@NotNull
	@Column(name="age", nullable=false)
	private Integer age;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
			return Objects.hash(this.id);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		if (obj instanceof EmployeeEntity) {
			EmployeeEntity other = (EmployeeEntity) obj;
			return Objects.equals(this.hashCode(), other.hashCode());
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		return sb.append("id = " + this.getId())
				.append(" , firstName = " + this.getFirstName())
				.append(" , lastName = " + this.getLastName())
				.append(" , age = " + this.getAge()).toString();
				
	}


}
