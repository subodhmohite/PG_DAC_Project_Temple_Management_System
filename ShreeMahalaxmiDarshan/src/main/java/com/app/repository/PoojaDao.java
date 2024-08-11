
  package com.app.repository;
  
  import java.time.LocalDate;
  import java.util.List;
  import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Pooja; import com.app.entities.PoojaType;
  
  
  public interface PoojaDao extends JpaRepository<Pooja, Long> {
	  
	  List<Pooja> findUserById(Long userId);
	  
	  List<Pooja> findByPoojaDateAndPoojaType(LocalDate poojaDate,PoojaType poojaType);
	  
	  @Query("SELECT p.poojaDate FROM Pooja p GROUP BY p.poojaDate HAVING SUM(p.noOfPerson) >= 4 ")
	  List<LocalDate> findAllBookedDatesByNoOfPerson();
	  
	  @Query("SELECT p.poojaType FROM Pooja p WHERE p.poojaDate = :poojaDate GROUP BY p.poojaType HAVING SUM(p.noOfPerson) >= 4")
	  List<PoojaType> findPoojaTypeByDate(LocalDate poojaDate);
	  
	  
		
  
  }
 