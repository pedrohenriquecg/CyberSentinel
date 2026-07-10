package com.pedrohenrique.cybersentinel.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EventControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new EventController()).build();
    }

    @Test
    void shouldReturnReceivedStatusWhenValidEventIsSubmitted() throws Exception {
        String requestBody = """
                {
                  "hostname": "DESKTOP-01",
                  "eventType": "PROCESS_CREATED",
                  "message": "cmd.exe was executed",
                  "occurredAt": "2026-07-10T18:30:00Z"
                }
                """;

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isAccepted())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("RECEIVED"));
    }

    @Test
    void shouldReturnBadRequestWhenRequiredFieldIsBlank() throws Exception {
        String requestBody = """
                {
                  "hostname": " ",
                  "eventType": "PROCESS_CREATED",
                  "message": "cmd.exe was executed",
                  "occurredAt": "2026-07-10T18:30:00Z"
                }
                """;

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }
}
