package com.muraluniversitario.model;

import java.util.Date;
import java.util.List;

import org.bson.Document;

public class Event {

	private String id;
	private String name;
	private String description;
	private String image;
	private String place;
	private Date begin;
	private Date end;
	private String price;
	private String facebook;
	private String website;
	private List<String> categories;
	private List<String> institution;

	@SuppressWarnings("unchecked")
	public static Event parseDocument(Document doc) {
		return new Event(doc.getObjectId("_id").toHexString(),
				doc.getString("name"),
				doc.getString("description"),
				doc.getString("image"),
				doc.getString("place"),
				doc.getDate("begin"),
				doc.getDate("end"),
				doc.getString("price"),
				doc.getString("facebook"),
				doc.getString("website"),
				(List<String>) doc.get("categories"),
				(List<String>) doc.get("institutions"));
	}

	public Event(String id, String name, String description, String image, String place, Date begin, Date end,
			String price, String facebook, String website, List<String> categories, List<String> institution) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.place = place;
		this.begin = begin;
		this.end = end;
		this.price = price;
		this.facebook = facebook;
		this.website = website;
		this.categories = categories;
		this.institution = institution;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getInstitution() {
		return institution;
	}

	public void setInstitution(List<String> institution) {
		this.institution = institution;
	}
	
}