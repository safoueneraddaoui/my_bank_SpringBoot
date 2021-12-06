package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Compte;

@Repository
public interface CompteDaoSpringData extends JpaRepository<Compte, Long> {
	Compte findByClientCin(String string);
	@Query("select count(c) from Compte c") int getCount();
	@Query("select sum(solde) from Compte c") float getSum();
	@Query("select max(solde) from Compte c") float getTop();
	
}
