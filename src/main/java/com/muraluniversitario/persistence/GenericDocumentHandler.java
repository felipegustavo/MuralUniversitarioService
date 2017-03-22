package com.muraluniversitario.persistence;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class GenericDocumentHandler {

	protected MongoCollection<Document> collection = null;

	public void insert(Document document) {
		collection.insertOne(document);
	}

	public Document findById(String id, Bson projection) {
		BasicDBObject whereClause = new BasicDBObject();
		whereClause.put("_id", new ObjectId(id));
		Document doc = collection.find(whereClause).projection(projection).first();
		return doc;
	}

	public List<Document> findAll(Bson projection) {
		MongoCursor<Document> cursor = collection.find().projection(projection).iterator();
		return fromCursorToList(cursor);
	}

	public List<Document> findMany(Bson whereClause, Bson projection) {
		MongoCursor<Document> cursor = collection.find(whereClause).projection(projection).iterator();
		return fromCursorToList(cursor);
	}

	public List<Document> fromCursorToList(MongoCursor<Document> cursor) {
		List<Document> list = new ArrayList<Document>();

		while (cursor.hasNext()) {
			list.add(cursor.next());
		}

		cursor.close();
		return list;
	}

}
