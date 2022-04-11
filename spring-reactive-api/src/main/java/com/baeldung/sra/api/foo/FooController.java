package com.baeldung.sra.api.foo;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class FooController {


	@GetMapping(path = "/foo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	  Flux<String> sseFlux() {
	    return Flux.interval(Duration.ofSeconds(1))
	        .map(aLong -> String.format("id:%d name:%s", aLong, RandomStringUtils.randomAlphabetic(7)));
	  }	
	
}