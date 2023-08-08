package com.challenge.Allocation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Room {
    private int numero;
    private float valueDay;

    public static List<Room> fromEntity(List<com.challenge.Allocation.entity.Room> room) {
        Room roomDTO = new Room();
        List<Room> roomList = new ArrayList<>();
        for (com.challenge.Allocation.entity.Room item : room) {
            roomDTO.setNumero(item.getNumero());
            roomDTO.setValueDay(item.getValueDay());
            roomList.add(roomDTO);
        }

        return roomList;
    }

    public static com.challenge.Allocation.entity.Room toEntity(Room room) {
        com.challenge.Allocation.entity.Room roomEntity = new com.challenge.Allocation.entity.Room();
        roomEntity.setNumero(room.getNumero());
        roomEntity.setValueDay(room.getValueDay());

        return roomEntity;
    }
}


