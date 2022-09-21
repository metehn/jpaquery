package criteria.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jpaquery.entity.Department;
import jpaquery.entity.Employee;

import java.util.List;

public class CriteriaRelation {


    public static void main(String[] args) {

        double monthlySalary = 10000;
        String departmentName = "%Yaz%";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        Join<Employee, Department> relation = root.join( "department");

        Predicate conditionSalary = builder.lt(root.get("monthlySalary"), monthlySalary);
        Predicate conditionDepartment = builder.like(relation.get("departmentName"), departmentName);
        Predicate condition = builder.and(conditionSalary, conditionDepartment);

        criteria.where(condition);

        TypedQuery<Employee> query = entityManager.createQuery(criteria);
        List<Employee> employeeList = query.getResultList();

        entityManager.close();

        for (Employee employee : employeeList) {

            System.out.println(employee.getEmployeeId() + " " + employee.getEmployeeName() + " " + employee.getMonthlySalary() + " " + employee.getDepartment().getDepartmentName());
        }

    }

}
