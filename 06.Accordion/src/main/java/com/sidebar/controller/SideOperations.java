package com.sidebar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sidebar.model.Elements;
import com.sidebar.repository.ElementsRepository;
import com.sidebar.service.ElementsService;
@CrossOrigin
@RestController
public class SideOperations
{
	@Autowired
	private ElementsRepository elementrepo;
	@Autowired
	private ElementsService elementservice;
	
	@PostMapping("/addelement")
	public ResponseEntity<Elements> addelement(@RequestBody Elements element)
	{
		System.out.println(element.getElement());
		Elements elem = new Elements();
		elem.setElement(element.getElement());
		elem.setDisplay(element.getDisplay());
		elem.setCategories(element.getCategories());
		System.out.println(elem);
		elementrepo.save(elem);
		return ResponseEntity.ok(elem);
		
	}
	@GetMapping("/getallelements")
	public ResponseEntity<List<Elements>> getelements(){
		List <Elements> allelements = elementrepo.findAll();
		return ResponseEntity.ok(allelements);
		
	}
	   @PutMapping("/active")
	    public ResponseEntity<List<Elements>> updateIsActiveForEntities(@RequestBody List<Batchupdate> requests) {
	        List<Elements> updatedEntities = new ArrayList<Elements>();

	        for (Batchupdate request : requests) {
	            updatedEntities.addAll(elementservice.updateIsActiveForEntities(request.getEntityIds(), request.isShow()));
	        }

	        return ResponseEntity.ok(updatedEntities);
	    }
	
	
}
