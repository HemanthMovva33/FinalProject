package com.corporate.classifieds.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corporate.classifieds.entity.Offer;
import com.corporate.classifieds.repository.OfferRepository;

@Service
public class OfferService {
	@Autowired
	private OfferRepository offerRepository;

	public Offer getDetails(int id) {

		return offerRepository.findByOfferId(id);

	}

	public List<Offer> getDetailsByCategory(int id) {

		return offerRepository.findByCategoryId(id);
	}

	public List<Offer> getDetailsByemployeeId(int id) {

		return offerRepository.findByemployeeID(id);
	}

	public List<Offer> getDetailsByTopLikes() {
		List<Offer> off = new ArrayList<>();
		off = offerRepository.findAll();

		Collections.sort(off, new Comparator<Offer>() {

			@Override
			public int compare(Offer o1, Offer o2) {
				return Integer.valueOf(o2.getOfferLikes()).compareTo(Integer.valueOf(o1.getOfferLikes()));
			}

		});

		return off;

	}

	public List<Offer> getDetailsByDate(Date date) {
		return offerRepository.findByOfferOpenDate(date);
	}

	public Offer saveoffer(Offer offer) {

		return offerRepository.save(offer);// ****later save in database.
	}

	public List<Offer> viewAllOffers() {
		return offerRepository.findAll();
	}

//	public void updateOfferTable(Offer off) {
//		offerRepository.save(off);
//		
//	}

	public Offer formReply(Offer offer) {
		// return offerRepository.updatetable(offer);
		return offerRepository.save(offer);
	}

	public Offer upadteLikeResponse(Offer offer) {
		int offId = offer.getOfferId();
		int allLikes = offer.getOfferLikes();
		int allLikesInTwodays = offer.getOfferLikesInTwoDays();

		Long differenceOfDate = offer.getOfferEngagedDate().getTime() - offer.getOfferOpenDate().getTime();

		float daysBTW = ((differenceOfDate) / (1000 * 60 * 60 * 24));
		System.out.println(daysBTW);

		allLikes = allLikes + 1;

		Offer offer1 = new Offer();

		if (daysBTW > 2) {
			offer1.setOfferId(offId);
			offer1.setEmployeeID(offer.getEmployeeID());
			offer1.setOfferClosedDate(offer.getOfferClosedDate());
			offer1.setOfferDescription(offer.getOfferDescription());
			offer1.setOfferLikesInTwoDays(offer.getOfferLikesInTwoDays());
			offer1.setOfferOpenDate(offer.getOfferOpenDate());
			offer1.setOfferTitle(offer.getOfferTitle());
			offer1.setOfferLikes(allLikes);
			offer1.setCategoryId(offer.getCategoryId());

			return offerRepository.save(offer1);
		} else {
			allLikesInTwodays = allLikesInTwodays + 1;
			
			offer1.setOfferId(offId);
			offer1.setOfferLikes(allLikes);
			offer1.setOfferLikesInTwoDays(allLikesInTwodays);
			offer1.setEmployeeID(offer.getEmployeeID());
			offer1.setOfferClosedDate(offer.getOfferClosedDate());
			offer1.setOfferDescription(offer.getOfferDescription());
			offer1.setOfferOpenDate(offer.getOfferOpenDate());
			offer1.setOfferTitle(offer.getOfferTitle());
			offer1.setCategoryId(offer.getCategoryId());
			return offerRepository.save(offer1);
		}

	}
}
