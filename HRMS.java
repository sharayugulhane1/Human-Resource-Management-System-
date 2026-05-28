
import java.util.*;

class Employee {

    int empId;
    String name;
    String designation;
    String department;
    String contact;

    String attendance;
    String leaveStatus;

    Employee(int empId, String name,
             String designation,
             String department,
             String contact) {

        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.contact = contact;

        attendance = "Not Marked";
        leaveStatus = "No Leave";
    }

    void displayEmployee() {

        System.out.println("\nEmployee ID : " + empId);
        System.out.println("Name : " + name);
        System.out.println("Designation : " + designation);
        System.out.println("Department : " + department);
        System.out.println("Contact : " + contact);
        System.out.println("Attendance : " + attendance);
        System.out.println("Leave Status : " + leaveStatus);
    }
}

public class HRMS {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Employee> employees =
            new ArrayList<Employee>();

    // Login Credentials
    static String username = "admin";
    static String password = "1234";

    public static void main(String[] args) {

        login();

        while (true) {

            System.out.println("\n===== HRMS MENU =====");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Mark Attendance");
            System.out.println("6. Leave Management");
            System.out.println("7. Search Employee");
            System.out.println("8. Generate Report");
            System.out.println("9. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    updateEmployee();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    markAttendance();
                    break;

                case 6:
                    manageLeave();
                    break;

                case 7:
                    searchEmployee();
                    break;

                case 8:
                    generateReport();
                    break;

                case 9:
                    System.out.println("Exiting HRMS...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Login
    static void login() {

        System.out.println("===== HRMS LOGIN =====");

        System.out.print("Enter Username : ");
        String user = sc.nextLine();

        System.out.print("Enter Password : ");
        String pass = sc.nextLine();

        if (user.equals(username)
                && pass.equals(password)) {

            System.out.println("Login Successful!");

        } else {

            System.out.println("Invalid Login!");
            System.exit(0);
        }
    }

    // Add Employee
    static void addEmployee() {

        sc.nextLine();

        System.out.println("\n===== ADD EMPLOYEE =====");

        System.out.print("Enter Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Designation : ");
        String designation = sc.nextLine();

        System.out.print("Enter Department : ");
        String department = sc.nextLine();

        System.out.print("Enter Contact : ");
        String contact = sc.nextLine();

        Employee emp = new Employee(id,
                name,
                designation,
                department,
                contact);

        employees.add(emp);

        System.out.println("Employee Added Successfully!");
    }

    // View Employees
    static void viewEmployees() {

        System.out.println("\n===== EMPLOYEE LIST =====");

        if (employees.size() == 0) {

            System.out.println("No Employees Found!");
            return;
        }

        for (Employee emp : employees) {

            emp.displayEmployee();
        }
    }

    // Update Employee
    static void updateEmployee() {

        System.out.print("\nEnter Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Employee emp : employees) {

            if (emp.empId == id) {

                System.out.print("Enter New Contact : ");
                emp.contact = sc.nextLine();

                System.out.print("Enter New Department : ");
                emp.department = sc.nextLine();

                System.out.println("Employee Updated Successfully!");

                found = true;
            }
        }

        if (!found) {

            System.out.println("Employee Not Found!");
        }
    }

    // Delete Employee
    static void deleteEmployee() {

        System.out.print("\nEnter Employee ID : ");
        int id = sc.nextInt();

        boolean removed = false;

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).empId == id) {

                employees.remove(i);

                System.out.println("Employee Deleted Successfully!");

                removed = true;
                break;
            }
        }

        if (!removed) {

            System.out.println("Employee Not Found!");
        }
    }

    // Attendance
    static void markAttendance() {

        System.out.print("\nEnter Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Employee emp : employees) {

            if (emp.empId == id) {

                System.out.print("Enter Attendance "
                        + "(Present/Absent/Leave) : ");

                emp.attendance = sc.nextLine();

                System.out.println("Attendance Marked Successfully!");

                found = true;
            }
        }

        if (!found) {

            System.out.println("Employee Not Found!");
        }
    }

    // Leave Management
    static void manageLeave() {

        System.out.print("\nEnter Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Employee emp : employees) {

            if (emp.empId == id) {

                System.out.print("Enter Leave Status "
                        + "(Approved/Rejected/Pending) : ");

                emp.leaveStatus = sc.nextLine();

                System.out.println("Leave Status Updated!");

                found = true;
            }
        }

        if (!found) {

            System.out.println("Employee Not Found!");
        }
    }

    // Search Employee
    static void searchEmployee() {

        sc.nextLine();

        System.out.print("\nEnter Employee Name : ");
        String search = sc.nextLine();

        boolean found = false;

        for (Employee emp : employees) {

            if (emp.name.equalsIgnoreCase(search)) {

                emp.displayEmployee();

                found = true;
            }
        }

        if (!found) {

            System.out.println("Employee Not Found!");
        }
    }

    // Generate Report
    static void generateReport() {

        System.out.println("\n===== HRMS REPORT =====");

        System.out.println("Total Employees : "
                + employees.size());

        int present = 0;
        int absent = 0;
        int leave = 0;

        for (Employee emp : employees) {

            if (emp.attendance.equalsIgnoreCase("Present")) {
                present++;
            }

            else if (emp.attendance.equalsIgnoreCase("Absent")) {
                absent++;
            }

            else if (emp.attendance.equalsIgnoreCase("Leave")) {
                leave++;
            }
        }

        System.out.println("Present Employees : " + present);
        System.out.println("Absent Employees : " + absent);
        System.out.println("Employees on Leave : " + leave);
    }
}

