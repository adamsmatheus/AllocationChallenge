package com.challenge.Allocation.service;

import com.challenge.Allocation.dto.BookRoomDto;
import com.challenge.Allocation.entity.BookRoom;
import com.challenge.Allocation.entity.Room;
import com.challenge.Allocation.repository.ReserveRepository;
import com.challenge.Allocation.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ReserveServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private ReserveRepository reserveRepository;

    @InjectMocks
    private ReserveService reserveService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMakeReserve_ValidBooking() {
        when(roomRepository.findByNumber(any(Long.class))).thenReturn(new Room());
        when(reserveRepository.findAllByroomId(any(Long.class))).thenReturn(new ArrayList<>());

        BookRoomDto validBooking = new BookRoomDto();
        validBooking.setRoomId(1L);
        validBooking.setDateStart(LocalDate.now());
        validBooking.setDateFinish(LocalDate.now().plusDays(2));

        reserveService.makeReserve(validBooking);

        verify(reserveRepository, times(1)).save(any(BookRoom.class));
    }

    @Test
    public void testIsBookingValid_ValidBooking() {
        List<BookRoom> existingBookings = new ArrayList<>();
        existingBookings.add(getBookRoom());

        BookRoomDto newBooking = new BookRoomDto();
        newBooking.setDateStart(LocalDate.now());
        newBooking.setDateFinish(LocalDate.now().plusDays(2));

        boolean isValid = reserveService.isBookingValid(newBooking, existingBookings);

        assertTrue(isValid);
    }

    @Test
    public void testIsBookingValid_InvalidBooking() {
        List<BookRoom> existingBookings = new ArrayList<>();
        var bookRoomMock = getBookRoom();

        bookRoomMock.setDateStart(LocalDate.now());
        bookRoomMock.setDateFinish( LocalDate.now().plusDays(2));
        existingBookings.add(bookRoomMock);

        BookRoomDto newBooking = new BookRoomDto();
        newBooking.setDateStart(bookRoomMock.getDateStart().plusDays(1));
        newBooking.setDateFinish(bookRoomMock.getDateFinish().plusDays(1));

        boolean isValid = reserveService.isBookingValid(newBooking, existingBookings);

        assertFalse(isValid);
    }





    @Test
    public void testDeleteReserve() {
        doNothing().when(reserveRepository).deleteById(any(Long.class));

        Long reserveId = 1L;
        reserveService.deleteReserve(reserveId);

        verify(reserveRepository, times(1)).deleteById(reserveId);
    }

    @Test
    public void testFindReserve() {
        List<BookRoom> existingReserves = new ArrayList<>();
        existingReserves.add(getBookRoom());

        when(reserveRepository.findAll()).thenReturn(existingReserves);

        List<BookRoomDto> reserves = reserveService.findReserve();

        assertEquals(existingReserves.size(), reserves.size());
    }

    @Test
    public void testFindReserveByRoomNumber() {
        Long roomId = 1L;
        List<BookRoom> existingReserves = new ArrayList<>();
        existingReserves.add(getBookRoom());

        when(reserveRepository.findAllByroomId(roomId)).thenReturn(existingReserves);

        List<BookRoomDto> reserves = reserveService.findReserveByRoomNumber(roomId);

        assertEquals(existingReserves.size(), reserves.size());
    }

    @Test
    public void testFindReserveById() {
        Long reserveId = 1L;
        Optional<BookRoom> existingReserve = Optional.of(getBookRoom());

        when(reserveRepository.findById(reserveId)).thenReturn(existingReserve);

        BookRoomDto reserve = reserveService.findReserveById(reserveId);

        assertNotNull(reserve);
    }

    private BookRoom getBookRoom() {
        BookRoom bookRoom = new BookRoom();

        bookRoom.setId(1L);
        bookRoom.setDateStart(LocalDate.of(2023, 8, 15));
        bookRoom.setDateFinish(LocalDate.of(2023, 8, 20));
        bookRoom.setFinalValue(500.0f);
        bookRoom.setRoomId(1L);

        return bookRoom;
    }

}
