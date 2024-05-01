package com.sidebar.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Elements {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String element;
	private Boolean display; 
	@OneToMany(cascade = CascadeType.ALL)
	private List<Categories> categories = new ArrayList<Categories>();
	public Elements(String element, Boolean display, List<Categories> categories) {
		super();
		this.element = element;
		this.display = display;
		this.categories = categories;
	}
	public Elements(String element, Boolean display) {
		super();
		this.element = element;
		this.display = display;
	}
	
	
	
	
	

}
