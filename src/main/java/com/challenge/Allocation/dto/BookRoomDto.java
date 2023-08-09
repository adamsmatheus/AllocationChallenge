package com.challenge.Allocation.dto;

import com.challenge.Allocation.entity.BookRoom;
import com.challenge.Allocation.entity.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BookRoomDto {
    private int id;
    private int roomNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinish;
    private float valueFinal = 0;

    public static BookRoom toEntity(BookRoomDto bookRoom) {
        BookRoom bookRoomEntity = new BookRoom();

        bookRoomEntity.setRoomNumber(bookRoom.getRoomNumber());
        bookRoomEntity.setDateStart(bookRoom.dateStart);
        bookRoomEntity.setDateFinish(bookRoom.dateFinish);
        bookRoomEntity.setFinalValue(bookRoom.valueFinal);

        return bookRoomEntity;
    }

    public static BookRoomDto fromEntity(BookRoom bookRoom) {
        BookRoomDto bookRoomDto = new BookRoomDto();

        bookRoomDto.setRoomNumber(bookRoom.getRoomNumber());
        bookRoomDto.setDateStart(bookRoom.getDateStart());
        bookRoomDto.setDateFinish(bookRoom.getDateFinish());
        bookRoomDto.setValueFinal(bookRoom.getFinalValue());

        return bookRoomDto;
    }

    public static List<BookRoomDto> fromEntityList(List<BookRoom> bookRoom) {
        List<BookRoomDto> bookRoomDtoList = new ArrayList<>();

        for (BookRoom item : bookRoom) {
            BookRoomDto bookRoomDto = new BookRoomDto();
            bookRoomDto.setRoomNumber(item.getRoomNumber());
            bookRoomDto.setValueFinal(item.getFinalValue());
            bookRoomDto.setDateStart(item.getDateStart());
            bookRoomDto.setDateFinish(item.getDateFinish());

            bookRoomDtoList.add(bookRoomDto);
        }

        return bookRoomDtoList;
    }

}
