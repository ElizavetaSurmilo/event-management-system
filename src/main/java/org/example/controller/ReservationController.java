package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.ReservationDTO;
import org.example.entity.Reservation;
import org.example.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody ReservationDTO dto) {
        return new ResponseEntity<>(reservationService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> readAll() {
        return new ResponseEntity<>(reservationService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Reservation> update(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.update(reservation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        reservationService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> readById(@PathVariable Integer id) {
        return new ResponseEntity<>(reservationService.readById(id), HttpStatus.OK);
    }
}
