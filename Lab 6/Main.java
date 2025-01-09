import cie.Internals;
import see.External;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            scanner.nextLine(); // Consume newline

            System.out.print("USN: ");
            String usn = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Semester: ");
            int sem = scanner.nextInt();

            System.out.println("Enter internal marks for 5 courses (out of 50): ");
            int[] internalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Course " + (j + 1) + " internal marks: ");
                internalMarks[j] = scanner.nextInt();
            }

            @SuppressWarnings("unused")
            Internals internals = new Internals(internalMarks);

            System.out.println("Enter SEE marks for 5 courses (out of 100): ");
            int[] seeMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Course " + (j + 1) + " SEE marks: ");
                seeMarks[j] = scanner.nextInt();
            }

            External external = new External(usn, name, sem, seeMarks);

            System.out.println("\nFinal Marks for " + external.getName() + " (" + external.getUsn() + "):");
            System.out.println("Semester: " + external.getSem());
            System.out.println("Internal Marks:");
            for (int j = 0; j < 5; j++) {
                double finalMarks = internalMarks[j] + (external.getSeeMarks()[j] / 2.0);
                System.out.println("Course " + (j + 1) + ": " + finalMarks);
            }
        }

        scanner.close();
    }
}
