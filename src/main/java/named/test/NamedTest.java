package named.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpaquery.entity.Example;

import java.util.List;

public class NamedTest {

    public static void main(String[] args) {

        double exampleValueMin = 200;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        TypedQuery<Example> query = entityManager.createNamedQuery("Example.findGreater", Example.class);
        query.setParameter("exampleValueMin",exampleValueMin);
        List<Example> exampleList = query.getResultList();

        entityManager.close();

        for (Example example : exampleList) {

            System.out.println(example.getExampleId() + " " + example.getExampleName() + " " + example.getExampleValue());
        }

    }

}
