package P23ObjectsAndClasses_More_Exercises.P01CompanyRoster;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

public class Department {
    private List<Employee> departmentList;

    public Department(List<Employee> departmentList) {
        this.departmentList = departmentList;
    }

    public void add (Employee employee) {
        this.departmentList.add(employee);
    }

    public Employee getEmployee (List<Employee> departmentList) {
        for (Employee employee : departmentList) {
            return employee;
        }
        return null;
    }

    public int getCount () {
        return departmentList.size();
    }

    @Override
    public String toString() {
        String output = "";
        DecimalFormat df = new DecimalFormat("0.00");
        departmentList.sort(Comparator.comparing(Employee::getSalary).reversed());
        for (Employee employee : departmentList) {
            output += employee.getName() + " " + df.format(employee.getSalary()) + " " + employee.getEmail() + " " + employee.getAge() + "\n";
        }
        return output;
    }
}
