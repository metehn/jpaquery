package bulk.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jpaquery.entity.Example;

public class BulkUpdate {

    public static void main(String[] args) {

        String namePrefix = "En ";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();


        entityManager.getTransaction().begin();

        String jpql = "update Example as example "
                +" set example.exampleName = CONCAT( :namePrefix, example.exampleName ) ";

        Query query = entityManager.createQuery(jpql);
        query.setParameter("namePrefix", namePrefix);

        int affected = query.executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();
        System.out.println("Etkilenen: " + affected);

    }

}
