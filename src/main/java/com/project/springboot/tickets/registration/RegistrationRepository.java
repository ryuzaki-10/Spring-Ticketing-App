package com.project.springboot.tickets.registration;

import com.project.springboot.tickets.registration.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public interface RegistrationRepository extends MongoRepository<Registration, String> {

    Optional<Registration> findByTicketCode(String ticketCode); //spring data automatically picks up the implementation by reading names of methods hence no need to write explicit implementation code

    void deleteByTicketCode(String ticketCode); //if methods are named acc to rules, spring data understands automatically what to do

}
