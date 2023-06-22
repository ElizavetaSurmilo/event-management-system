package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizer", schema = "event_manager_schema")
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizer_id_seq")
    @SequenceGenerator(name = "organizer_id_seq", schema = "event_manager_schema", allocationSize = 1)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String description;
}
