import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String regNumber;
    private String subject;
    private String studentClass;
    private double mark;
    private boolean markRecorded;

    public Student(String name, String regNumber, String subject, String studentClass) {
        this.name = name;
        this.regNumber = regNumber;
        this.subject = subject;
        this.studentClass = studentClass;
        this.markRecorded = false;
    }

    public String getName() { return name; }
    public String getRegNumber() { return regNumber; }
    public String getSubject() { return subject; }
    public String getStudentClass() { return studentClass; }
    public double getMark() { return mark; }
    public boolean isMarkRecorded() { return markRecorded; }

    public void setMark(double mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100");
        }
        this.mark = mark;
        this.markRecorded = true;
    }
}

public class PrimeHighSchool {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    static final String USERNAME = "teacher";
    static final String PASSWORD = "prime123";

    // 1. Log into the application (3 attempts allowed)
    public static boolean login() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Username: ");
            String user = input.nextLine();
            System.out.print("Password: ");
            String pass = input.nextLine();

            if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                System.out.println("Login successful. Welcome!\n");
                return true;
            }
            attempts++;
            System.out.println("Wrong username or password. Attempts left: " + (3 - attempts));
        }
        System.out.println("Too many failed attempts. Access denied.");
        return false;
    }

    // 2. Register students
    public static void registerStudents() {
        System.out.print("How many students do you want to register? ");
        int n = Integer.parseInt(input.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\nStudent " + i);
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Registration number: ");
            String reg = input.nextLine();

            if (findStudent(reg) != null) {
                System.out.println("A student with that registration number already exists.");
                i--;
                continue;
            }
            System.out.print("Subject: ");
            String subject = input.nextLine();
            System.out.print("Class: ");
            String cls = input.nextLine();

            students.add(new Student(name, reg, subject, cls));
            System.out.println(name + " registered successfully.");
        }
    }

    // 3. Record students' marks
    public static void recordMarks() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        for (Student s : students) {
            boolean valid = false;
            while (!valid) {
                System.out.print("Enter mark for " + s.getName()
                        + " (" + s.getRegNumber() + ") in " + s.getSubject() + ": ");
                try {
                    double mark = Double.parseDouble(input.nextLine());
                    s.setMark(mark);
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Marks recorded successfully.");
    }

    // 4. See all registered students and their marks
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        System.out.printf("%n%-15s %-20s %-15s %-8s %-6s%n",
                "Reg No", "Name", "Subject", "Class", "Mark");
        System.out.println("-----------------------------------------------------------------");
        for (Student s : students) {
            String mark = s.isMarkRecorded() ? String.valueOf(s.getMark()) : "N/A";
            System.out.printf("%-15s %-20s %-15s %-8s %-6s%n",
                    s.getRegNumber(), s.getName(), s.getSubject(),
                    s.getStudentClass(), mark);
        }
    }

    // helper used to stop duplicate registration numbers
    public static Student findStudent(String reg) {
        for (Student s : students) {
            if (s.getRegNumber().equalsIgnoreCase(reg)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("=== PRIME HIGH SCHOOL STUDENT RECORDS ===");
        if (!login()) {
            return;
        }

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n1. Register students");
            System.out.println("2. Record marks");
            System.out.println("3. View students and marks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1: registerStudents(); break;
                case 2: recordMarks(); break;
                case 3: viewStudents(); break;
                case 4: System.out.println("Goodbye."); break;
                default: System.out.println("Invalid option, try again.");
            }
        }
    }
}
