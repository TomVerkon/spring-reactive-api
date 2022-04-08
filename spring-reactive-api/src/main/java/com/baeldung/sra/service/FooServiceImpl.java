package com.baeldung.sra.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService {

	// Thread safe generators
	private int generateRandomInt() {
		Random random = new Random();
		return random.nextInt(20000 - 1) + 1;
	}

	private String generateRandomName() {
		return RandomStringUtils.randomAlphabetic(7);
	}

	@Override
	public List<Foo> getFoo(int fooCount) {
		List<Foo> foos = new ArrayList<Foo>();
		for (int i = 0; i < fooCount; i++ ) {
			foos.add(new Foo(generateRandomInt(), generateRandomName()));
		}
		return foos;
	}

}
