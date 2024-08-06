import java.util.Scanner;

public class HRManagementSystem {

    private static class Employee {
        public String name;
        public int age;
        public double salary;

        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String toString() {
            return String.format("Name: %s, Age: %d, Salary: %.2f", name, age, salary);
        }
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("HR MANAGEMENT SYSTEM");
        System.out.println("---------------------------------\n");
        Scanner input = new Scanner(System.in);
        Employee[] employees = {
                new Employee("Darshil", 19, 100000.0),
                new Employee("Dhruv", 22, 100000.0),
                new Employee("Vinkas", 21, 10000000.0),
                new Employee("Stanly", 26, 50000.0),
                new Employee("Harsh", 20, 45000.0),
                new Employee("Naman", 20, 35000.0),
                new Employee("Jenil ", 24, 35000.0),
                
                new Employee("Dev", 22, 60000.0),
                new Employee("Ayush", 23, 4000.0),
                new Employee("Chirag", 25, 55000.0)
        };
        int g = 0;
        while (g == 0) {
            System.out.println("enter your designation");
            System.out.println("1. HR\n2. Employee");
            int no = input.nextInt();
            if (no == 1) {
                String Hrpass = "dhruvdarshil";
                System.out.println("enter password ");
                String pass = input.next();
                if (Hrpass.equals(pass)) {
                    int z = 0;
                    while (z == 0) {
                        System.out.println("\n1. Add employee");
                        System.out.println("2. Delete employee");
                        System.out.println("3. Update employee");
                        System.out.println("4. Display employees");
                        System.out.println("5. Exit");

                        System.out.print("Enter your choice: ");
                        int choice = input.nextInt();
                        input.nextLine(); // Consume newline character

                        switch (choice) {
                            case 1:
                                if (employees.length >= 20) {
                                    System.out.println("Maximum number of employees reached!");
                                    break;
                                }

                                System.out.print("Enter name of employee: ");
                                String name = input.nextLine();

                                System.out.print("Enter age of employee: ");
                                int age = input.nextInt();

                                System.out.print("Enter salary of employee: ");
                                double salary = input.nextDouble();

                                Employee[] newEmployees = new Employee[employees.length + 1];
                                System.arraycopy(employees, 0, newEmployees, 0, employees.length);
                                newEmployees[newEmployees.length - 1] = new Employee(name, age, salary);
                                employees = newEmployees;

                                System.out.println("Employee added.");
                                break;

                            case 2:
                                System.out.print("Enter name of employee to delete: ");
                                String nameToDelete = input.nextLine();

                                int indexToDelete = -1;
                                for (int i = 0; i < employees.length; i++) {
                                    if (employees[i].name.equals(nameToDelete)) {
                                        indexToDelete = i;
                                        break;
                                    }
                                }

                                if (indexToDelete == -1) {
                                    System.out.println("Employee not found.");
                                    break;
                                }

                                Employee[] updatedEmployees = new Employee[employees.length - 1];
                                for (int i = 0, j = 0; i < employees.length; i++) {
                                    if (i == indexToDelete) {
                                        continue;
                                    }
                                    updatedEmployees[j++] = employees[i];
                                }
                                employees = updatedEmployees;

                                System.out.println("Employee deleted.");
                                break;

                            case 3:
                                System.out.print("Enter name of employee to update: ");
                                String nameToUpdate = input.nextLine();

                                int indexToUpdate = -1;
                                for (int i = 0; i < employees.length; i++) {
                                    if (employees[i].name.equals(nameToUpdate)) {
                                        indexToUpdate = i;
                                        break;
                                    }
                                }

                                if (indexToUpdate == -1) {
                                    System.out.println("Employee not found.");
                                    break;
                                }

                                System.out.print("Enter new name of employee: ");
                                String newName = input.nextLine();

                                System.out.print("Enter new age of employee: ");
                                int newAge = input.nextInt();

                                System.out.print("Enter new salary of employee: ");
                                double newSalary = input.nextDouble();

                                employees[indexToUpdate].name = newName;
                                employees[indexToUpdate].age = newAge;
                                employees[indexToUpdate].salary = newSalary;

                                System.out.println("Employee updated.");
                                System.out.println("Name: " + newName);
                                System.out.println("Age: " + newAge);
                                System.out.println("Salary: " + newSalary);
                                break;
                            case 4:
                                if (employees.length == 0) {
                                    System.out.println("No employees to display.");
                                    break;
                                }

                                System.out.println("Employee list:");
                                for (Employee employee : employees) {
                                    System.out.println("Name: " + employee.name);
                                    System.out.println("Age: " + employee.age);
                                    System.out.println("Salary: " + employee.salary);
                                    System.out.println("\n");
                                }
                                break;
                            case 5:
                                z++;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    }
                } else {
                    System.out.println("Incorrect password");
                    break;
                }
            }
            if (no == 2) {
                System.out.print("Enter your name to proceed: ");
                String nameT = input.next();

                int index = -1;
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].name.equals(nameT)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Employee not found.");
                    break;
                }


                String newName = employees[index].name;
                int newAge = employees[index].age;
                double newSalary = employees[index].salary;


                System.out.println("Name: " + newName);
                System.out.println("Age: " + newAge);
                System.out.println("Salary: " + newSalary);
                break;


            }
        }
    }
}
