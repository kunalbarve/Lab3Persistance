package com.cmpe275.game.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmpe275.game.model.Address;
import com.cmpe275.game.model.Opponent;
import com.cmpe275.game.model.Player;
import com.cmpe275.game.model.Sponsor;
import com.cmpe275.game.service.OpponentService;
import com.cmpe275.game.service.PlayerService;
import com.cmpe275.game.service.SponsorService;

@Controller
public class GameController {
	@Autowired
	private PlayerService playerService;
	@Autowired
	private SponsorService sponsorService;
	@Autowired
	private OpponentService opponentService;
	
	@RequestMapping(value="/player/search/{id}",method=RequestMethod.GET)
	public ResponseEntity<?>  searchPlayer(Model model,@PathVariable int id){
		String result="";
		try {
			System.out.println("its here");
			Player player=playerService.getPlayer(id);
			
			if(player!=null){
				ObjectMapper mapper=new ObjectMapper();
				result=mapper.writeValueAsString(player);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}else{
				result="Player does not exist.";
				return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		} 
	}
	
	@RequestMapping(value="/player/create/",method=RequestMethod.POST)
	public ResponseEntity<?> createPlayer(Model model, String firstName, String lastName, String email, 
			String description, String city, String state, String zipcode, 
			String country, String street, Integer sponsorId){
		
		String result="";
		if(firstName!=null && !firstName.isEmpty() && lastName!=null && !lastName.isEmpty() && email!=null && !email.isEmpty()){
			try {
				Address address = new Address();
				address.setStreet(street);
				address.setCity(city);
				address.setCountry(country);
				address.setZipcode(zipcode);
				address.setState(state);
				
				Player player = new Player();
				player.setDescription(description);
				player.setEmail(email);
				player.setFirstname(firstName);
				player.setLastname(lastName);
				player.setAddress(address);
				if(sponsorId!=null){
					Sponsor sponsor = sponsorService.getSponsor(sponsorId);
					if(sponsor!=null){
						player.setSponsor(sponsor != null ? sponsor : null);
					}
				}
					
				playerService.add(player);
				ObjectMapper mapper=new ObjectMapper();
				result=mapper.writeValueAsString(player);
				return new ResponseEntity<>(result, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
			}
		}
		else{
			result="Please enter mandatory fields.";
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/player/update/{id}",method=RequestMethod.POST)
	public ResponseEntity<?> updatePlayer(Model model, @PathVariable Integer id, String firstName, String lastName, String email, 
			String description, String city, String state, String zipcode, 
			String country, String street, Integer sponsorId){
		
		String result="";
		if(email!=null && !email.isEmpty() && id!=null){
			try {
				Player player = playerService.getPlayer(id);
				if(player!=null){
					
							if(sponsorId!=null){
								Sponsor sponsor = sponsorService.getSponsor(sponsorId);
								player.setSponsor(sponsor != null ? sponsor : null);
							}
							
							Address address = new Address();
							address.setStreet(street);
							address.setCity(city);
							address.setCountry(country);
							address.setZipcode(zipcode);
							address.setState(state);
						
							
							player.setDescription(description);
							player.setEmail(email);
							player.setFirstname(firstName);
							player.setLastname(lastName);
							player.setAddress(address);
							
							playerService.edit(player);
							ObjectMapper mapper=new ObjectMapper();
							result=mapper.writeValueAsString(player);
							return new ResponseEntity<>(result, HttpStatus.OK);
				}else{
					result="Player does not exist.";
					return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
			} 
		}else{
			result="Please provide mandatory fields.";
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/player/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePlayer(Model model,@PathVariable Integer id){
		String result="";
		if(id!=null){

			try {
				System.out.println("its here");
				Player player=playerService.getPlayer(id);
				if(player!=null){
					playerService.delete(id);
					ObjectMapper mapper=new ObjectMapper();
					result=mapper.writeValueAsString(player);
					return new ResponseEntity<>(result, HttpStatus.OK);
				}
				else{
					result="Player does not exist.";
					return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
			}
			
		}else{
			result="Please provide mandatory fields.";
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		} 
	}
	

	@RequestMapping(value="/sponsor/search/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> searchSponsor(Model model,@PathVariable Integer id){
		String result="";
		try {
			System.out.println("its here in sponsor");
			if(id!=null){
				Sponsor sponsor=sponsorService.getSponsor(id);
				if(sponsor!=null){
					ObjectMapper mapper=new ObjectMapper();
					result=mapper.writeValueAsString(sponsor);
					return new ResponseEntity<>(result, HttpStatus.OK);
				}else{
					result="Sponsor does not exist.";
					return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
				}
			}
			else{
				result="Please enter mandatory fields.";
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
		} 
	}
	
	@RequestMapping(value="/sponsor/create/",method=RequestMethod.POST)
	public ResponseEntity<?> createSponsor(Model model, String name, String email, 
			String description, String city, String state, String zipcode, 
			String country, String street){
		
		String result="";
		if(name!=null && !name.isEmpty()){
			
			try {
				
				Address address = new Address();
				address.setStreet(street);
				address.setCity(city);
				address.setCountry(country);
				address.setZipcode(zipcode);
				address.setState(state);
			
				Sponsor sponsor=new Sponsor();
				sponsor.setDescription(description);
				sponsor.setEmail(email);
				sponsor.setName(name);
				sponsor.setAddress(address);
				
				sponsorService.add(sponsor);
				ObjectMapper mapper=new ObjectMapper();
				result=mapper.writeValueAsString(sponsor);
				return new ResponseEntity<>(result, HttpStatus.OK);
					
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
			} 
		}else{
			result="Please provide mandatory fields.";
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/sponsor/update/{id}",method=RequestMethod.POST)
	public ResponseEntity<?> updateSponsor(@PathVariable int id, Model model, String name, String email, 
			String description, String city, String state, String zipcode, 
			String country, String street){
		
		String result="";
		
		if(name!=null && !name.isEmpty()){
			try {
				Sponsor sponsor = sponsorService.getSponsor(id);
				if(sponsor!=null){

					Address address = new Address();
					address.setStreet(street);
					address.setCity(city);
					address.setCountry(country);
					address.setZipcode(zipcode);
					address.setState(state);

					sponsor.setDescription(description);
					sponsor.setEmail(email);
					sponsor.setName(name);
					sponsor.setAddress(address);
					
					sponsorService.edit(sponsor);
					ObjectMapper mapper=new ObjectMapper();
					result=mapper.writeValueAsString(sponsor);
					return new ResponseEntity<>(result, HttpStatus.OK);
				}else{
					result="Sponsor does not exist.";
					return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
				}
					
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
			} 
		}else{
			result="Please provide mandatory fields.";
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/sponsor/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteSponsor(Model model,@PathVariable int id){
		String result="";
		try {
			System.out.println("its here in sponsor delete");
			Sponsor sponsor = sponsorService.getSponsor(id);
			if(sponsor != null){
				
				List<Player> listPlayers =  playerService.getPlyerList(sponsor);
				if(listPlayers.size()>0){
					result="Can not delete this sponsor.Already sponsoring at least one player.";
					return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
				}else{
					sponsorService.delete(id);
					ObjectMapper mapper=new ObjectMapper();
					result=mapper.writeValueAsString(sponsor);
					return new ResponseEntity<>(result, HttpStatus.OK);
				}
			}else{
				result="Sponsor Does not exist.";
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
		} 
	}
	
	@RequestMapping(value="/opponent/remove/{id1}/{id2}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteSponsor(Model model,@PathVariable Integer id1,@PathVariable Integer id2){
		String result="";
		if(id1 != null && id2 != null && id1 != id2){
			try {
				Player p1=playerService.getPlayer(id1);
				Player p2=playerService.getPlayer(id2);
				if(p1!=null && p2 != null){
					Opponent o=opponentService.search(id1,id2);
					if(o!=null){
						opponentService.delete(o);
						ObjectMapper mapper=new ObjectMapper();
						result=mapper.writeValueAsString(o);
						return new ResponseEntity<>(result, HttpStatus.OK);
					}else{
						result="This cobination of players are not opponent.";
						return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
					}
				}else{
					result="This combination of players are not opponents.";
					return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
				}
					
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
			} 
		}else{
			result="Please provide Valid inputs.";
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/opponent/create/{id1}/{id2}",method=RequestMethod.PUT)
	public ResponseEntity<?> createOpponent(Model model,@PathVariable Integer id1,@PathVariable Integer id2){
		
		String result="";
		if(id1 != null && id2 != null && id1 != id2){
			try {
				Player p1=playerService.getPlayer(id1);
				Player p2=playerService.getPlayer(id2);
				if(p1!=null && p2 != null){
					Opponent o=opponentService.search(id1,id2);
					if(o==null){
						o=new Opponent();
						o.setPlayer1(p1);
						o.setPlayer2(p2);
						opponentService.add(o);
						ObjectMapper mapper=new ObjectMapper();
						result=mapper.writeValueAsString(o);
						return new ResponseEntity<>(result, HttpStatus.OK);
					}else{
						result="This cobination of players already exists.";
						return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
					}
				}else{
					result="Player(/s) does not exist.";
					return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Exception Occured", HttpStatus.BAD_REQUEST);
			} 
		}else{
			result="Please provide Valid inputs.";
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
}
