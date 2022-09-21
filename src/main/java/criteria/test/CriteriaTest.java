package criteria.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jpaquery.entity.Example;

import java.util.List;

public class CriteriaTest {

    public static void main(String[] args) {

        double exampleValueMin = 200;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Example> criteria = builder.createQuery(Example.class);
        Root<Example> root = criteria.from(Example.class);
        Predicate condition = builder.gt(root.get("exampleValue"), exampleValueMin);
        criteria.where(condition);

        TypedQuery<Example> query = entityManager.createQuery(criteria);
        List<Example> exampleList = query.getResultList();

        entityManager.close();

        for (Example example : exampleList) {

            System.out.println(example.getExampleId() + " " + example.getExampleName() + " " + example.getExampleValue());
        }

    }
}
