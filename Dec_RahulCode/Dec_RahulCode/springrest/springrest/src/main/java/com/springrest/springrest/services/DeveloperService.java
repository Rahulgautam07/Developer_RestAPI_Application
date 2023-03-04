/*-------------------------------------Code by Rahul Gautam--------------------------------------*/

package com.springrest.springrest.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.dao.DeveloperRepository;
import com.springrest.springrest.entities.Developer;
import com.springrest.springrest.entities.Team;

@Service
public class DeveloperService {
	
	
	@Autowired
	public DeveloperRepository devRepo;
	
	/*
	 * public List<Developer> getAllDeveloper() { List <Developer> dev= new
	 * ArrayList<>(); devRepo.findAll().forEach(dev::add); return dev; }
	 */
	
	/*
	 * public void addDeveloper(Developer dev) { devRepo.save(dev); }
	 */
	
	
	//getting a specific record by using the method findById() of CrudRepository
	
	 public Team getTeamById(int teamId) 
	 { 
		 return devRepo.findById(teamId).get(); 
	 }
	 
	//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Team team) 
	{
	devRepo.save(team);
	}
	//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int developerid) 
	{
	devRepo.deleteById(developerid);
	}
	/*
	 * //updating a record public void update(Developer dev, int developerid) {
	 * devRepo.save(dev); }
	 */
	
	

}
