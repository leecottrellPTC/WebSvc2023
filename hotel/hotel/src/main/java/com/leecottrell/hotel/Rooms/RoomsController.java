package com.leecottrell.hotel.Rooms;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomsController {
    static Map<Integer, Rooms> reservations = new HashMap<Integer, Rooms>();
    public RoomsController(){
        //setup you need for the controller
        reservations.put(515, new Rooms(515, "Cottrell"));
        reservations.put(603, new Rooms(603, "Schurter"));
        reservations.put(402, new Rooms(402, "Eltringham"));
    }

    @RequestMapping(value="/rooms", method=RequestMethod.GET)
    public ResponseEntity<List<Rooms>>getReservations(){
        Collection<Rooms> results = reservations.values();
        List<Rooms> response = new ArrayList<Rooms>(results);

        return new ResponseEntity<List<Rooms>>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/rooms", method=RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.NOT_IMPLEMENTED, reason = "Not implemented yet")
    public ResponseEntity<Rooms>postReservations(){
        Rooms response = new Rooms(0, "empty");

        return new ResponseEntity<Rooms>(response, HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value="/rooms", method=RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.NOT_IMPLEMENTED, reason = "Not implemented yet")
    public ResponseEntity<Rooms>putReservations(){
        Rooms response = new Rooms(0, "empty");

        return new ResponseEntity<Rooms>(response, HttpStatus.NOT_IMPLEMENTED);
    }
    

    @RequestMapping(value="/rooms", method=RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.NOT_IMPLEMENTED, reason = "Not implemented yet")
    public ResponseEntity<Rooms>deleteReservations(){
        Rooms response = new Rooms(0, "empty");

        return new ResponseEntity<Rooms>(response, HttpStatus.NOT_IMPLEMENTED);
    }
}
