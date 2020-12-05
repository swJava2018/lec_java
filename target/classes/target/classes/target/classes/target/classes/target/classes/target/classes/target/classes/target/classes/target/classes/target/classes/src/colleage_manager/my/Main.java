package colleage_manager.my;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import colleage_manager.my.model.Student;
import colleage_manager.my.model.User;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        User newUser = new User();
        newUser.setId("1");
        newUser.setName("Test.Mr");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin(); // 트랜잭션 시작
        em.persist(newUser);
        em.persist(newUser);
        // 이때까지 INSERT SQL을 데이터베이스에 보내지 않는다.
        // 커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
        transaction.commit(); // 트랜잭션 커밋


        출처: https://ict-nroo.tistory.com/130 [개발자의 기록습관]
        	
        	
        // read the existing entries and write to console
        Query q = em.createQuery("select t from User t");
        List<Student> todoList = q.getResultList();
        for (Student todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        Student todo = new Student();
        todo.setAddress("This is a test");
        todo.setId("This is a test");
        em.persist(todo);
        em.getTransaction().commit();

        em.close();
    }
}
