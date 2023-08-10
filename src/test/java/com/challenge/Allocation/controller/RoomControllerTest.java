package com.challenge.Allocation.controller;

import com.challenge.Allocation.dto.RoomDto;
import com.challenge.Allocation.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomControllerTest {
    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    @Test
    public void testFindRoomByNumber() throws Exception {
        Long roomNumber = 1L;
        RoomDto roomDto = new RoomDto(); // Assume a RoomDto class
        when(roomService.findRoomByNumber(roomNumber)).thenReturn(roomDto);

        roomController.findRoomByNumber(roomNumber);

        verify(roomService, times(1)).findRoomByNumber(roomNumber);
    }

    @Test
    public void testCreateRoom() throws Exception {
        doNothing().when(roomService).createRoom(any());
        var response = roomController.create(getRoomDto());

        Assertions.assertEquals(response,"redirect:/room/list");
    }

    @Test
    public void testListRooms() throws Exception {
        List<RoomDto> rooms = new ArrayList<>(); // Assume a RoomDto class
        when(roomService.findRooms()).thenReturn(rooms);

        roomController.list();

        verify(roomService, times(1)).findRooms();
    }


    private RoomDto getRoomDto() {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(1);
        roomDto.setNumber(100);
        roomDto.setValueDay(500.0f);
        return roomDto;
    }


}
