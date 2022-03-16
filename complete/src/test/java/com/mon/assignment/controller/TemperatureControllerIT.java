/*
package com.mon.assignment.controller;

import com.mon.assignment.model.Thermometer;
import com.mon.assignment.model.request.NotificationReq;
import com.mon.assignment.model.request.ThermometerReq;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TemperatureControllerIT {

	@Autowired
	private TestRestTemplate template;

    @Test
    public void getHello() throws Exception {
        NotificationReq req= new NotificationReq();
        Double[] temp ={0d,0.2d,0.5d,0d,100d,100.2d,100.3d,100d,100d};
        req.setSrcTemps(temp);
        ThermometerReq thermometerReq = new ThermometerReq();
        thermometerReq.setBoilTemperatureSpec();
        ResponseEntity<String> response = template.postForEntity("/notifications", );
        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
    }
}
*/
