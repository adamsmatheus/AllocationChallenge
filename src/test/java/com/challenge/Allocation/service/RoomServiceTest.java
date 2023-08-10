package com.challenge.Allocation.service;

import com.challenge.Allocation.dto.RoomDto;
import com.challenge.Allocation.entity.Room;
import com.challenge.Allocation.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindRooms() {
        List<Room> existingRooms = new ArrayList<>();
        existingRooms.add(new Room());

        when(roomRepository.findAll()).thenReturn(existingRooms);

        List<RoomDto> rooms = roomService.findRooms();

        assertEquals(existingRooms.size(), rooms.size());
    }

    @Test
    public void testCreateRoom() {

        RoomDto roomDto = new RoomDto(); // Set roomDto properties

        roomService.createRoom(roomDto);

        verify(roomRepository, times(1)).save(any(Room.class));
    }

    @Test
    public void testFindRoomByNumber() {
        Long roomNumber = 1L;
        Room existingRoom = new Room(); // Set room properties

        when(roomRepository.findByNumber(roomNumber)).thenReturn(existingRoom);

        RoomDto room = roomService.findRoomByNumber(roomNumber);

        assertNotNull(room);
    }
}
