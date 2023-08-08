package com.challenge.Allocation.service;


import com.challenge.Allocation.dto.Room;
import com.challenge.Allocation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultService {

    private final HotelRepository hotelRepository;

    @Autowired
    public ConsultService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Room> findRooms() {
        var response = hotelRepository.findAll();

        return Room.fromEntityList(response);
    }

    public void createRoom(Room room) {
        hotelRepository.save(Room.toEntity(room));
    }

    public Room findRoomByNumber(int number) {
        return Room.fromEntity(hotelRepository.findByNumber(number));

    }


//
    // public Room criarProduto(Room room) {
    //     return hotelRepository.save(room);
    // }
//
    // public void deletarProduto(Long id) {
    //     hotelRepository.deleteById(id);
    // }
}
