package com.project.springboot.tickets.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganiserRepository extends JpaRepository<Organiser, Integer> {

}
