package arg.hero.loginAndRegistration.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import arg.hero.loginAndRegistration.entity.AppUser;
import arg.hero.loginAndRegistration.repository.UserRepository;
import arg.hero.loginAndRegistration.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<AppUser> findAll(){
		
		return userRepository.findAll();
		
	}
	
	@Override
	public AppUser save(AppUser user) {
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser user = userRepository.findByUsername(username).get();
		UserDetails userDetails = User
									.withUsername(user.getUsername())
									.password(passwordEncoder.encode(user.getPassword()))
									.authorities("USER")
									.build();
										
		return userDetails;
	}	

}
