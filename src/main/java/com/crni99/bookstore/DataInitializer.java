package com.crni99.bookstore;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.crni99.bookstore.model.Authority;
import com.crni99.bookstore.model.User;
import com.crni99.bookstore.repository.AuthorityRepository;
import com.crni99.bookstore.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	private final AuthorityRepository authorityRepository;

	public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthorityRepository authorityRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authorityRepository = authorityRepository;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		String username = "admin2";
		String rawPassword = "admin123";

		
		
		if (userRepository.findByUsername(username) == null) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(rawPassword));
			user.setRole("ADMIN"); // DB'de role kolonunu da doldurur
			userRepository.save(user);

			
			
			
			
			
			// Authority kaydını ekle
			Authority authority = new Authority();
			authority.setUsername(username);
			authority.setAuthority("ROLE_ADMIN");
			authorityRepository.save(authority);

			System.out.println("Admin user and authority created.");
		} else {
			System.out.println("Admin user already exists.");
		}
	}

}
