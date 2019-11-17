package com.IoT.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Gadget {
    private String name;
    @JsonProperty("gadgetType")
    private GadgetType gadgetType;
    private boolean state;
    private ArrayList<Room> rooms;

    public Gadget() {
    }

    public Gadget(String name, GadgetType gadgetType, boolean state, ArrayList<Room> rooms) {
        this.name = name;
        this.gadgetType = gadgetType;
        this.state = state;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GadgetType getGadgetType() {
        return gadgetType;
    }

    public void setGadgetType(GadgetType gadgetType) {
        this.gadgetType = gadgetType;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
