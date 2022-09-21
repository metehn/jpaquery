package jpaquery.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String employeeName;
    private double monthlySalary;
    @ManyToOne(fetch = FetchType.EAGER) // varsayılan olarak FetchType.LAZY, gerekmedikçe getirme anlamındadır
    @JoinColumn(name = "departmentId") // bunu yazmazsak kendi bir isim verecek
    private Department department;

    public Employee(long employeeId, String employeeName, double monthlySalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.monthlySalary = monthlySalary;
    }
}
