package jpaquery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Example.findAll",
        query = "select example from Example as example")
@NamedQuery(name = "Example.findGreater",
        query = "select example from Example as example where example.exampleValue > :exampleValueMin")
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exampleId;
    private String exampleName;
    private double exampleValue;

}
