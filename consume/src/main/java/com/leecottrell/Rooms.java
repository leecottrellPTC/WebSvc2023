package com.leecottrell;
import java.util.Objects;

public class Rooms {
    int roomNum;
    String guest;


    public Rooms() {
        this.roomNum=0;
        this.guest="Not a valid room";
    }

    public Rooms(int roomNum, String guest) {
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

    public Rooms roomNum(int roomNum) {
        setRoomNum(roomNum);
        return this;
    }

    public Rooms guest(String guest) {
        setGuest(guest);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rooms)) {
            return false;
        }
        Rooms rooms = (Rooms) o;
        return roomNum == rooms.roomNum && Objects.equals(guest, rooms.guest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNum, guest);
    }

    @Override
    public String toString() {
        return "{" +
            " roomNum='" + getRoomNum() + "'" +
            ", guest='" + getGuest() + "'" +
            "}";
    }
    
}
