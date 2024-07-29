import java.util.Scanner;

public class EmployeeManagementSystem {

    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    private Employee[] employees;
    private int size; // Tracks the number of employees

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee array is full.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    public void displayEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null; // Remove reference to last element
            size--;
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem(10); // Capacity of 10

        while (true) {
            System.out.println("1. Add employee");
            System.out.println("2. Search employee");
            System.out.println("3. Display employees");
            System.out.println("4. Delete employee");
            System.out.println("-1 to exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    Employee employee = new Employee(id, name, position, salary);
                    system.addEmployee(employee);
                    break;

                case 2:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee result = system.searchEmployee(searchId);
                    if (result != null) {
                        System.out.println("Employee found: " + result);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    system.displayEmployees();
                    break;

                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    system.deleteEmployee(deleteId);
                    break;

                case -1:
                    System.out.println("Thank you.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Incorrect choice. Please try again.");
                    break;
            }
        }
    }
}