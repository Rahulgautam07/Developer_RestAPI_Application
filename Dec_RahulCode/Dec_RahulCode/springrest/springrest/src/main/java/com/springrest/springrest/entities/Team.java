/*-------------------------------------Code by Rahul Gautam--------------------------------------*/

package com.springrest.springrest.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import lombok.Getter;
//import lombok.Setter;
 
@Entity
//@Getter @Setter
@Table
public class Team {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private int team_id;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="team_id")
	List<Developer> developer ;
	
	

	public List<Developer> getDeveloper() {
		return developer;
	}

	public void setDeveloper(List<Developer> developer) {
		this.developer = developer;
	}

	@Column(updatable = false)
	private String teamName;
	

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

		

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
