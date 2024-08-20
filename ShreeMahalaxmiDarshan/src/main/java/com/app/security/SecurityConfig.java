package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity//to enable spring sec frmwork support
@Configuration //to tell SC , this is config class containing @Bean methods
@EnableGlobalMethodSecurity(prePostEnabled = true)
//To enable method level authorization support : pre n post authorization
public class SecurityConfig {
	//dep : pwd encoder
	@Autowired
	private PasswordEncoder enc;
	//dep : custom jwt auth filter
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	//dep : custom auth entry point
	@Autowired
	private CustomAuthenticationEntryPoint authEntry;
	
	
	@Bean
	public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception
	{
		//URL based authorization rules
		http.cors().
		configurationSource(request->
		{
		 CorsConfiguration corsConfig=new CorsConfiguration();
		 corsConfig.addAllowedOrigin("http://localhost:3000");
		 corsConfig.addAllowedMethod("*");
		 corsConfig.addAllowedHeader("*");
		 return corsConfig;
		})
		.and().
		//disable CSRF token generation n verification
		csrf()	.disable()
		.exceptionHandling().authenticationEntryPoint(authEntry).
		and().
		authorizeRequests()

		.antMatchers("/darshan","/users/signup","/users/signin","/pooja","/accommodation","/aarti",
				"/v*/api-doc*/**","/swagger-ui/**").permitAll()
		// only required for JS clnts (react / angular) : for the pre flight requests
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.antMatchers("/user/my-profile","/user/my-profile/update-user","/user/change-password","/user/my-profile/address/**"
				,"/user/darshan/add","/user/darshan/","/user/darshan/{darshanId}","/user/darshan/booked-dates","/user/darshan/booked-timeslots/{date}"
				,"/user/pooja/add","/user/pooja/","/user/pooja/{poojaId}","/user/pooja/get-booked-type/{date}","/user/pooja/get-booked-dates"
				,"/user/aarti/add","/user/aarti/","/user/aarti/{aartiId}"
				,"/accommodation/add","/accommodation/","/accommodation/{accommodationId}","/accommodation/booked-dates").hasRole("USER")  
		.antMatchers("/admin/all-users","/admin/all-users/{userId}","/admin/all-accommodation","/admin/all-dashan","/admin/all-aarti","/admin/all-pooja"
				,"/pooja/get-booked-type/{date}","/pooja/get-booked-dates","/darshan/booked-timeslots/{date}","/darshan/booked-dates").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		//to tell spring sec : not to use HttpSession to store user's auth details
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).
		and()
		//inserting jwt filter before sec filter
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	
		return http.build();
	}
	//configure AuthMgr as a spring bean
	@Bean
	public AuthenticationManager authenticationManager
	(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}
}
