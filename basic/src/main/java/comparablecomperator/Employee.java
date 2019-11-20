package comparablecomperator;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private int id;
    private double salary;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Employee o) {
        return (this.id - o.id);
    }

    public static Comparator<Employee> salaryComparator = new Comparator<Employee>() {
        public int compare(Employee o1, Employee o2) {
            return (int) (o1.salary - o2.salary);
        }
    };

    public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
        public int compare(Employee o1, Employee o2) {
            return (o1.getName().compareTo(o2.getName()));
        }
    };

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee(int id, double salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }
}