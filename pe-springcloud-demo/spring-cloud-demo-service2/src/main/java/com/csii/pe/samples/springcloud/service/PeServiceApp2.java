package com.csii.pe.samples.springcloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource({"classpath:/META-INF/config/*.xml","classpath:/META-INF/service/*.xml"})
@EnableEurekaClient
@Import({ServiceCongiguration.class})
public class PeServiceApp2 {

	public static void main(String[] args) {
		SpringApplication.run(PeServiceApp2.class, args);
	}
}
