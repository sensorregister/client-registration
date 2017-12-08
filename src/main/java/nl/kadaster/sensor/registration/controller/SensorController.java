package nl.kadaster.sensor.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ImmutableMap;

import nl.kadaster.sensor.registration.client.SensorClient;
import nl.kadaster.sensor.registration.model.Sensor;

@RestController
public class SensorController {

	private SensorClient sensorClient;

	@Autowired
	public SensorController(SensorClient sensorClient) {
		this.sensorClient = sensorClient;
	}

	@GetMapping(path = "/")
	public ModelAndView home(@RequestParam("value") String value) {
		Sensor sensor = new Sensor();
		sensor.setCodeValue(value);
		return new ModelAndView("home", ImmutableMap.of("sensor", sensor));
	}

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView home(@ModelAttribute Sensor sensor) {
		sensorClient.create(sensor);
		return new ModelAndView("succes");
	}

}
