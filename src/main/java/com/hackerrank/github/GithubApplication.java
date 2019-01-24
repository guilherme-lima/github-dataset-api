package com.hackerrank.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class GithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubApplication.class, args);
	}

	@PostConstruct
	private void setTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}