package com.baeldung.sra.api.foo;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.sra.service.Foo;
import com.baeldung.sra.service.FooService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class FooController {

	@Autowired
	private FooService service;

	@GetMapping(path = "/foo")
	public Flux<Foo> getFlux(@RequestParam(required = true, defaultValue = "20") Integer count) {
		List<Foo> foos = service.getFoo(count);
		Flux<Foo> fluxFoos = Flux.fromIterable(foos).delayElements(Duration.ofSeconds(1)).log();
		return fluxFoos;
	}
}