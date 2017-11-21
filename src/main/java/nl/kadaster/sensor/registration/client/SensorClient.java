package nl.kadaster.sensor.registration.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.kadaster.sensor.registration.model.Sensor;

@FeignClient(name = "register")
public interface SensorClient {

	@RequestMapping(method = RequestMethod.GET, value = "/sensors/{id}")
	Sensor getSensor(@PathVariable("id") String id);

	@RequestMapping(method = RequestMethod.POST, value = "/sensors", consumes = "application/json")
	Sensor create(Sensor identity);

	@RequestMapping(method = RequestMethod.POST, value = "/sensors/{id}", consumes = "application/json")
	Sensor update(@PathVariable("id") Long id, Sensor identity);
}
