package P23ObjectsAndClasses_More_Exercises.P01CompanyRoster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numInputs = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 1; i <= numInputs; i++) {
            //Създаване на обект служител:
            String currentInput = scanner.nextLine();
            List<String> fieldsLength = Arrays.stream(currentInput.split(" ")).collect(Collectors.toList());
            String currentName = currentInput.split("\\s+")[0];
            double currentSalary = Double.parseDouble(currentInput.split("\\s+")[1]);
            String currentPosition = currentInput.split("\\s+")[2];
            String currentDepartment = currentInput.split("\\s+")[3];
            Employee employee = new Employee(currentName, currentSalary, currentPosition, currentDepartment, "n/a", -1);

             if (fieldsLength.size() == 5) {
                if (fieldsLength.get(4).contains("@")) {
                    String currentEmail = currentInput.split("\\s+")[4];
                    employee.setEmail(currentEmail);
                } else {
                    int currentAge = Integer.parseInt(currentInput.split("\\s+")[4]);
                    employee.setAge(currentAge);
                }
            } else if (fieldsLength.size() == 6) {
                String currentEmail = currentInput.split("\\s+")[4];
                int currentAge = Integer.parseInt(currentInput.split("\\s+")[5]);
                employee.setEmail(currentEmail);
                employee.setAge(currentAge);
            }
            employeeList.add(employee);
        }

        double currentSumSalary = 0;
        double maxSumSalary = 0;
        int currentEmployeeCounter = 0;
        int maxEmployeeCounter = 0;
        double currentAverageSalary = 0;
        double maxAverageSalary = 0;
        String currentDepartmentName = "";
        String maxDepartmentName = "";
        Department currentDepartment = new Department(new ArrayList<>());
        Department maxDepartment = new Department(new ArrayList<>());

        for (Employee employee : employeeList) {
            currentDepartmentName = employee.getDepartment();
            for (Employee employee1 : employeeList) {
                if (employee1.getDepartment().equals(currentDepartmentName)) {
                    currentSumSalary += employee1.getSalary();
                    currentEmployeeCounter++;
                    currentDepartment.add(employee1);
                }
            }
            currentAverageSalary = currentSumSalary / currentEmployeeCounter;

            if (currentAverageSalary > maxAverageSalary) {
                maxAverageSalary = currentAverageSalary;
                maxEmployeeCounter = currentEmployeeCounter;
                maxDepartmentName = currentDepartmentName;
                maxDepartment = currentDepartment;
            }

            //накрая на цикъла зануляване на currentSumSalary, currentEmployeeCounter, currentDepartmentName, currentDepartment = new Department(new ArrayList<>())
            currentSumSalary = 0;
            currentEmployeeCounter = 0;
            currentDepartmentName = "";
            currentDepartment = new Department(new ArrayList<>());

        }
        List<Employee> maxAverageSalaryDep = new ArrayList<>();
        System.out.printf("Highest Average Salary: %s%n", maxDepartmentName);

        System.out.println(maxDepartment);

    }
}
