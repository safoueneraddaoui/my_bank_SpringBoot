package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Client;

@Repository
public interface ClientDaoSpringData extends JpaRepository<Client, String> {
	
	@Query("select count(cl) from Client cl") int
	 getCount();
}
