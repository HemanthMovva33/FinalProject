package com.corporate.classifieds;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.corporate.classifieds.entity.Category;
import com.corporate.classifieds.entity.Offer;
import com.corporate.classifieds.repository.CategoryRepository;
import com.corporate.classifieds.repository.OfferRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

 

import com.corporate.classifieds.entity.Category;
import com.corporate.classifieds.entity.Offer;
import com.corporate.classifieds.repository.CategoryRepository;
import com.corporate.classifieds.repository.OfferRepository;

 

@Component
public class MyRunner implements CommandLineRunner {

 

    @Autowired
    OfferRepository offerRepository;

 

    @Autowired
    CategoryRepository categoryRepository;

 

    @Override
    public void run(String... args) throws Exception {
        Offer off = new Offer();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date OpenDate = sdf.parse("2021-04-30");
        off.setOfferOpenDate(OpenDate);
        off.setOfferClosedDate(null);
        off.setOfferEngagedDate(null);
        off.setOfferTitle("TV");
        off.setOfferDescription("Brand new tv");
        off.setOfferLikes(22);
        off.setEmployeeID(120);
        off.setCategoryId(2);
        off.setOfferLikesInTwoDays(50);

 

        //ArrayList<String> comments = new ArrayList<>();
        //comments.add("nice product");
        //comments.add("I would like to buy");
        //off.setOfferComments(comments);
        offerRepository.save(off);
        
        Category cat=new Category();
        cat.setCategoryId(2);
        cat.setCategoryName("Electronics");
        
        Offer off1 = new Offer();
        Date OpenDate2 = sdf.parse("2020-05-03");
        off1.setOfferOpenDate(OpenDate2);
        //off1.setOfferOpenDate(new Date(2020-12-12));
        off1.setOfferClosedDate(new Date());
        off.setOfferEngagedDate(null);
        off1.setOfferTitle("TV");
        off1.setOfferDescription("Brand new tv");
        off1.setOfferLikes(20);
        off1.setEmployeeID(120);
        off1.setCategoryId(2);
        off1.setOfferLikesInTwoDays(210);
        offerRepository.save(off1);
    }
}
