package com.muraluniversitario.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import com.muraluniversitario.model.Event;
import com.muraluniversitario.persistence.EventDocumentHandler;

@Path("event")
public class EventController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get")
	public List<Event> find(@QueryParam("categories") final List<String> categories, 
			@QueryParam("institutions") final List<String> institutions) {
		EventDocumentHandler eventHandler = new EventDocumentHandler();
		
		List<Event> events = new ArrayList<Event>();
		List<Document> result;
		
		if (categories.isEmpty() && institutions.isEmpty()) {
			result = eventHandler.findAll(null);
		} else if (!categories.isEmpty() && institutions.isEmpty()) {
			result = eventHandler.findByCategories(categories);
		} else if (!institutions.isEmpty() && categories.isEmpty()) {
			result = eventHandler.findByInstitutions(institutions);
		} else {
			result = eventHandler.findByInstitutionsAndCategories(categories, institutions);
		}
		
		for (Document doc : result) {
			events.add(Event.parseDocument(doc));
		}
		
		return events;
	}
	
}
