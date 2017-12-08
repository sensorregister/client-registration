package nl.kadaster.sensor.registration.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.kadaster.sensor.registration.model.Sensor;

@FeignClient(name = "register")
public interface SensorClient {

	@RequestMapping(method = RequestMethod.POST, value = "/sensors/register", consumes = "application/json")
	Sensor create(Sensor identity);

}
