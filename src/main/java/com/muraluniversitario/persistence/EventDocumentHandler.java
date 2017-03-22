package com.muraluniversitario.persistence;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;

public class EventDocumentHandler extends GenericDocumentHandler {

	private static final String COLLECTION_NAME = "event";

	public EventDocumentHandler() {
		super.collection = Connection.getInstance().getCollection(COLLECTION_NAME);
	}

	public long countRecords() {
		return collection.count();
	}
	
	public List<Document> findByCategories(List<String> categories) {
		BasicDBObject where = new BasicDBObject("categories", new BasicDBObject("$in", categories));
		MongoCursor<Document> cursor = collection.find(where)
				.sort(new BasicDBObject("begin", 1)).projection(null).iterator();

		return fromCursorToList(cursor);
	}

	public List<Document> findByInstitutions(List<String> institutions) {
		BasicDBObject where = new BasicDBObject("institutions", new BasicDBObject("$in", institutions));
		MongoCursor<Document> cursor = collection.find(where)
				.sort(new BasicDBObject("begin", 1)).projection(null).iterator();

		return fromCursorToList(cursor);
	}
	
	public List<Document> findByInstitutionsAndCategories(List<String> categories, List<String> institutions) {
		List<BasicDBObject> where = new ArrayList<BasicDBObject>(2);
		where.add(new BasicDBObject("categories", new BasicDBObject("$in", categories)));
		where.add(new BasicDBObject("institutions", new BasicDBObject("$in", institutions)));
		
		MongoCursor<Document> cursor = collection.find(new BasicDBObject("$and", where))
				.sort(new BasicDBObject("begin", 1)).projection(null).iterator();

		return fromCursorToList(cursor);
	}
	
}
