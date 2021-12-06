package tn.iit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tn.iit.entity.Client;

@Repository
public class ClientDaoJPA {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(Client client) {
		em.persist(client);
	}

	// sa or 1=1--
	public List<Client> getAll() {
		return em.createNamedQuery("all-client", Client.class).getResultList();
	}
	public int getCount() {
		return em.createNamedQuery("count-client", Client.class).getFirstResult();
	}

	public Client findById(String cin) {
		return em.find(Client.class, cin);
	}

	@Transactional
	public void delete(Client client) {
		em.remove(client);
	}

	@Transactional
	public void delete(String cin) {
		em.remove(findById(cin));
	}

	@Transactional
	public void update(Client client) {
		em.merge(client);
	}

}
