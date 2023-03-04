/*-------------------------------------Code by Rahul Gautam--------------------------------------*/

package com.springrest.springrest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entities.Developer;
import com.springrest.springrest.entities.Team;

@Repository
public interface DeveloperRepository extends CrudRepository<Team, Integer>
{
	

}
