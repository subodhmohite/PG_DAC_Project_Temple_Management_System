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

import com.app.entities.Pooja;
import com.app.entities.PoojaType;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PoojaEntityDaoTest 
{

	@Autowired
	private PoojaDao poojaDao;
	
	@Test
	void testAddPooja()
	{
		List<Pooja> list = List.of(
				new Pooja(LocalDate.parse("2024-03-10"),2, 400.0f,PoojaType.MAHAPOOJA, "Subodh", "146372983563"),
				new Pooja(LocalDate.parse("2024-03-12"), 1, 200.0f,PoojaType.ALANKARPOOJA, "Swapnil", "146372983562"));

		List<Pooja> list2 = poojaDao.saveAll(list);
		assertEquals(2, list2.size());
	}
	
}
