package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event", schema = "event_manager_schema")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name = "event_id_seq", schema = "event_manager_schema", allocationSize = 1)
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
