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

import com.app.entities.Aarti;
import com.app.entities.AartiType;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false) 
public class AartiEntityDaoTest 
{
	
	@Autowired
	private AartiDao aartiRepo;
	
	@Test
	void testAddAarti()
	{
		List<Aarti> list = List.of(
				new Aarti(LocalDate.parse("2024-03-12"),AartiType.KAKADARTI,2,1000.00,"Swapnil More","146372983563"),
				new Aarti(LocalDate.parse("2024-03-12"),AartiType.DHUPARTI,1,500.00,"Subodh Mohite","146372983562"));
		
		
		
		List<Aarti>list2 = aartiRepo.saveAll(list);
		assertEquals(2, list2.size());
	}
	
}




