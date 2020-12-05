package colleage_manager.my;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import colleage_manager.my.model.User;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
    private static EntityManagerFactory factory;

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        // 사용자 데이터 생성
        User newUser = new User();
        newUser.setId("1");
        newUser.setName("juliana");
        
        User newUser2 = new User();
        newUser.setId("2");
        newUser.setName("braden");
        
        // 트랜잭션 시작 & DB로 커밋
        EntityTransaction transaction = em.getTransaction();
        transaction.begin(); 
        em.persist(newUser);
        transaction.commit(); 

        em.getTransaction().begin();
        em.persist(newUser2);
        em.getTransaction().commit();
        
        // DB에서 사용자 읽기
        Query q = em.createQuery("select t from User t");
        List<User> userList = q.getResultList();
        
        for (User todo : userList) {
            System.out.println(todo.toString());
        }
        System.out.println("Size: " + userList.size());
        em.close();
    }
}
