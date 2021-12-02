package com.example.cinema.Room;

import com.example.cinema.User.User;
import com.example.cinema.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {this.roomRepository = roomRepository;}

    public List<Room> getRooms (){return roomRepository.findAll();}

    public Room getRoom(String id){
        Long room_id = Long.parseLong(id);
        return roomRepository.findById(room_id).orElse(null);
    }

    public Room createRoom(Room room){return roomRepository.save(room);}

    public void deleteRoom(String id){
        Long room_id = Long.parseLong(id);
        roomRepository.deleteById(room_id);
    }

    public void updateRoom(String id, Room data){
        Long room_id = Long.parseLong(id);
        Room room = roomRepository.findById(room_id).orElse(null);

        if (room != null){
            room.setNum_seats(data.getNum_seats());
            room.setType(data.getType());
            roomRepository.save(room);
        }
    }


}
