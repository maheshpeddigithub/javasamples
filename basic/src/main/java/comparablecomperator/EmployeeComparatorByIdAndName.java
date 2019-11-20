package comparablecomperator;

import java.util.Comparator;

public class EmployeeComparatorByIdAndName implements Comparator<Employee> {


    public int compare(Employee o1, Employee o2) {
        int status = o1.getId() - o2.getId();
        if (status == 0) status = o1.getName().compareTo(o2.getName());
        return status;
    }
}