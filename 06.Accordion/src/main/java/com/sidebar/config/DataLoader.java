package com.sidebar.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sidebar.model.Categories;
import com.sidebar.model.Elements;
import com.sidebar.repository.CategoriesRepository;
import com.sidebar.repository.ElementsRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	private ElementsRepository elementrepo;
	private CategoriesRepository categoriesrepo;
	

	public DataLoader(ElementsRepository elementrepo, CategoriesRepository categoriesrepo) {
		super();
		this.elementrepo = elementrepo;
		this.categoriesrepo = categoriesrepo;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
	List<Elements> elementdata = Arrays.asList(
			new Elements("Home",true),
			new Elements("Users",true,new ArrayList<>(Arrays.asList(
				new Categories("userone",true),
				new Categories("usertwo",true) ,
				new Categories("userthree",true)
			 
					))),
			new Elements("Settings",true),
			new Elements("Analytics",true),
			new Elements("services",false,new ArrayList<>(Arrays.asList(
					
					new Categories("service1",true),
					new Categories("service2",true), 
					new Categories("service3",true)
					
					))),
			new Elements("About",false)
			
			
			);
	
		elementrepo.saveAllAndFlush(elementdata);
		
		
	}
	

}
