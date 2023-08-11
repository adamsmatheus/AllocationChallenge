package com.challenge.Allocation.service;

import com.challenge.Allocation.dto.BookRoomDto;
import com.challenge.Allocation.entity.BookRoom;
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
        var room = roomRepository.findByNumber(bookRoomDto.getRoomId());

        var reserve = reserveRepository.findAllByroomId(bookRoomDto.getRoomId());
        var bookRoomDtoValidated = isBookingValid(bookRoomDto, reserve);

        if (bookRoomDtoValidated == true) {
            bookRoomDto.setValueFinal(calculateValueFinal(bookRoomDto.getDateStart(), bookRoomDto.getDateFinish(), room.getValueDay()));
            reserveRepository.save(BookRoomDto.toEntity(bookRoomDto));

            return true;
        }

        return false;
    }

    private float calculateValueFinal(LocalDate dateStart, LocalDate dateFinish, float valueDay) {
        long daysDifference = ChronoUnit.DAYS.between(dateStart, dateFinish);


        return (daysDifference + 1) * valueDay;
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

    public List<BookRoomDto> findReserve() {
        var response = reserveRepository.findAll();
        return BookRoomDto.fromEntityList(response);
    }

    public List<BookRoomDto> findReserveByRoomNumber(Long id) {
        var response = reserveRepository.findAllByroomId(id);
        return BookRoomDto.fromEntityList(response);
    }

    public BookRoomDto findReserveById(Long id) {
        var response = reserveRepository.findById(id);
        return BookRoomDto.fromOptionalEntity(response);
    }

    public boolean updateReserve(Long id, BookRoomDto bookRoomDto) {

        var reserve = reserveRepository.findAllByroomId(id);
        var bookRoomDtoValidated = isBookingValid(bookRoomDto, reserve);

        if (bookRoomDtoValidated == true) {
            var roomResponse = reserve.stream().filter(item -> item.getId() == bookRoomDto.getId()).findFirst();

            var room = roomRepository.findById(roomResponse.get().getRoomId());

            roomResponse.get().setFinalValue(calculateValueFinal(bookRoomDto.getDateStart(), bookRoomDto.getDateFinish(), room.get().getValueDay()));
            roomResponse.get().setDateStart(bookRoomDto.getDateStart());
            roomResponse.get().setDateFinish(bookRoomDto.getDateFinish());
            reserveRepository.save(roomResponse.get());
            return true;
        }

        return false;
    }
}
