package com.sbs.weather.app;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import com.sbs.weather.app.props.GlobalProperties;
@EnableCaching
@SpringBootApplication
@ConfigurationProperties
public class WeatherServiceApplication implements CommandLineRunner {
	Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	private GlobalProperties globalProperties;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WeatherServiceApplication.class);
		app.setLazyInitialization(true);
		app.run(args);
//		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println(globalProperties);
		try {
			logger.info("IP:{}",Inet4Address.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
