package collectionsystem.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("collection");
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	} 
	
}