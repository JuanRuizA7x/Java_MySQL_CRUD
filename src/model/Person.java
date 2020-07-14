package model;

import java.util.Date;

/**
 * @author juan_ruiz
 *
 */
public class Person {
	
	private int personId;
	private String fullName;
	private String phoneNumber;
	private String email;
	private Date createdAt;
	
	public Person() {
	}

	/**
	 * @param fullName
	 * @param phoneNumber
	 * @param email
	 */
	public Person(String fullName, String phoneNumber, String email) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * @param personId
	 * @param fullName
	 * @param phoneNumber
	 * @param email
	 */
	public Person(int personId, String fullName, String phoneNumber, String email) {
		this.personId = personId;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * @param personId
	 * @param fullName
	 * @param phoneNumber
	 * @param email
	 * @param createdAt
	 */
	public Person(int personId, String fullName, String phoneNumber, String email, Date createdAt) {
		this.personId = personId;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.createdAt = createdAt;
	}

	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
