package arg.hero.loginAndRegistration.service;

import java.util.Optional;

import arg.hero.loginAndRegistration.entity.AppUser;

public interface IUserService {
	
	Optional<AppUser> findByUsername(String username);
	boolean usernameExists(String username);
	boolean emailExists(String email);

}
