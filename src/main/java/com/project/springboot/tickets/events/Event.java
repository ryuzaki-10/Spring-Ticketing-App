package com.project.springboot.tickets.events;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int  id;

    @Column(nullable = false)
    private String name;

    @ManyToOne (optional = false)
    @JoinColumn(name="organise_id" , referencedColumnName = "id", nullable = false)
    private Organiser organiser;

    @ManyToOne(optional = false)
    @JoinColumn(name="venue_id" , referencedColumnName = "id", nullable =false)
    private Venue venue;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;
}
