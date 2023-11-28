package com.leecottrell.openapidemo.Rooms;

public class Room {
    private int roomNum;
    private String guest;

    public Room() {
    }

    public Room(int roomNum, String guest) {
        this.roomNum = roomNum;
        this.guest = guest;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getGuest() {
        return this.guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public Room roomNum(int roomNum) {
        setRoomNum(roomNum);
        return this;
    }

    public Room guest(String guest) {
        setGuest(guest);
        return this;
    }







}
