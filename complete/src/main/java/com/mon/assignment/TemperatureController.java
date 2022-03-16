package com.mon.assignment;

import com.mon.assignment.model.Thermometer;
import com.mon.assignment.model.request.NotificationReq;
import com.mon.assignment.model.request.TemperatureSpec;
import com.mon.assignment.model.request.ThermometerReq;
import com.mon.assignment.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class TemperatureController {
	@Autowired
	INotificationService notificationService;
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {

		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}

	@RequestMapping(value = "/notifications", method = RequestMethod.POST)
	public ResponseEntity<Map<Double,Integer>> notifications(@RequestBody NotificationReq notificationReq) {
		Map<Double,Integer> response =null;
		try {
			Thermometer thermometer = createThermometer(notificationReq.getThermometerReq());

			Double[] sourceTemps = notificationReq.getSrcTemps();
			response= notificationService.notify(sourceTemps, thermometer, notificationReq.getDisableRepeatedNotification());
		}catch (RuntimeException ex){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Issue with service");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	public Thermometer createThermometer(ThermometerReq thermometerReq) {
		Thermometer thermometer = new Thermometer();
		thermometer.setFreezingTemp(thermometerReq.getFreezeTemperatureSpec().getTemp());
		thermometer.setBoilingTemp(thermometerReq.getBoilTemperatureSpec().getTemp());
		thermometer.setMinBoilingTemp(minTemp(thermometerReq.getBoilTemperatureSpec()));
		thermometer.setMaxBoilingTemp(maxTemp(thermometerReq.getBoilTemperatureSpec()));
		thermometer.setMinFreezingTemp(minTemp(thermometerReq.getFreezeTemperatureSpec()));
		thermometer.setMaxFreezingTemp(maxTemp(thermometerReq.getFreezeTemperatureSpec()));

		return thermometer;

	}

	private double minTemp(TemperatureSpec temperatureSpec) {
		return  temperatureSpec.getTemp() - temperatureSpec.getMinThreshHold();
	}

	private double maxTemp(TemperatureSpec temperatureSpec) {
		return  temperatureSpec.getTemp() + temperatureSpec.getMaxThreshHold();
	}
}
