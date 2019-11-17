package com.IoT.model;

public class Room {
    private RoomType type;

    public Room() {
    }

    public Room(RoomType type) {
        this.type = type;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }
}
