package com.lec.my.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lec.my.model.User;

public class UserAPI {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private EntityManager em = factory.createEntityManager();
	
	public int register(String userNumber, String pwd, String role) {
		boolean isSuccess = true;
		
		// check 학번
		// insert
		try {
			User user = new User();
			user.setId("202102101");
			user.setName("홍길동");
			
			EntityTransaction transaction = em.getTransaction();
	        transaction.begin(); 
	        em.persist(user);
	        transaction.commit(); 
	        
//	        em.createNativeQuery("INSERT INTO User (id, name) VALUES (?,?)")
//	        	.setParameter(1, "202102101")
//	        	.setParameter(2, "홍길동")
//	        	.executeUpdate();
	        
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			em.close();
			if (isSuccess == false)
				return -1;
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public int login(String userNumber, String pwd) {
		
		Query query = em.createQuery("select t from User t where id = " + userNumber + "and password = " + pwd);
        List<User> resultList = query.getResultList();
        
        if(resultList.size() == 1)
        	return 0;
        else 
        	return -1;
	}
	
	public int update() {
		return -1;
	}
}
