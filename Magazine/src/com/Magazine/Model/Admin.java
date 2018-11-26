package com.Magazine.Model;

/**
 * @author jinpeng
 * This class contains the admin information
 */
public class Admin extends User{

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
	public Admin(int userID, String userName, String address, String email, String phoneNumber, String password,
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
	 * @return returning String value admin password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param userID setting String value admin password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return returning String value salt for the admin password
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * @param userID setting String value salt for the admin password
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
