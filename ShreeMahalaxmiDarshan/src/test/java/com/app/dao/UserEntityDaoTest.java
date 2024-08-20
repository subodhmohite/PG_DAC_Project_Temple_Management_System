package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Gender;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserEntityDaoTest {
	
	// dep
	@Autowired
	private UserEntityDao userRepo;

	@Autowired
	private PasswordEncoder enc;

	@Test
	void testAddUsers() {

		List<UserEntity> list = List.of(
				new UserEntity("Subodh", "Mohite", "subodh@gmail.com", enc.encode("subodh"),"8450948899", UserRole.ROLE_ADMIN,LocalDate.parse("2001-09-13"),Gender.MALE,"123456789012"));

		List<UserEntity> list2 = userRepo.saveAll(list);
		assertEquals(1, list2.size());


	}

}
