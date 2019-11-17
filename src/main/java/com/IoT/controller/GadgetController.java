package com.IoT.controller;

import com.IoT.repository.GadgetDAO;
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
    private final GadgetDAO dao;

    public GadgetController(GadgetDAO dao) {
        this.dao = dao;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public MongoIterable<String> hello() {
        return dao.showAllDatabases();
    }

    @RequestMapping("/read-gadget")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public void readGadget(@RequestParam String name) {
        dao.readGadgetFromDatabase(name);
    }

    @RequestMapping("/insert")
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    @SendTo("/topic/messages")
    public Gadget insertGadget(@RequestBody Gadget gadget) {
        return dao.insertGadget(gadget);
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Gadget send(Gadget gadget) throws Exception {
        return gadget;
    }

}
