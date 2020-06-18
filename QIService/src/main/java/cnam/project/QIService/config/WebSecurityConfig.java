package cnam.project.QIService.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import cnam.project.QIService.repository.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import cnam.project.QIService.entities.*;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/**")
	        .authorizeRequests()
	        .antMatchers("/", "/login**", "/js/**", "/error**", "/images/**").permitAll()
	        .anyRequest().authenticated()
	        .and().logout().logoutSuccessUrl("/").permitAll()
	        .and()
          .csrf().disable();
	}

	@Bean
	public PrincipalExtractor principalExtractor(UserRepository userRepo) {
		
		return map -> {
			String id = (String) map.get("sub");

			User user = userRepo.findById(id).orElseGet(() -> {
				User newUser = new User();
				
				newUser.setId(id);
				newUser.setGivenName((String) map.get("given_name"));
				newUser.setFamilyName((String) map.get("family_name"));
				newUser.setEmail((String) map.get("email"));
				if(newUser.getEmail().equals("mariakazakova795@gmail.com")) {
					newUser.setRole(Role.ADMIN);
				}
				newUser.setRole(Role.STUDENT);
				return newUser;
			});
			return userRepo.save(user);
		};
	}
}


