package jpaquery.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpaquery.entity.Example;

public class ExamplePersist {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Example example1 = new Example(0, "Örnek 1", 111.11);
        Example example2 = new Example(0, "Örnek 2", 221.312);
        Example example3 = new Example(0, "Örnek 3", 33221.125);


        entityManager.getTransaction().begin();

        entityManager.persist(example1);
        entityManager.persist(example2);
        entityManager.persist(example3);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
