package com.project.springboot.tickets.events;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganiserRepository {

    private final List<Organiser> organisers  = List.of(
            new Organiser(101, "Globomantics", "Globomantics Tech Corporation"),
            new Organiser(102, "Carved Rock", "Carved Rock Sports Equipment")
    );

    public List<Organiser> findAll() {
        return organisers;
    }
}
