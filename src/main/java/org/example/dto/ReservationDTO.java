package org.example.dto;

import lombok.Data;


@Data
public class ReservationDTO {
    private Integer ticketCount;
    private String status;
    private Integer eventId;
    private Integer userId;
}
