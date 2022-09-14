package tw.weber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.weber.model.Hotel;
import tw.weber.model.HotelBackService;


@Controller
public class HotelBackController {
	
	@Autowired
	private HotelBackService hotelBackService;
	
	@GetMapping(path = "/hotel")
	public String SearchAllHotel(Model model) {
		List<Hotel> result = hotelBackService.selectAll();
		
		model.addAttribute("result",result);
		
		return "weber-hotel";
	}	
	
	@GetMapping(path = "/searchHotel")
	public String SearchByKey(@RequestParam("type")String type,@RequestParam("keyword")String keyword,Model model) {
		List<Hotel> result = hotelBackService.selectByKey(type,keyword);
		
		model.addAttribute("result",result);
		
		return "weber-hotel";
	}	
	
	@GetMapping(path = "/insertHotelPage")
	public String insertHotelPage(Model m) {
		Hotel hotel = new Hotel();
		m.addAttribute("hotel",hotel);
		return "weber-newHotel";
	}
	
	@PostMapping(path = "/insertHotel")
	public String insertHotel(@ModelAttribute("hotel")Hotel hotel) {
		hotelBackService.insert(hotel);
		return "redirect:hotel";
	}
	
	@PostMapping(path = "/toUpdateHotel")
	public String updateHotelPage(@RequestParam("hotelID")int hotelID,Model m) {
		Hotel result = hotelBackService.select(hotelID);
		
		m.addAttribute("result",result);
		
		return "weber-updateHotel";
	}
	
	@DeleteMapping(path = "/deleteHotel")
	public String deleteHotel(@RequestParam("hotelID")int hotelID) {
		hotelBackService.delete(hotelID);
		return "redirect:hotel" ;
	}
	
	@PutMapping(path = "/updateHotel")
	public String updateHotel(@ModelAttribute("hotel")Hotel hotel) {
		hotelBackService.update(hotel);
		
		return "redirect:hotel";
	}
	
	
	
	@GetMapping(path = "/hotelAjax/{hotelID}")
	@ResponseBody
	public Hotel allDataForAjax(@PathVariable("hotelID")int hotelID) {
		Hotel result = hotelBackService.select(hotelID);
		return result;
		
		
	}
	
//	@GetMapping(path = "/hotelAjax")
//	@ResponseBody
//	public List<Hotel> allDataForAjax() {
//		List<Hotel> result = hotelBackService.selectAll();
//		return result;
//	}
}
