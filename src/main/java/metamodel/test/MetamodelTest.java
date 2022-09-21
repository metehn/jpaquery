package metamodel.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import jakarta.persistence.metamodel.SingularAttribute;
import jpaquery.entity.Example;


public class MetamodelTest {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Metamodel metamodel = entityManager.getMetamodel();
        EntityType<Example> example = metamodel.entity(Example.class);

        for (Attribute attribute : example.getAttributes()) {

            if (attribute instanceof SingularAttribute) {

                System.out.println(attribute.getName() + " " + attribute.getJavaType());
            }
        }

        entityManager.close();


    }

}
