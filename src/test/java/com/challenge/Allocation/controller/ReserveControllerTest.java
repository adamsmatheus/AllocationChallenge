package com.challenge.Allocation.controller;

import com.challenge.Allocation.dto.BookRoomDto;
import com.challenge.Allocation.service.ReserveService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ReserveControllerTest {

    @Mock
    private ReserveService reserveService;

    @InjectMocks
    private ReserveController reserveController;


    @Test
    public void testEditReserve() {
        Long reserveId = 1L;
        when(reserveService.findReserveById(reserveId)).thenReturn(getCompleteBookRoomDto());

        var response = reserveController.editReserve(reserveId);

        verify(reserveService, times(1)).findReserveById(reserveId);
    }

    @Test
    public void testCancelReserve() {
        Long reserveId = 1L;
        reserveController.cancelReserve(reserveId);

        verify(reserveService, times(1)).deleteReserve(reserveId);
    }

    @Test
    public void testUpdate() {
        Long reserveId = 1L;
        BookRoomDto bookRoomDto = new BookRoomDto(); // Assume a BookRoomDto class
        bookRoomDto.setDateStart(LocalDate.now());
        bookRoomDto.setDateFinish(LocalDate.now().plusDays(1));

        when(reserveService.updateReserve(eq(reserveId), any(BookRoomDto.class))).thenReturn(true);

        reserveController.update(1L, getCompleteBookRoomDto());

        verify(reserveService, times(1)).updateReserve(eq(reserveId), any(BookRoomDto.class));
    }

    @Test
    public void testCreate() {
        BookRoomDto bookRoomDto = new BookRoomDto();
        bookRoomDto.setDateStart(LocalDate.now());
        bookRoomDto.setDateFinish(LocalDate.now().plusDays(1));

        when(reserveService.makeReserve(any(BookRoomDto.class))).thenReturn(true);

        reserveController.create(getCompleteBookRoomDto());

        verify(reserveService, times(1)).makeReserve(any(BookRoomDto.class));
    }

    @Test
    public void testConsult() {
        List<BookRoomDto> reserves = new ArrayList<>(); // Assume a Reserve class
        when(reserveService.findReserve()).thenReturn(reserves);

       reserveController.consult();

        verify(reserveService, times(1)).findReserve();
    }

    @Test
    public void testList() {
        List<BookRoomDto> reserves = new ArrayList<>(); // Assume a Reserve class
        when(reserveService.findReserve()).thenReturn(reserves);

        reserveController.list();

        verify(reserveService, times(1)).findReserve();
    }


    private BookRoomDto getCompleteBookRoomDto() {
        BookRoomDto bookRoomDto = new BookRoomDto();
        bookRoomDto.setId(1L);
        bookRoomDto.setRoomId(101L);
        bookRoomDto.setDateStart(LocalDate.of(2023, 8, 15));
        bookRoomDto.setDateFinish(LocalDate.of(2023, 8, 20));
        bookRoomDto.setValueFinal(500.0f);
        return bookRoomDto;
    }

}
