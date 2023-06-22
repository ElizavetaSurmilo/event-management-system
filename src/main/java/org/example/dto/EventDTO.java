package org.example.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventDTO {
    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private Double ticketPrice;
    private Integer organizerId;
}
