package com.sidebar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sidebar.model.Elements;
import com.sidebar.repository.ElementsRepository;

@Service
public class ElementsService {
	
	private ElementsRepository elementrepo;

	public ElementsService(ElementsRepository elementrepo) {
		super();
		this.elementrepo = elementrepo;
	}
    public List<Elements> updateIsActiveForEntities(List<Integer> entityIds, boolean isActive) {
        List<Elements> entitiesToUpdate = elementrepo.findAllById(entityIds);

        List<Elements> updatedEntities = entitiesToUpdate.stream()
                .peek(display -> display.setDisplay(isActive))
                .collect(Collectors.toList());

        return elementrepo.saveAll(updatedEntities);
    }

}
