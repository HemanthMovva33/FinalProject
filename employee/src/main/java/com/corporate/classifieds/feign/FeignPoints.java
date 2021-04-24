package com.corporate.classifieds.feign;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.corporate.classifieds.VO.Points;

@FeignClient(value="points")
public interface FeignPoints {
		@GetMapping(value = "/refreshPointsOfEmployee/{id}")
		public Points refreshPointsOfEmployee(@PathVariable("id") int id);
	}

