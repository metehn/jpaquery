package bulk.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BulkDelete {

    public static void main(String[] args) {

        String namePrefix = "En ";
        String namePattern = "%Gün%";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();


        entityManager.getTransaction().begin();

        String jpql = "delete Example as example "
                + " where example.exampleName LIKE :namePattern";

        Query query = entityManager.createQuery(jpql);
        //query.setParameter("namePrefix", namePrefix);
        query.setParameter("namePattern", namePattern);

        int affected = query.executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();
        System.out.println("Etkilenen: " + affected);

    }

}
