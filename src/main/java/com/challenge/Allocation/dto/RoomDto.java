package com.challenge.Allocation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RoomDto {
    private int number;
    private float valueDay;

    public static List<RoomDto> fromEntityList(List<com.challenge.Allocation.entity.Room> room) {
        RoomDto roomDTO = new RoomDto();
        List<RoomDto> roomDtoList = new ArrayList<>();
        for (com.challenge.Allocation.entity.Room item : room) {
            roomDTO.setNumber(item.getNumber());
            roomDTO.setValueDay(item.getValueDay());
            roomDtoList.add(roomDTO);
        }

        return roomDtoList;
    }

    public static RoomDto fromEntity(com.challenge.Allocation.entity.Room room) {
        RoomDto roomDTO = new RoomDto();

        roomDTO.setNumber(room.getNumber());
        roomDTO.setValueDay(room.getValueDay());

        return roomDTO;
    }

    public static com.challenge.Allocation.entity.Room toEntity(RoomDto roomDto) {
        com.challenge.Allocation.entity.Room roomEntity = new com.challenge.Allocation.entity.Room();
        roomEntity.setNumber(roomDto.getNumber());
        roomEntity.setValueDay(roomDto.getValueDay());

        return roomEntity;
    }
}


