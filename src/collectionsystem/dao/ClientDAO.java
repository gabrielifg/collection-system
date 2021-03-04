package collectionsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import collectionsystem.entities.Client;
import collectionsystem.jpa.util.JPAUtil;

public class ClientDAO {
	private JPAUtil jpaUtil;
	private EntityManager em;

	public ClientDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void save(Client client) {
		em.getTransaction().begin();
		Client existing = get(client.getCnpj());
		if(existing == null) {
			em.persist(client);
		} else {
			existing.setCnpj(client.getCnpj());
			existing.setName(client.getName());
			existing.setNameFantasy(client.getNameFantasy());
			existing.setCep(client.getCep());
			existing.setPublicPlace(client.getPublicPlace());
			existing.setNumber(client.getNumber());
			existing.setComplement(client.getComplement());
			existing.setUf(client.getUf());
			existing.setCounty(client.getCounty());
			em.persist(existing);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Client client) {
		em.getTransaction().begin();
		client = em.find(Client.class, client.getCnpj());
		em.remove(client);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Client> lista(){
		TypedQuery<Client> qry = em.createQuery("from Client", Client.class);
		return qry.getResultList();
	}
	
	public Client getClient(String id) {
		return em.find(Client.class, id);
	}
	public Client get(String cnpj) {
		return em.find(Client.class, cnpj);
	}
}
