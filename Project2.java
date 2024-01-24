import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String employeeId;
    private String employeeName;
    private int employeeAge;

    public Employee(String employeeId, String employeeName, int employeeAge) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
    }

    // Getters and Setters

    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + employeeName + ", Age: " + employeeAge;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }
}

class EmployeeDatabase {
    private List<Employee> employees;

    public EmployeeDatabase() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void updateEmployee(String employeeId, String newEmployeeName, int newEmployeeAge) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                employee.setEmployeeName(newEmployeeName);
                employee.setEmployeeAge(newEmployeeAge);
                break;
            }
        }
    }

    public void deleteEmployee(String employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
    }
}

public class Project2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();

        while (true) {
            try {
                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter employee ID: ");
                        String employeeId = scanner.nextLine();
                        System.out.print("Enter employee name: ");
                        String employeeName = scanner.nextLine();
                        System.out.print("Enter employee age: ");
                        int employeeAge = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        Employee newEmployee = new Employee(employeeId, employeeName, employeeAge);
                        employeeDatabase.addEmployee(newEmployee);
                        break;

                    case 2:
                        employeeDatabase.displayEmployees();
                        break;

                    case 3:
                        System.out.print("Enter employee ID to update: ");
                        String updateEmployeeId = scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newEmployeeName = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int newEmployeeAge = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        employeeDatabase.updateEmployee(updateEmployeeId, newEmployeeName, newEmployeeAge);
                        break;

                    case 4:
                        System.out.print("Enter employee ID to delete: ");
                        String deleteEmployeeId = scanner.nextLine();
                        employeeDatabase.deleteEmployee(deleteEmployeeId);
                        break;

                    case 5:
                        System.out.println("Exiting program.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}