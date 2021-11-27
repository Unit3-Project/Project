package com.example.cinema.Room;

import com.example.cinema.User.User;
import com.example.cinema.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {this.roomService = roomService;}

    @GetMapping
    public List<Room> getRooms(){return roomService.getRooms();}

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable String id){return roomService.getRoom(id);}

    @PostMapping
    public Room createRoom(@RequestBody Room room){return roomService.createRoom(room);}

    @DeleteMapping
    public void deleteRoom(@PathVariable String id){roomService.deleteRoom(id);}

    @PutMapping("/{id}")
    public void updateRoom(@PathVariable String id, @RequestBody Room data){roomService.updateRoom(id, data);}

}
