package com.challenge.Allocation.controller;

import com.challenge.Allocation.dto.BookRoomDto;
import com.challenge.Allocation.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reserve")
@AllArgsConstructor
public class ReserveController {

    private final ReserveService reserveService;

    @GetMapping
    public String home() {
        return "reserve";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editReserve(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("update");
        var response = reserveService.findReserveById(id);
        mv.addObject("reserve",response);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String cancelReserve(@PathVariable("id") Long id) {
        reserveService.deleteReserve(id);
        return "redirect:/reserve/list";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, BookRoomDto bookRoomDto) {
        if (bookRoomDto.getDateStart().isAfter(bookRoomDto.getDateFinish())) {
            return "error";
        }

        if (!reserveService.updateReserve(id,bookRoomDto))
            return "ok";

        return "redirect:/reserve/list";
    }

    @GetMapping("/consult")
    public String consultAll() {
        return "consult";
    }

    @GetMapping("/consultById")
    public String consultById() {
        return "consultById";
    }

    @PostMapping("/create")
    public String create(BookRoomDto bookRoomDto) {
        if (bookRoomDto.getDateStart().isAfter(bookRoomDto.getDateFinish())) {
            return "error";
        }

        if (!reserveService.makeReserve(bookRoomDto))
            return "ok";

        return "redirect:/reserve/list";
    }
    @PostMapping("/consultById")
    public ModelAndView consultById(Long id) {
        var reserve = reserveService.findReserveByRoomNumber(id);
        ModelAndView mv = new ModelAndView("reserve/listById");
        mv.addObject("reserve", reserve);

        return mv;
    }
    @PostMapping("/consult")
    public ModelAndView consult() {
        var reserve = reserveService.findReserve();
        ModelAndView mv = new ModelAndView("reserve/listById");
        mv.addObject("reserve", reserve);

        return mv;
    }
    @GetMapping("/list")
    public ModelAndView list() {
        var reserve = reserveService.findReserve();
        ModelAndView mv = new ModelAndView("reserve/list");
        mv.addObject("reserve", reserve);

        return mv;
    }
}
