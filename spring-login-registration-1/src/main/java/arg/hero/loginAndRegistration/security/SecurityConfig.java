package arg.hero.loginAndRegistration.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AppUserDetailsService appUserDetailsService;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
		    .csrf().disable()
		    .authorizeRequests()
			.antMatchers(
				"/registerUser",
				"/js/**",
				"/css/**",
				"/img/**")
				.permitAll()
		    .and()
		    .formLogin()
		    .loginPage("/login").permitAll()
		    .defaultSuccessUrl("/login?success", true);

		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(appUserDetailsService);
		dao.setPasswordEncoder(passwordEncoder);
		return dao;
	}
	
	
}
	
	

