package com.corporate.classifieds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corporate.classifieds.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catgoryRepository;

}
