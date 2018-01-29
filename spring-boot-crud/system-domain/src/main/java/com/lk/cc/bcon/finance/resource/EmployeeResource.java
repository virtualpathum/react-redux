package com.lk.cc.bcon.finance.resource;

public class EmployeeResource extends AbstractResource<String> {
	
	/**
	 * Instantiates a new employee resource.
	 *
	 * @param id the id
	 */
	public EmployeeResource(String id) {
		super(id);
		
	}
	
	/**
	 * Instantiates a new student resource.
	 */
	// For testing purpose only
	public EmployeeResource(){
		super(null);
	}

	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;


	/** The age. */
	private Integer age;

	
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
