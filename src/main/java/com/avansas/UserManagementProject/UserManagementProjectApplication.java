package com.avansas.UserManagementProject;

import com.avansas.UserManagementProject.dao.repo.UserRepository;
import com.avansas.UserManagementProject.model.entity.UserEntity;
import com.avansas.UserManagementProject.model.entity.UserInformationEntity;
import com.avansas.UserManagementProject.model.enums.UserRole;
import com.avansas.UserManagementProject.security.jwt.JwtConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.avansas.UserManagementProject.dao.repo")
@EnableConfigurationProperties(JwtConfig.class)
public class UserManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
            UserRepository userRepository,
			PasswordEncoder passwordEncoder
	) {

		return args -> {

			UserEntity admin = new UserEntity(
					"admin",
					passwordEncoder.encode("password"),
					UserRole.ADMIN,
					new UserInformationEntity(
							"admin", "admin", "admin@gmail.com", "5454545454", "1999-12-31"
					));
			userRepository.save(admin);

			UserEntity haluk = new UserEntity(
					"halukerd",
					passwordEncoder.encode("123qwe"),
					UserRole.REGULAR_USER,
					new UserInformationEntity(
							"haluk", "erd", "erd.haluk@gmail.com", "5454545454", "1999-12-31"
					));
			userRepository.save(haluk);

			UserEntity melike = new UserEntity(
					"melike",
					passwordEncoder.encode("a"),
					UserRole.REGULAR_USER,
					new UserInformationEntity(
							"melike", "erd", "erd.melike@gmail.com", "5454545454", "1999-12-31"
					));
			userRepository.save(melike);
		};
	}
}