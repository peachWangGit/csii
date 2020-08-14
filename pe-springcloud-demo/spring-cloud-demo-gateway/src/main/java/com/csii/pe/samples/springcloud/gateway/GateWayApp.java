package com.csii.pe.samples.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

import com.csii.pe.samples.springcloud.service.ServiceCongiguration;

@SpringBootApplication
@EnableDiscoveryClient
@Import({ServiceCongiguration.class})
@ImportResource({"classpath:/META-INF/config/*.xml","classpath:/META-INF/gateway/*.xml"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class GateWayApp {
	public static void main(String[] args) {
		SpringApplication.run(GateWayApp.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	RestTransport restTransport(){
		return new RestTransport();
	}
}
