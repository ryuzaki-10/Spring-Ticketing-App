package com.project.springboot.tickets.registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Registration(
        int id,
        @NotNull(message = "product id cannot be null") int productId,
        String ticketCode,
        @NotBlank(message="Attendee name is required") String attendeeName
        ) {
}
