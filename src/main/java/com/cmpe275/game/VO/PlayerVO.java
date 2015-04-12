package com.cmpe275.game.VO;

public class PlayerVO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String description;
	private int addressId;
	private int sponsorId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}
}
