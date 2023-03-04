/*-------------------------------------Code by Rahul Gautam--------------------------------------*/

package com.springrest.springrest.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Getter @Setter
@Table
public class Developer {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (updatable = false)
	private int developerid;
	
	@Column 
	private String name;
	
	@Column (updatable = false)
	private String phoneNumber;
	
	
	  @ManyToOne
	  private Team team;
	  
	  public Team getTeam() 
	  { return team; }
	  
	  public void setTeam(Team team) 
	  { this.team = team; }
	 
		


	public int getDeveloperid() {
		return developerid;
	}

	public void setDeveloperid(int developerid) {
		this.developerid = developerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
