package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.EventDTO;
import org.example.entity.Event;
import org.example.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final OrganizerService organizerService;

    public Event create(EventDTO dto) {
        Event event = Event.builder()
                .name(dto.getName())
                .dateTime(dto.getDateTime())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .ticketPrice(dto.getTicketPrice())
                .organizer(organizerService.readById(dto.getOrganizerId()))
                .build();
        return eventRepository.save(event);
    }

    public List<Event> readAll() {
        return eventRepository.findAll();
    }

    public Event update(Event event) {
        return eventRepository.save(event);
    }

    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }

    public Event readById(Integer id) {
        return eventRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Event not found - " + id));
    }

    public Double getTicketPrice(Integer id) {
        Event event = readById(id);
        return event.getTicketPrice();
    }
}
