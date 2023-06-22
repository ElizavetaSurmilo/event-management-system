package org.example.repository;

import org.example.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
