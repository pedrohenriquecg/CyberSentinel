package com.pedrohenrique.cybersentinel.dto;

import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SecurityEventRequest(
        @NotBlank String hostname,
        @NotBlank String eventType,
        @NotBlank String message,
        @NotNull Instant occurredAt) {
}
