package com.corporate.classifieds.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.corporate.classifieds.VO.Offer;

@FeignClient(value="offer")
public interface FeignOffer {

	@GetMapping(value = "/allOffersOfEmployee/{id}")
	public List<Offer> allOffersOfEmployee(@PathVariable("id") int id);
}
