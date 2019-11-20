package comparablecomperator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class EmployeeTest {

    private Employee[] empArray = new Employee[4];
    private List<Employee> emps = new ArrayList<Employee>();

    @Before
    public void setUp() {
        Employee employee1 = new Employee(2, 3, "e3");
        Employee employee2 = new Employee(1, 4, "e4");
        Employee employee3 = new Employee(3, 1, "e2");
        Employee employee4 = new Employee(4, 2, "e1");

        empArray[0] = employee1;
        empArray[1] = employee2;
        empArray[2] = employee3;
        empArray[3] = employee4;

        emps.add(employee1);
        emps.add(employee2);
        emps.add(employee3);
        emps.add(employee4);
    }

    @Test
    public void testArraysSortComparable() {
        Arrays.sort(empArray);
        assertThat(empArray[0].getId(), is(equalTo(1)));
    }

    @Test
    public void testArraysSortSalaryComparator() {
        Arrays.sort(empArray, Employee.salaryComparator);
        assertThat((int) empArray[0].getSalary(), is(equalTo(1)));
    }

    @Test
    public void testArraysSortNameComparator() {
        Arrays.sort(empArray, Employee.nameComparator);
        assertThat(empArray[0].getName(), is("e1"));
    }

    @Test
    public void testArraysSortByIdAndName() {
        Arrays.sort(empArray, new EmployeeComparatorByIdAndName());
        assertThat(empArray[0].getName(), is("e4"));
    }

    @Test
    public void testListSortSalaryComparator() {
        Collections.sort(emps, Employee.salaryComparator);
        assertThat((int) emps.get(0).getSalary(), is(equalTo(1)));
    }

    @Test
    public void testListSortNameComparator() {
        Collections.sort(emps, Employee.nameComparator);
        assertThat(emps.get(0).getName(), is("e1"));
    }

    @Test
    public void testListSortByIdAndName() {
        Collections.sort(emps, new EmployeeComparatorByIdAndName());
        assertThat(emps.get(0).getName(), is("e4"));
    }

    @After
    public void tearDown() {
        empArray = null;
    }

}