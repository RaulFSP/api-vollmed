package io.github.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain sfc(HttpSecurity hs) throws Exception {
		return hs.csrf((cs) -> cs.disable()).sessionManagement((sm) -> {
			sm.sessionConcurrency(
					(sc) -> sc.maximumSessions(1).expiredUrl("/login?expired"));
			sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}).authorizeHttpRequests(
				(au) -> au.requestMatchers(HttpMethod.GET, "/pacientes/**")
						.permitAll().anyRequest().authenticated())
				.build();
	}
}
