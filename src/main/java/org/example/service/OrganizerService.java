package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.OrganizerDTO;
import org.example.entity.Organizer;
import org.example.repository.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrganizerService {

    private final OrganizerRepository organizerRepository;

    public Organizer create(OrganizerDTO dto) {
        Organizer organizer = Organizer.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .description(dto.getDescription())
                .build();
        return organizerRepository.save(organizer);
    }

    public List<Organizer> readAll() {
        return organizerRepository.findAll();
    }

    public Organizer update(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public void delete(Integer id) {
        organizerRepository.deleteById(id);
    }

    public Organizer readById(Integer id) {
        return organizerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Organizer not found - " + id));
    }
}
