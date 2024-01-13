package com.Ligado.nbiot_iffe_inventory.configure;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth
{
	
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:10005"));
//		configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}	
	
	
//	@Bean
//	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//		http
//			// ...
//			.cors(cors -> cors.disable());
//		return http.build();
//	}	
	
//	 @Bean
//	  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//	    http
//	        .csrf().disable()
//	        .authorizeHttpRequests((requests) -> requests
//	            .requestMatchers(HttpMethod.OPTIONS).permitAll() // allow CORS option calls for Swagger UI
//	            .requestMatchers("/openapi/openapi.yml").permitAll()
//	            .anyRequest().authenticated())
//	        .httpBasic();
//	    return http.build();
//	  }	
	
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		return http.authorizeHttpRequests(
//					auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//					.anyRequest().authenticated()
//				)
//				.httpBasic(Customizer.withDefaults())
//				.sessionManagement(
//						session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.csrf().disable()
//				.build();
//		
//	}
	
	
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable()	
//		.authorizeRequests()
//		.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//				.anyRequest().authenticated()
//				.and()
//			//.formLogin().and()
//			.httpBasic();
//	}
}

