import java.util.Scanner;

public class EmployeeAction {

    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addEmployee();
                    break;
                case 2:viewEmployees();
                    break;
                case 3: updateEmployee();
                    break;
                case 4: deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting codveda employee management system...");
                    return;
                default:
                    System.out.println("Invalid choice selected.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Codveda Employee Management System ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        try {
            System.out.print("Enter ID: ");
            long id = scanner.nextLong();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            employeeService.add(new Employee(id, name, department, salary));
            System.out.println("Employee added successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void viewEmployees() {
        if (employeeService.findAll().isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employeeService.findAll()) {
            System.out.println(emp);
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new department: ");
        String department = scanner.nextLine();

        System.out.print("Enter new salary: ");
        double salary = scanner.nextDouble();

        if (employeeService.update(id, name, department, salary)) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        long id = scanner.nextLong();

        if (employeeService.remove(id)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
