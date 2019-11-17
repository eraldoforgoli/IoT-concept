package com.IoT.controller;

import com.IoT.Repository.GadgetDAO;
import com.IoT.model.Gadget;
import com.mongodb.client.MongoIterable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/gadgets")
public class GadgetController {

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public MongoIterable<String> hello() {
        GadgetDAO dao = new GadgetDAO();
        return dao.showAllDatabases();
    }

    @RequestMapping("/read-gadget")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public void readGadget() {
        GadgetDAO dao = new GadgetDAO();
        dao.readFromDatabase();
    }

    @RequestMapping("/insert")
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    @SendTo("/topic/messages")
    public Gadget insertGadget(@RequestBody Gadget gadget) {
        GadgetDAO dao = new GadgetDAO();
        return dao.insertGadget(gadget);
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Gadget send(Gadget gadget) throws Exception {
        return gadget;
    }

}
