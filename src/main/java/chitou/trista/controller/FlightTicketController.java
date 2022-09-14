package chitou.trista.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import chitou.trista.model.FlightTicket;
import chitou.trista.model.FlightTicketService;


@Controller
@Transactional
public class FlightTicketController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private FlightTicketService flightservice;
	
	@RequestMapping(path = "/flightTicket", method = RequestMethod.GET)
	public String processActionMain(Model m) {
		FlightTicket fly1 = new FlightTicket();
		m.addAttribute("flightTicket",fly1);
		return "Trista-FlightTicket";
	}
	
	//新增航班
	@RequestMapping(path = "/addFlightTicket", method = RequestMethod.POST)
	public String processInsertAction(@ModelAttribute("flightticket") FlightTicket fly, BindingResult result, Model m) {
		flightservice.insert(fly);

		List<FlightTicket> list = (List<FlightTicket>)flightservice.selectAll();
		m.addAttribute("insertflight", list);
		return "Trista-ThanksFlight";
	}
	
	
	//修改航班
	@RequestMapping(path = "/updateFlightTicket",method = RequestMethod.POST)
	public String processUpdateAction(@RequestParam("flightID") String flightID,@RequestParam("newfare")int newfare,Model m) {
		if(flightID != null) {
		flightservice.updateOne(flightID, newfare);
	}
	  List<FlightTicket> list = (List<FlightTicket>)flightservice.selectAll();
	  m.addAttribute("updateflight", list);
	  return "/Trista-ThanksUpdate";
	}
	
	//刪除航班	
	@RequestMapping(path = "/deleteFlightTicket",method = RequestMethod.POST)
	 public String processDeleteAction(@RequestParam("flightID") String flightID,Model m) {
	  if(flightID != null) {
		  flightservice.deleteOne(flightID);
	  }
	  List<FlightTicket> list = (List<FlightTicket>)flightservice.selectAll();
	  m.addAttribute("deleteflight", list);
	  return"/Trista-ThanksDelete";
	 }
		
	//查詢航班
	@RequestMapping(path="/searchFlightTicket",method = RequestMethod.POST)
	public String processSearchAction(@RequestParam("originID")String originID,@RequestParam("destinationID")String destinationID,
									  @RequestParam("departureTime")String departureTime,@RequestParam("arrivalTime")String arrivalTime,
									  @RequestParam("classID")String classID,Model m) {
		if(originID != null && destinationID != null && departureTime != null && arrivalTime != null && classID != null ) {
			flightservice.queryFlightId(originID,destinationID,departureTime,arrivalTime,Integer.parseInt(classID));
		}
		  FlightTicket list = flightservice.queryFlightId(originID,destinationID,departureTime,arrivalTime,Integer.parseInt(classID));
		  m.addAttribute("searchflight", list);
		  return"/Trista-ThanksRead";
		 }
	}

