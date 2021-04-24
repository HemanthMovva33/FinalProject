package com.corporate.classifieds.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.corporate.classifieds.entity.Employee;
import com.corporate.classifieds.entity.Offer;

@Controller
public class CorporateClassifiedsController {
	RestTemplate rt = new RestTemplate();

	@RequestMapping("/login")
	public String Login() {
		return "login";
	}

	@RequestMapping("/addOffers")
	public String addOffer() {
		return "addOffer";
	}

	@GetMapping("/viewAllOffers")
	public String viewOffers(ModelMap model) {
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Offer[]> rs = rt.getForEntity("http://localhost:8080/ViewAllOffers", Offer[].class);
		Offer offer[] = rs.getBody();
		List<Offer> offers = Arrays.asList(offer);

		model.put("Offerlist", offers);
		return "frontEnd";
	}

	@GetMapping("/viewMyProfile")
	public String viewMyProfile(ModelMap model) {
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Employee> rs = rt.getForEntity("http://localhost:9002/viewProfile/120", Employee.class);
		Employee employee = rs.getBody();

		model.put("employeeid", employee.getEmployeeid());
		model.put("firstname", employee.getFirstname());
		model.put("lastname", employee.getLastname());
		model.put("email", employee.getEmail());
		model.put("Points", employee.getPoints());
		return "MyProfile";
	}

	@GetMapping("/viewMyOffers")
	public String viewMyOffers(ModelMap model) {
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Offer[]> rs = rt.getForEntity("http://localhost:8080/allOffersOfEmployee/120", Offer[].class);
		Offer offer[] = rs.getBody();
		List<Offer> offers = Arrays.asList(offer);

		model.put("Offerlist", offers);
		return "MyOffer";
	}

	@GetMapping("/editOffers/{offerId}")
	public String editMyOffers(ModelMap model, @PathVariable int offerId) {
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Offer> rs = rt.getForEntity("http://localhost:8080/editOffer/" + offerId, Offer.class);
		Offer offer = rs.getBody();
		model.put("offerId", offer.getOfferId());
		model.put("offerTitle", offer.getOfferTitle());
		model.put("offerDescription", offer.getOfferDescription());
		return "editOffer";
	}

	@PostMapping("/editSuccess/")
	public String editOfferSuccess(@RequestParam("OfferId") int offerId, @RequestParam("offerTitle") String offerTitle,
			@RequestParam("Category") int offerCateId, @RequestParam("Description") String offerDescription) {

		ResponseEntity<Offer> rs = rt.getForEntity("http://localhost:8080/editOffer/" + offerId, Offer.class);
		Offer offer = rs.getBody();
		Offer offer1 = new Offer();
		offer1.setOfferId(offerId);
		offer1.setOfferTitle(offerTitle);
		offer1.setOfferOpenDate(offer.getOfferOpenDate());
		offer1.setOfferClosedDate(offer.getOfferClosedDate());
		offer1.setCategoryId(offerCateId);
		offer1.setOfferDescription(offerDescription);
		offer1.setOfferLikes(offer.getOfferLikes());
		offer1.setOfferLikesInTwoDays(offer.getOfferLikesInTwoDays());
		offer1.setEmployeeID(offer.getEmployeeID());
		Offer rs1 = rt.postForObject("http://localhost:8080/submitAndUpdate/", offer1, Offer.class);
		return "redirect:/viewMyOffers";

	}

	// @RequestParam("Openday") Date offerOpenDate,
	// @RequestParam("Closeday") Date offerClosedDate,
	@PostMapping("/addOffer/")
	public String addOffer(@RequestParam("offerTitle") String offerTitle, @RequestParam("Category") int offerCateId,
			@RequestParam("Description") String offerDescription) {

		Offer offer = new Offer();
		offer.setCategoryId(offerCateId);
		// offer.setOfferClosedDate(offerClosedDate);
		offer.setOfferDescription(offerDescription);
		// offer.setOfferOpenDate(offerOpenDate);
		offer.setOfferTitle(offerTitle);
		offer.setEmployeeID(120);

		Offer rs1 = rt.postForObject("http://localhost:8080/addOffer/", offer, Offer.class);
		return "redirect:/viewMyOffers";
	}

	// incrimentLikes/${offer.offerId}/${now}
	@GetMapping("/incrimentLikes/{offerId}/{date}")
	public String incrimentLikes(@PathVariable("offerId") int offerId, @PathVariable("date") Date date)
	{
		System.out.println(date);
		ResponseEntity<Offer> rs = rt.getForEntity("http://localhost:8080/getOfferDetails/" + offerId, Offer.class);
		System.out.println(date);
		Offer offer = rs.getBody();
		
		Offer offer2=new Offer();
		
		offer2.setOfferId(offerId);
		offer2.setOfferLikes(offer.getOfferLikes());
		offer2.setOfferLikesInTwoDays(offer.getOfferLikesInTwoDays());
		offer2.setOfferOpenDate(offer.getOfferOpenDate());
		offer2.setOfferClosedDate(offer.getOfferClosedDate());
		offer2.setOfferEngagedDate(date);
		offer2.setEmployeeID(offer.getEmployeeID());
		offer2.setCategoryId(offer.getCategoryId());
		offer2.setOfferTitle(offer.getOfferTitle());
		Offer rs1 = rt.postForObject("http://localhost:8080/updateLikeResponse", offer2, Offer.class);
		return "redirect:/viewAllOffers";
	}

	@GetMapping("/viewOffersByCategory")
	public String viewOffersByCategory(ModelMap model, @RequestParam int Category) {
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Offer[]> rs = rt.getForEntity("http://localhost:8080/getOfferByCategory/" + Category,
				Offer[].class);
		Offer offer[] = rs.getBody();
		List<Offer> offers = Arrays.asList(offer);

		model.put("Offerlist", offers);
		return "FilterByCategory";
	}

	@GetMapping("/viewOffersByTopLikes")
	public String viewOffersByTopLikes(ModelMap model) {
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Offer[]> rs = rt.getForEntity("http://localhost:8080/getOfferByTopLikes", Offer[].class);
		Offer offer[] = rs.getBody();
		List<Offer> offers = Arrays.asList(offer);

		model.put("Offerlist", offers);
		return "FilterByTopLikes";
	}

	@GetMapping("/viewOffersByDate/{date}")
	public String viewOffersByDate(ModelMap model, @PathVariable("date") Date date) {
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Offer[]> rs = rt.getForEntity("http://localhost:8080/getOfferByPostedDate/" + date, Offer[].class);
		Offer offer[] = rs.getBody();
		List<Offer> offers = Arrays.asList(offer);

		model.put("Offerlist", offers);
		return "FilterByDate";
	}
}
