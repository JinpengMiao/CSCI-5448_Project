package com.Magazine.Model;

/**
 * @author jinpeng
 * This class contains all the customer information
 */
public class Customer extends User{
	private int userID;
	private String userName;
	private String address;
	private String email;
	private String phoneNumber;
	private String password;
	private String salt;
	
    /**
     * @param userID int value user id
     * @param userName String value user name
     * @param address String value user address
     * @param email String value user email
     * @param phoneNumber String value user phone number
     * @param password String value user password
     * @param salt String value salt for the user password
     */
	public Customer(int userID, String userName, String address, String email, String phoneNumber, String password,
			String salt) {
		super(userID, userName, address, email, phoneNumber, password, salt);
		this.userID=userID;
    	this.userName=userName;
    	this.address=address;
    	this.email=email;
    	this.phoneNumber=phoneNumber;
    	this.password=password;
    	this.salt=salt;		
	}
	
	/**
	 * @return returning int value customer's id
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID setting int value customer's id
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return returning String value customer's name
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param setting String value customer's name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return returning String value customer's address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param setting String value customer's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return returning String value customer's email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param setting String value customer's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return returning String value customer's password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param setting String value customer's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return returning String value salt for customer's password 
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * @param setting String value salt for customer's password
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
