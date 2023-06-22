package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation", schema = "event_manager_schema")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_id_seq")
    @SequenceGenerator(name = "reservation_id_seq", schema = "event_manager_schema", allocationSize = 1 )
    private Integer id;
    @CreationTimestamp
    private Date reserved_at;
    @Column(name = "ticket_count")
    private Integer ticketCount;
    @Column(name = "total_price")
    private Double totalPrice;
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}