package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.EventDTO;
import org.example.entity.Event;
import org.example.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventDTO dto) {
        return new ResponseEntity<>(eventService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Event>> readAll() {
        return new ResponseEntity<>(eventService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Event> update(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.update(event), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        eventService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> readById(@PathVariable Integer id) {
        return new ResponseEntity<>(eventService.readById(id), HttpStatus.OK);
    }
}
