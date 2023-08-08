package com.challenge.Allocation.service;

import com.challenge.Allocation.dto.BookRoomDto;
import com.challenge.Allocation.repository.ReserveRepository;
import com.challenge.Allocation.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReserveService {
    private final ReserveRepository reserveRepository;
    private final RoomRepository roomRepository;

    public boolean makeReserve(BookRoomDto bookRoomDto) {
        var room = roomRepository.findByNumber(bookRoomDto.getRoomNumber());

        var response = reserveRepository.save(BookRoomDto.toEntity(bookRoomDto, room));
        if (response.getId() != null) {
            return true;
        }
        return false;
    }

    public boolean editReserve(Long id, BookRoomDto bookRoomDto) {
        var room = roomRepository.findRoomById(id);

        var response = reserveRepository.save(BookRoomDto.toEntity(bookRoomDto, room));
        if (response.getId() != null) {
            return true;
        }
        return false;
    }
}
