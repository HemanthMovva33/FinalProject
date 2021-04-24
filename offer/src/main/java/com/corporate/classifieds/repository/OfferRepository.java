package com.corporate.classifieds.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corporate.classifieds.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer,Integer> {

	Offer findByOfferId(int id);

	List<Offer> findByCategoryId(int id);

	List<Offer> findByemployeeID(int id);

	//List<Offer> findTopByOfferLikesOrderByOfferLikesDesc();

	List<Offer> findByOfferOpenDate(Date date);

	

}
