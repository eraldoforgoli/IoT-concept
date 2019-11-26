package com.IoT.controller;

import com.IoT.model.Gadget;
import com.IoT.repository.IGadgetDAO;
import com.mongodb.client.MongoIterable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/gadgets")
public class GadgetController {
    private final IGadgetDAO dao;

    public GadgetController(IGadgetDAO dao) {
        this.dao = dao;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public MongoIterable<String> showAllDatabases() {
        return dao.showAllDatabases();
    }

    @RequestMapping("/read-gadget")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Gadget readGadget(@RequestParam String name) {
        return dao.readGadgetFromDatabase(name);
    }

    @RequestMapping("/insert")
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    @SendTo("/topic/messages")
    public Gadget insertGadget(@RequestBody Gadget gadget) {
        return dao.insertGadget(gadget);
    }

}
