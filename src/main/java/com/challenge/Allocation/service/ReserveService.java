package com.challenge.Allocation.service;

import com.challenge.Allocation.dto.BookRoomDto;
import com.challenge.Allocation.entity.BookRoom;
import com.challenge.Allocation.entity.Room;
import com.challenge.Allocation.repository.ReserveRepository;
import com.challenge.Allocation.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class ReserveService {
    private final ReserveRepository reserveRepository;
    private final RoomRepository roomRepository;

    public boolean makeReserve(BookRoomDto bookRoomDto) {
        var room = roomRepository.findByNumber(bookRoomDto.getRoomNumber());

        var reserve = reserveRepository.findAllByroomNumber(bookRoomDto.getRoomNumber());
        var bookRoomDtoValidated = isBookingValid(bookRoomDto, reserve);

        if (bookRoomDtoValidated == true) {
            reserveRepository.save(BookRoomDto.toEntity(calculateValueFinal(bookRoomDto, room)));
            return true;
        }

        return false;

    }

    private BookRoomDto calculateValueFinal(BookRoomDto bookRoomDto, Room room) {

        long daysDifference = ChronoUnit.DAYS.between(bookRoomDto.getDateStart(), bookRoomDto.getDateFinish());
        bookRoomDto.setValueFinal((daysDifference + 1) * room.getValueDay());

        return bookRoomDto;
    }

    public boolean editReserve(Long id, BookRoomDto bookRoomDto) {
        var bookRoomDtoResponse = reserveRepository.findByCodeReserve(id);
        var allReservesByNumberRoom = reserveRepository.findAllByroomNumber(bookRoomDto.getRoomNumber());
        var bookRoomDtoValidated = isBookingValid(bookRoomDto, allReservesByNumberRoom);

        if (bookRoomDtoValidated == true) {
            var roomResponse = roomRepository.findByNumber(bookRoomDtoResponse.getRoomNumber());

            bookRoomDtoResponse.setDateStart(bookRoomDto.getDateStart());
            bookRoomDtoResponse.setDateFinish(bookRoomDto.getDateFinish());

            long daysDifference = ChronoUnit.DAYS.between(bookRoomDto.getDateStart(), bookRoomDto.getDateFinish());
            bookRoomDtoResponse.setFinalValue((daysDifference + 1) * roomResponse.getValueDay());

            reserveRepository.save(bookRoomDtoResponse);
            return true;
        }

        return false;
    }

    public boolean isBookingValid(BookRoomDto newBooking, List<BookRoom> existingBookings) {
        for (BookRoom existingBooking : existingBookings) {
            if (isDateInRange(newBooking.getDateStart(), existingBooking.getDateStart(), existingBooking.getDateFinish()) ||
                    isDateInRange(newBooking.getDateFinish(), existingBooking.getDateStart(), existingBooking.getDateFinish())) {
                return false; // Data está dentro do intervalo de um registro existente
            }
        }
        return true; // Data não está dentro do intervalo de nenhum registro existente
    }

    private boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    public void deleteReserve(Long id) {
        reserveRepository.deleteById(id);
    }
}
