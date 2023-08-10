package com.challenge.Allocation.controller;


import com.challenge.Allocation.dto.RoomDto;
import com.challenge.Allocation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/room")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public String home() {
        roomService.findRooms();
        return "room";
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findRoomByNumber(@PathVariable Long number) {
        RoomDto produto = roomService.findRoomByNumber(number);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public String create(RoomDto roomDto) {
        roomService.createRoom(roomDto);
        return "redirect:/room/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        var room = roomService.findRooms();
        ModelAndView mv = new ModelAndView("room/list");
        mv.addObject("room", room);

        return mv;
    }
}
