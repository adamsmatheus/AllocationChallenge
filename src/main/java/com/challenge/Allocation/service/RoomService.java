package com.challenge.Allocation.service;


import com.challenge.Allocation.dto.RoomDto;
import com.challenge.Allocation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomDto> findRooms() {
        var response = roomRepository.findAll();

        return RoomDto.fromEntityList(response);
    }

    public void createRoom(RoomDto roomDto) {
        roomRepository.save(RoomDto.toEntity(roomDto));
    }

    public RoomDto findRoomByNumber(int number) {
        return RoomDto.fromEntity(roomRepository.findByNumber(number));

    }

    public boolean updateRoom(Long id, RoomDto roomDto) {

        var response = roomRepository.findById(id);

        if(response.isEmpty())
            return false;

        roomRepository.save(RoomDto.toEntity(roomDto));

        return true;
    }

    public void deleteRoom(Long id) {
         roomRepository.deleteById(id);
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
