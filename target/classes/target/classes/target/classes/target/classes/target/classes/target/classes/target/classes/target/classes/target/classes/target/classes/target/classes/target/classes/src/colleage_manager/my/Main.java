package colleage_manager.my;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import colleage_manager.my.model.Student;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Todo t");
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
