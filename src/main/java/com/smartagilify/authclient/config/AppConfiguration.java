package com.smartagilify.authclient.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	@Bean
	public RouteLocator gateway(RouteLocatorBuilder rlb){
		return rlb
				.routes()
				.route(request -> request.path("/data")
						.filters(GatewayFilterSpec::tokenRelay)
						.uri("http://localhost:8081/data"))
				.build();
	}
}
