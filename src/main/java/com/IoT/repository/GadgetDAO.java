package com.IoT.repository;

import com.IoT.model.Gadget;
import com.IoT.model.Room;
import com.mongodb.*;
import com.mongodb.client.MongoIterable;

import java.util.ArrayList;
import java.util.List;

public class GadgetDAO {
    private Config config;

    public GadgetDAO(Config config) {
        this.config = config;
    }


    public MongoIterable<String> showAllDatabases() {
        return config.getClient().listDatabaseNames();
    }

    public Gadget insertGadget(Gadget gadget) {
        DBCollection collection = config.getDb().getCollection("Gadget");

        List<BasicDBObject> rooms = new ArrayList<>();

        for (Room room : gadget.getRooms()) {
            rooms.add(new BasicDBObject("type", room.getType().toString()));
        }
        BasicDBObject document = new BasicDBObject();

        document.put("type", gadget.getGadgetType().toString());
        document.put("state", gadget.isState());
        document.put("rooms", rooms);
        document.put("name", gadget.getName());

        collection.insert(document);
        return gadget;
    }

    public void readGadgetFromDatabase(String name) {
        DBCollection collection = config.getDb().getCollection("Gadget");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);
        DBCursor cursor = collection.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}
