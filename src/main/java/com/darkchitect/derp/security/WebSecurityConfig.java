package com.darkchitect.derp.security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.darkchitect.derp.security.auth.RestAuthenticationEntryPoint;
import com.darkchitect.derp.security.auth.TokenAuthenticationFilter;
import com.darkchitect.derp.service.UserService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		  @Bean
		    public PasswordEncoder passwordEncoder() {
		        return new BCryptPasswordEncoder();
		    }

		    @Autowired
		    private UserService jwtUserDetailsService;

		    @Autowired
		    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

		    @Bean
		    @Override
		    public AuthenticationManager authenticationManagerBean() throws Exception {
		        return super.authenticationManagerBean();
		    }

		    @Autowired
		    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
		        auth.userDetailsService( jwtUserDetailsService )
		            .passwordEncoder( passwordEncoder() );
		    }

		    @Autowired
		    TokenHelper tokenHelper;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
		
			 List<RequestMatcher> csrfMethods = new ArrayList<>();
			Arrays.asList( "POST", "PUT", "PATCH", "DELETE" )
            .forEach( method -> csrfMethods.add( new AntPathRequestMatcher( "/**", method ) ) );
    http
            .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()
            .exceptionHandling().authenticationEntryPoint( restAuthenticationEntryPoint ).and()
            .authorizeRequests()
            .antMatchers(
                    HttpMethod.GET,
                    "/",
                    "/webjars/**",
                    "/*.html",
                    "/favicon.ico",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js"
            ).permitAll()
            .antMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated().and()
            .addFilterBefore(new TokenAuthenticationFilter(tokenHelper, jwtUserDetailsService), BasicAuthenticationFilter.class);

    			http.csrf().disable();
		}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        // TokenAuthenticationFilter will ignore the below paths
        web.ignoring().antMatchers(
                HttpMethod.POST,
                "/api/auth/**"
        );
        
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources",
				"/configuration/security", "/swagger-ui.html", "/webjars/**", "/v2/swagger.json");
        
        web.ignoring().antMatchers(
                HttpMethod.GET,
                "/",
                "/webjars/**",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js"
            );

    }
}