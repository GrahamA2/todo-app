package io.schultz.dustin.todoapp.security;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration(proxyBeanMethods = false)
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity  http) throws Exception {
		http.requestMatcher(EndpointRequest.toAnyEndpoint().excluding("health"))
		.authorizeRequests( (req) -> req.anyRequest().hasRole("ADMIN"));
		http.httpBasic();
	}
}
