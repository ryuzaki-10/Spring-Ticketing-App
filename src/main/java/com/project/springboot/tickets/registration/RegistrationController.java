package com.project.springboot.tickets.registration;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController(value = "/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {
        String ticketCode = UUID.randomUUID().toString();
        return registrationRepository.save(new Registration(null,registration.productId(),ticketCode, registration.attendeeName()));
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(()-> new NoSuchElementException("Registration with ticket code" + ticketCode + "not found"));
    }

    @PutMapping
    public Registration update (Registration registration) {
        //lookup for existing registration by ticketcode
        String ticketCode  = registration.ticketCode();
        var existing = registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(()-> new NoSuchElementException("Registration with ticket code "+ ticketCode+" not found"));

        return registrationRepository.save(new Registration(existing.id(), existing.productId(), ticketCode, registration.attendeeName()));
    }

    @DeleteMapping(value = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}
