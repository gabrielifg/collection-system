package collectionsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import collectionsystem.entities.Service;
import collectionsystem.jpa.util.JPAUtil;

public class ServiceDAO {
	private JPAUtil jpaUtil;
	private EntityManager em;
	
	public ServiceDAO() {
		jpaUtil = new JPAUtil();
		em = JPAUtil.getEntityManager();
	}
	
	public void save(Service service) {
		em.getTransaction().begin();
		Service existence = getService(service.getId());
		if(existence == null) {
			em.persist(service);
		}else{
			existence.setName(service.getName());
			em.persist(existence);
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Service service) {
		em.getTransaction().begin();
		service = em.find(Service.class, service.getId());
		em.remove(service);
		em.getTransaction().commit();
		em.close();
	}
	
	public Service returnService(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Service serviceFound = new Service();
		serviceFound = em.find(Service.class, id);
		return serviceFound;
	}
	
	public List<Service> lista(){
		TypedQuery<Service> qry = em.createQuery("from Service", Service.class);
		return qry.getResultList();
	}
	
	
	public Service getService(long id) {
		return em.find(Service.class, id);
	}
}
