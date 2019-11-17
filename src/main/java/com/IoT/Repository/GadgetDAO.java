package com.IoT.Repository;

import com.IoT.model.Gadget;
import com.IoT.model.Room;
import com.mongodb.*;
import com.mongodb.client.MongoIterable;

import java.util.ArrayList;
import java.util.List;

public class GadgetDAO {
    private Config config;

    public GadgetDAO() {
        config = new Config();
    }


    public MongoIterable<String> showAllDatabases() {
        return config.getClient().listDatabaseNames();
    }

    public Gadget insertGadget(Gadget gadget) {
        DBCollection collection = config.getClient().getDB("localhost").getCollection("Gadget");

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

    public void readFromDatabase() {
        DBCollection collection = config.getClient().getDB("localhost").getCollection("Gadget");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "cimi");
        DBCursor cursor = collection.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}
