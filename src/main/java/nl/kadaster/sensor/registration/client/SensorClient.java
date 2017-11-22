package nl.kadaster.sensor.registration.client;

import nl.kadaster.sensor.registration.model.Code;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.kadaster.sensor.registration.model.Sensor;

@FeignClient(name = "register")
public interface SensorClient {

	@RequestMapping(method = RequestMethod.GET, value = "/sensors/{id}")
	Sensor getSensor(@PathVariable("id") String id);

	@RequestMapping(method = RequestMethod.POST, value = "/sensors", consumes = "application/json")
	Resource<Sensor> create(Sensor identity);

	@RequestMapping(method = RequestMethod.POST, value = "/sensors/{id}", consumes = "application/json")
	Sensor update(@PathVariable("id") Long id, Sensor identity);

    @RequestMapping(method = RequestMethod.GET, value = "/codes/search/findOneByValue?value={value}", consumes = "application/json")
    Code findCodeByValue(@PathVariable("value") String value);

    @RequestMapping(method = RequestMethod.PUT, value = "/codes/{id}", consumes="application/json")
    Code update(@PathVariable("id") long id, Code code);

    @RequestMapping(method = RequestMethod.PUT, consumes = "text/uri-list",  value = "/codes/{codeId}/sensor/")
    Resource<Code> linkSensor(@PathVariable("codeId") long codeId, @RequestBody String sensorUri);
}
