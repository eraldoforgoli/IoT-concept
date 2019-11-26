package com.IoT.repository;

import com.IoT.model.Gadget;
import com.mongodb.client.MongoIterable;

public interface IGadgetDAO {
    MongoIterable<String> showAllDatabases();

    Gadget insertGadget(Gadget gadget);

    Gadget readGadgetFromDatabase(String name);
}
