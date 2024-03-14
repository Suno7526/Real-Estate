package com.example.estate.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.estate.config.auth.auth.PrincipalDetailService;


@Configuration
public class SecurityConfig {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public	 BCryptPasswordEncoder encodePWD() {
		String encPassword = new BCryptPasswordEncoder().encode("1234");
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorizeRequest ->
                    authorizeRequest
                            .requestMatchers(
                                    AntPathRequestMatcher.antMatcher("/**")
                            ).permitAll()
                            .anyRequest().authenticated()
            ).formLogin(login -> login
            		.loginPage("http://localhost:3000/UserLogin")
            		.defaultSuccessUrl("http://localhost:3000/Home"));
        return http.build();
    }

}