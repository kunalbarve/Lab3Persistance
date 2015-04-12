package com.cmpe275.game.controller;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmpe275.game.model.Address;
import com.cmpe275.game.model.Player;
import com.cmpe275.game.model.Student;
import com.cmpe275.game.service.AddressService;
import com.cmpe275.game.service.PlayerService;
import com.cmpe275.game.service.StudentService;

@Controller
public class GameController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private PlayerService playerService;
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
	
	@RequestMapping(value="/player")
	public String playerPage(){
		
		return "player";
	}
	
	@RequestMapping(value="/player/search/{id}",method=RequestMethod.GET)
	public @ResponseBody String getPlayer(Model model,@PathVariable int id)
	{
		String result="";
		
		try {
			System.out.println("its here");
			Player player=playerService.getPlayer(id);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(player);
			if(player.getAddress() != null)
			{
				System.out.println(player.getAddress().getState());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}
	
	@RequestMapping(value="/player/create/",method=RequestMethod.POST)
	public @ResponseBody String createPlayer(Model model, String firstName, String lastName, String email, String description, String city,
			String state, String zipcode, String country, String street, int sponsorId){
		String result="";
		try {
				
			Address address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setCountry(country);
			address.setZipcode(zipcode);
			address.setState(state);
//			addressService.add(address);
			
		
			Player player = new Player();
			player.setDescription(description);
			player.setEmail(email);
			player.setFirstname(firstName);
			player.setLastname(lastName);
			player.setAddress(address);
			
			playerService.add(player);
			result = "Player Addes SuccessFully";
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}
	
	@RequestMapping(value="/player/update/{id}",method=RequestMethod.POST)
	public @ResponseBody String updatePlayer(Model model,@PathVariable int id)
	{
		String result="";
		
		try {
			System.out.println("its here");
			Player player=playerService.getPlayer(id);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(player);
			if(player.getAddress() != null)
			{
				System.out.println(player.getAddress().getState());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
		return result;
	}
	
	@RequestMapping(value="/player", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Student studentResult = new Student();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			studentService.add(student);
			studentResult = student;
			break;
		case "edit":
			studentService.edit(student);
			studentResult = student;
			break;
		case "delete":
			studentService.delete(student.getStudentId());
			studentResult = new Student();
			break;
		case "search":
			Student searchedStudent = studentService.getStudent(student.getStudentId());
			studentResult = searchedStudent!=null ? searchedStudent : new Student();
			break;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
}
