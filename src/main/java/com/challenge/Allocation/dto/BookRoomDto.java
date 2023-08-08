package com.challenge.Allocation.dto;

import com.challenge.Allocation.entity.BookRoom;
import com.challenge.Allocation.entity.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class BookRoomDto {
    private int roomNumber;
    private Date dateStart;
    private Date dateFinish;
    private float valueFinal;

    public static BookRoom toEntity(BookRoomDto bookRoom, Room room) {
        BookRoom bookRoomEntity = new BookRoom();

        bookRoomEntity.setRoomNumber(room.getNumber());
        bookRoomEntity.setDateStart(bookRoom.dateStart);
        bookRoomEntity.setDateFinish(bookRoom.dateFinish);
        bookRoomEntity.setFinalValue(bookRoom.valueFinal);

        return bookRoomEntity;
    }

}
