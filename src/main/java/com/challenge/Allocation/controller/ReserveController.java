package com.challenge.Allocation.controller;

import com.challenge.Allocation.dto.BookRoomDto;
import com.challenge.Allocation.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserve")
@AllArgsConstructor
public class ReserveController {

    private final ReserveService reserveService;

    @Operation(summary = "reserve", description = "To make new reserves")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "BadRequest"),
            @ApiResponse(responseCode = "401", description = "Invalid Info")})
    @PostMapping
    public ResponseEntity<String> makeReserve(@RequestBody BookRoomDto bookRoomDto) {

        if (bookRoomDto.getDateStart().isAfter(bookRoomDto.getDateFinish())) {
            return ResponseEntity.status(401).body("A data de início é posterior a data fim.");
        }

        if (!reserveService.makeReserve(bookRoomDto))
            return ResponseEntity.badRequest().body("Já possui reserva para as datas selecionadas.");

        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "reserve", description = "To make new reserves")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "BadRequest"),
            @ApiResponse(responseCode = "401", description = "Invalid Info")})
    @PutMapping("/{id}")
    public ResponseEntity editReserve(@PathVariable Long id, @RequestBody BookRoomDto bookRoomDto) {

        if (bookRoomDto.getDateStart().isAfter(bookRoomDto.getDateFinish())) {
            return ResponseEntity.status(401).body("A data de início é posterior a data fim.");
        }
        if (!reserveService.editReserve(id,bookRoomDto))
            return ResponseEntity.badRequest().body("Não foi possivel alterar as datas pois já existe reserva para esse quarto nas datas selecionadas");

        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "reserve", description = "To make new reserves")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "BadRequest"),
            @ApiResponse(responseCode = "401", description = "Invalid Info")})
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReserve(@PathVariable Long id) {

        reserveService.deleteReserve(id);

        return ResponseEntity.status(201).build();
    }


}
