package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.ReservationDTO;
import org.example.entity.Reservation;
import org.example.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final EventService eventService;

    public Reservation create(ReservationDTO dto) {
        Reservation reservation = Reservation.builder()
                .ticketCount(dto.getTicketCount())
                .totalPrice((dto.getTicketCount() * eventService.getTicketPrice(dto.getEventId())))
                .status(dto.getStatus())
                .event(eventService.readById(dto.getEventId()))
                .user(userService.readById(dto.getUserId()))
                .build();
        return reservationRepository.save(reservation);
    }

    public List<Reservation> readAll() {
        return reservationRepository.findAll();
    }

    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }

    public Reservation readById(Integer id) {
        return reservationRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Reservation not found - " + id));
    }

}
