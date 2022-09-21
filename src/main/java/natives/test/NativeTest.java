package natives.test;

import jakarta.persistence.*;
import jpaquery.entity.Example;

import java.util.List;

public class NativeTest {

    public static void main(String[] args) {

        double exampleValueMin = 200;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql = "select * from Example where exampleValue > ?";

        Query query = entityManager.createNativeQuery(jpql, Example.class);
        query.setParameter(1, exampleValueMin);
        List<Example> exampleList = query.getResultList();

        entityManager.close();

        for (Example example : exampleList) {

            System.out.println(example.getExampleId() + " " + example.getExampleName() + " " + example.getExampleValue());
        }

    }

}
