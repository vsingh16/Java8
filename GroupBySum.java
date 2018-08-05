import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vishal on 05-Aug-18.
 */
public class GroupBySum {

    static class Employee {

        private Double salary;
        private String dept;

        public Employee(Double salary, String dept) {
            this.salary = salary;
            this.dept = dept;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(100.0, "IT");
        Employee e2 = new Employee(200.0, "IT");

        Employee e3 = new Employee(100.0, "TECH");
        Employee e4 = new Employee(200.0, "MANAGEMENT");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        employeeList.stream()
                .filter(e -> e.getDept().equals("IT") || e.getDept().equals("TECH"))
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.summingDouble(Employee::getSalary)))
                .entrySet().forEach(System.out::println);


    }
}
