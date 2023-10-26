package com.leecottrell.hotel.Rooms;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RoomsController {
    static Map<Integer, Rooms> reservations = new HashMap<Integer, Rooms>();
    public RoomsController(){
        //setup you need for the controller
        reservations.put(515, new Rooms(515, "Cottrell"));
        reservations.put(603, new Rooms(603, "Schurter"));
        reservations.put(402, new Rooms(402, "Eltringham"));
    }

    //modify to accept int parameter or no parameter
    @RequestMapping(value="/rooms", method=RequestMethod.GET)


    public ResponseEntity<List<Rooms>>getReservations(@RequestParam(value="roomNum", defaultValue = "0") int roomNum){
     //   Collection<Rooms> results = reservations.values();
       // List<Rooms> response = new ArrayList<Rooms>(results);

      
       List<Rooms> response = new ArrayList<Rooms>();
        if(roomNum < 0 || roomNum > 616){
            response.add(new Rooms(roomNum, "Room numbers between 0 and 616"));
             return new ResponseEntity<List<Rooms>>(response, HttpStatus.NOT_ACCEPTABLE);
        }
       switch (roomNum) {
        case 0:
        //no parameter passed in, then send entire reservation
            response = new ArrayList<Rooms>(reservations.values());
            break;       
        default:
            Rooms found = reservations.get(roomNum);
            if(found == null){
                response.add(new Rooms(roomNum, "Room is empty, ready to reserve!"));
                 return new ResponseEntity<List<Rooms>>(response, HttpStatus.NOT_FOUND);
            }
            else{
            //passed ina room number
                response.add(found);
            }
            break;
       }

        return new ResponseEntity<List<Rooms>>(response, HttpStatus.OK);
    }

    //POST will add a value to the map
    //POST will accept a JSON document to add
    //POST will check to see if room is legit and available
    @RequestMapping(value="/rooms", method=RequestMethod.POST)
    public ResponseEntity<Rooms>postReservations(@RequestBody String newRes){
        ObjectMapper mapper = new ObjectMapper();
        Rooms response = new Rooms(0, "Error in reservation, not added");
        try{
            response = mapper.readValue(newRes, Rooms.class);
            if(reservations.get(response.getRoomNum()) == null){
                //room not reserved
                reservations.put(response.getRoomNum(), response);
            }
            else{
                response.setGuest("Room is already reserved");
                return new ResponseEntity<Rooms>(response, HttpStatus.NOT_ACCEPTABLE);
            }
            
        }catch(JsonProcessingException jme){
            //not handled yet
            response.setGuest(jme.getMessage().toString());
            return new ResponseEntity<Rooms>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Rooms>(response, HttpStatus.OK);
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
