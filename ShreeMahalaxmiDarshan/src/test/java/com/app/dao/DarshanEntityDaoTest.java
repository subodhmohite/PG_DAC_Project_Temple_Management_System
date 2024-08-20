package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Darshan;
import com.app.entities.TimeEnum;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DarshanEntityDaoTest {

		@Autowired
		private DarshanDao darshanDao;

		

		@Test
		void testAddDarshan() {

			List<Darshan> list = List.of(
					new Darshan(LocalDate.parse("2024-03-10"), TimeEnum.SIX_AM, 3, 600.0f,"Subodh", "146372983563"),
					new Darshan(LocalDate.parse("2024-03-12"), TimeEnum.EIGHT_AM, 3, 600.0f,"Mohite", "146372983562"),
					new Darshan(LocalDate.parse("2024-03-15"), TimeEnum.SIX_PM, 2, 400.0f,"Swapnil", "146372983567"));

			List<Darshan> list2 = darshanDao.saveAll(list);
			assertEquals(3, list2.size());


		}

}
