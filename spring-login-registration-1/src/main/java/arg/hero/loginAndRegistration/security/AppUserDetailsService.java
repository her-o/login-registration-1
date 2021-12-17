package arg.hero.loginAndRegistration.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import arg.hero.loginAndRegistration.entity.AppUser;
import arg.hero.loginAndRegistration.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			
			AppUser user = repository.findByUsername(username).get();
			UserBuilder builder = User
									.withUsername(user.getUsername())
									.password(user.getPassword())
									.disabled(false)
									.authorities(user.getRoles()
														.stream()
														.map(role -> new SimpleGrantedAuthority(role))
														.collect(Collectors.toList()));
			
			System.out.println(user.toString());
									
			return builder.build();
			
			
		} catch(Exception e) {
			
			System.out.println("error");
			throw new UsernameNotFoundException("Username not found");
			
		}
	
	}

}
