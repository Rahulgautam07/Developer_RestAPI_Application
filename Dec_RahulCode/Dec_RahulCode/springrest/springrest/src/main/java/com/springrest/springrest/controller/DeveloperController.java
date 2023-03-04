/*-------------------------------------Code by Rahul Gautam--------------------------------------*/

package com.springrest.springrest.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springrest.springrest.entities.Developer;
import com.springrest.springrest.entities.Team;
import com.springrest.springrest.services.DeveloperService;


@RestController
public class DeveloperController {


	@Autowired
	private DeveloperService devservice;
		
	//creating post mapping that post the developer detail in the database
	
	@PostMapping("/developer")
	private String saveDeveloper(@RequestBody Team team) 
	{
		devservice.saveOrUpdate(team);
		return team.getTeamName();
		}
	
	
	/*
	 * @RequestMapping(value="/developer/{id}") public Optional<Developer>
	 * getdeveloperbyId(@PathVariable String id) { return
	 * devservice.getdeveloperbyId(Long.parseLong(id)); }
	 */
	
	//creating a get mapping that retrieves all the developers detail from the database 
	/*
	 * @GetMapping("/developer") private List<Developer> getAllDeveloper() { return
	 * devservice.getAllDeveloper(); }
	 */
	//creating a get mapping that retrieves the detail of a specific developer
	/*
	 * @GetMapping("/developer/{developerid}") private Developer
	 * getDeveloper(@PathVariable("developerid") int developerid) { return
	 * devservice.getDeveloperById(developerid); }
	 */
	//creating a delete mapping that deletes a specified developer
	/*
	 * @DeleteMapping("/developer/{developerid}") private void
	 * deleteDeveloper(@PathVariable("developerid") int developerid) {
	 * devservice.delete(developerid); }
	 */
	
	
	//creating put mapping that updates the developer detail 
	/*
	 * @PutMapping("/developer") private Developer update(@RequestBody Developer
	 * developer) { devservice.saveOrUpdate(developer); return developer; }
	 */
	
	@PostMapping ("/{teamId}/alert")
	private String sendAlert(@PathVariable int teamId)
	{
		Team team = new Team();
		team = devservice.getTeamById(teamId);
		String phoneNumber = null;
		for(Developer dev : team.getDeveloper()) {
			phoneNumber = dev.getPhoneNumber();
			System.out.println("PhoneNumebr is :"+phoneNumber);
		}
		 RestTemplate restTemplate = new RestTemplate();

		 String url = "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f ";
		 String requestJson = "{/“phone_number/”:/" +phoneNumber+ "/}";
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);

		 HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		 String answer = restTemplate.postForObject(url, entity, String.class);
		 System.out.println(answer);
		 
		return answer;
	}
	
}


