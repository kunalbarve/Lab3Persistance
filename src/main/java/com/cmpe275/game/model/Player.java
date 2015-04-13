package com.cmpe275.game.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
    private int id;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
    
	@Column
	private String email;
    
	@Column
	private String description;
    
	@Embedded
	private Address address;
    
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sponsorId")
	private Sponsor sponsor;
    
	
	private Set<Opponent> opponents;
	
	public Set<Opponent> getOpponents() {
		return opponents;
	}
	public void setOpponents(Set<Opponent> opponents) {
		this.opponents = opponents;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Sponsor getSponsor() {
		return sponsor;
	}
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
    // constructors, setters, getters, etc.
}
