package com.project.springboot.tickets.events;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EventController {

    private final OrganiserRepository organiserRepository;
    private  final EventRepository eventRepository;
    private final ProductRepository productRepository;

    public EventController(OrganiserRepository organiserRepository, EventRepository eventRepository, ProductRepository productRepository) {
        this.eventRepository = eventRepository;
        this.productRepository = productRepository;
        this.organiserRepository = organiserRepository;
    }

    @GetMapping(value = "/organisers")
    public List<Organiser> getOrganisers() {
        return organiserRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/events")
    public List<Event> getEventsByOrganiser(@RequestParam("organiserId") int organiserId) {
        return eventRepository.findByOrganiserId(organiserId);
    }

    @GetMapping(path="/events/{id}")
    public Event getEventById(@PathVariable("id") int eventId) {
            return eventRepository.findById(eventId).orElseThrow(()-> new NoSuchElementException("Event with id" + eventId + "not found"));
    }

    @GetMapping(path="/products")
    public List<Product> getProductsByEvent(@RequestParam("eventId") int eventId) {
        return productRepository.findByEventId(eventId);
    }

}
