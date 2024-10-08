package com.project.springboot.tickets.events;

import com.project.springboot.tickets.events.Event;
import com.project.springboot.tickets.events.Organiser;
import com.project.springboot.tickets.events.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

   List<Product> findByEventId(int eventId);
   List<Event> findByOrganiserId(int organiserId);
}
