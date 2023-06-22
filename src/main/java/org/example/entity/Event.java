package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String description;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    private String location;
    @Column(name = "ticket_price")
    private Double ticketPrice;
    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;
}
