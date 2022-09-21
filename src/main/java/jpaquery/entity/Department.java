package jpaquery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;
    private String departmentName;
    @OneToMany( mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //default= lazy. employee liste get dediğimizde getiriyor. EAGER olması her zaman için iyi değil performans kaybı yapabilir
    private List<Employee> employeeList = new ArrayList<>();

    public Department(long departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
}
