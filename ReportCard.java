
    import java.util.Scanner;

    public class ReportCard {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Student Name:");
            String name = scanner.nextLine();

            System.out.println("Enter Roll Number:");
            int roll = scanner.nextInt();

            System.out.println("Enter marks for 5 subjects (out of 100):");
            int[] marks = new int[5];
            int total = 0;

            for (int i = 0; i < 5; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
                total += marks[i];
            }

            double average = total / 5.0;
            String grade;

            if (average >= 90) {
                grade = "A+";
            } else if (average >= 80) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B";
            } else if (average >= 60) {
                grade = "C";
            } else if (average >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.println("\n----- Report Card -----");
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + roll);
            for (int i = 0; i < 5; i++) {
                System.out.println("Subject " + (i + 1) + ": " + marks[i]);
            }
            System.out.println("Total Marks: " + total + "/500");
            System.out.println("Average: " + average);
            System.out.println("Grade: " + grade);
        }
    }


