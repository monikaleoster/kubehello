package com.mon.assignment.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mon.assignment.model.request.NotificationReq;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class TemperatureControllerTest {

	@Autowired
	private MockMvc mvc;


	@Test
	public void postNotifications() throws Exception {
	    String reqJson = "{\n" +
                "  \"repeatedNotification\": false,\n" +
                "  \"srcTemps\": [\n" +
                "    0,\n" +
                "    0.5,\n" +
                "    0.2,\n" +
                "    0,\n" +
                "    1.5,\n" +
                "    0\n" +
                "  ],\n" +
                "  \"thermometerReq\": {\n" +
                "    \"boilTemperatureSpec\": {\n" +
                "      \"maxThreshHold\": 0.5,\n" +
                "      \"minThreshHold\": 0.5,\n" +
                "      \"temp\": 100\n" +
                "    },\n" +
                "    \"freezeTemperatureSpec\": {\n" +
                "      \"maxThreshHold\": 0.5,\n" +
                "      \"minThreshHold\": 0.5,\n" +
                "      \"temp\": 0\n" +
                "    }\n" +
                "  }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        NotificationReq notificationReq = mapper.readValue(reqJson, NotificationReq.class);
		mvc.perform(MockMvcRequestBuilders.post("/notifications").content(asJsonString(notificationReq))  .contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

