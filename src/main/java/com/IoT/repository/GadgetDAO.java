package com.IoT.repository;

import com.IoT.model.Gadget;
import com.IoT.model.Room;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.*;
import com.mongodb.client.MongoIterable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GadgetDAO implements IGadgetDAO {
    private IConfig config;

    public GadgetDAO(IConfig config) {
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

    public Gadget readGadgetFromDatabase(String name) {
        DBCollection collection = config.getDb().getCollection("Gadget");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);
        DBObject object = collection.findOne(searchQuery);

        return object != null ? convertJsonToGadget(object.toString()) : null;
    }

    private static Gadget convertJsonToGadget(String json) {
        Type type = new TypeToken<Gadget>() {
        }.getType();

        return new Gson().fromJson(json, type);
    }
}
