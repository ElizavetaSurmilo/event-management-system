package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.OrganizerDTO;
import org.example.entity.Organizer;
import org.example.service.OrganizerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizers")
@AllArgsConstructor
public class OrganizerController {

    private final OrganizerService organizerService;

    @PostMapping
    public ResponseEntity<Organizer> create(@RequestBody OrganizerDTO dto) {
        return new ResponseEntity<>(organizerService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Organizer>> readAll() {
        return new ResponseEntity<>(organizerService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Organizer> update(@RequestBody Organizer organizer) {
        return new ResponseEntity<>(organizerService.update(organizer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        organizerService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> readById(@PathVariable Integer id) {
        return new ResponseEntity<>(organizerService.readById(id), HttpStatus.OK);
    }
}
