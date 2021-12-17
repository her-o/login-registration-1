package arg.hero.loginAndRegistration.serviceimpl;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import arg.hero.loginAndRegistration.entity.AppUser;
import arg.hero.loginAndRegistration.repository.UserRepository;
import arg.hero.loginAndRegistration.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public List<AppUser> findAll(){
		
		return userRepository.findAll();
		
	}
	
	@Override
	public AppUser save(AppUser user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}


}
