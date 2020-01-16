package br.com.teste.eurekaclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	
	  private static final String[] AUTH_WHITELIST = {
	            // -- swagger ui
			  	"/actuator/**",
			  	"/api-docs/**",
	            "/v2/api-docs",
	            "/swagger-resources",
	            "/swagger-resources/**",
	            "/configuration/ui",
	            "/configuration/security",
	            "/swagger-ui.html",
	            "/webjars/**"
	            // other public endpoints of your API may be appended to this array
	    };
//	 @Resource(name = "userService")
//	    private UserDetailsService userDetailsService;
	 
	 	@Override
	 	@Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

//	    @Autowired
//	    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userDetailsService)
//	                .passwordEncoder(encoder());
//	    }

	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	                .csrf().disable()
//	                .anonymous().disable()
//	                .authorizeRequests()
////	                .antMatchers("/api-docs/**").permitAll();
//	                .antMatchers(AUTH_WHITELIST).permitAll()
//	    			.and().httpBasic()
//	    			.authenticationEntryPoint(authEntryPoint)
//	    	http.csrf()
//	    	.disable()
//	    	.authorizeRequests()
//	    	.antMatchers(AUTH_WHITELIST).permitAll()
//	    	.and().authorizeRequests()
////			.anyRequest().authenticated()
//	    	.antMatchers("/**").authenticated()
//			.and().httpBasic()
//			.authenticationEntryPoint(authEntryPoint)
	    	  http.authorizeRequests()
	            .antMatchers(AUTH_WHITELIST).permitAll()
//	            .anyRequest().authenticated()
//	            .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
	    	;
	    }

	    @Bean
	    public TokenStore tokenStore() {
	        return new InMemoryTokenStore();
	    }

	    @Bean
	    public BCryptPasswordEncoder encoder(){
	        return new BCryptPasswordEncoder();
	    }
//
//	    @Bean
//	    public FilterRegistrationBean corsFilter() {
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        config.setAllowCredentials(true);
//	        config.addAllowedOrigin("*");
//	        config.addAllowedHeader("*");
//	        config.addAllowedMethod("*");
//	        source.registerCorsConfiguration("/**", config);
//	        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//	        bean.setOrder(0);
//	        return bean;
//	    }
	    
//	    @Autowired
//		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//			auth.inMemoryAuthentication().withUser("john123").password("password").roles("USER");
//		}
	    
	    
//	    @Bean
//	    public WebMvcConfigurer corsConfigurer() {
//	    	return new WebMvcConfigurerAdapter() {
//	    		@Override
//	    		public void addCorsMappings(CorsRegistry registry) {
//	    			registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
//	    				.allowedHeaders("*");
//	    		}
//	    	};
//	    }
	    
	    
	    /**
	     * define the security algorithmo for password
	     *
	     * @param auth
	     * @throws Exception
	     */
//	    @Override
//	    protected void configure(final AuthenticationManagerBuilder auth)
//	        throws Exception {
//	      auth.userDetailsService(this.userService)
//	          .passwordEncoder(new BCryptPasswordEncoder());
//	    }
//	    @Bean
//	    public BCryptPasswordEncoder encoder() {
//	        return new BCryptPasswordEncoder();
//	    }
	    
	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication().withUser("john123").password("$2a$04$AjFEmZeX7mN8zSn57PUEZeJgBeoKMvwteZMBiP57Jb4AGFsUORmLC").roles("USER");
	        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	        auth.inMemoryAuthentication().withUser("act").password("act").roles("ACTUATOR");
	    }

}
