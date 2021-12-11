package arg.hero.loginAndRegistration.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arg.hero.loginAndRegistration.entity.AppUser;
import arg.hero.loginAndRegistration.repository.UserRepository;
import arg.hero.loginAndRegistration.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<AppUser> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public boolean usernameExists(String username) {
		return userRepository.usernameExists(username);
	}

	@Override
	public boolean emailExists(String email) {
		return userRepository.emailExists(email);
	}

	

}
