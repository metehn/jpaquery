package jpaquery.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Example.class)
public class Example_ {

    public static volatile SingularAttribute<Example, Long> exampleId;
    public static volatile SingularAttribute<Example, String> exampleName;
    public static volatile SingularAttribute<Example, Double> exampleValue;

}
