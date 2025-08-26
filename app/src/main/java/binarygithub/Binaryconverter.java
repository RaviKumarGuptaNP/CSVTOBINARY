import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Binaryconverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print(m:"Enter the CSV file path: ");
            String csvPath = sc.nextLine();

            byte[] binaryData = Files.readAllBytes(Paths.get(csvPath));
            System.out.println("\nCSV file converted to binary and stored in memory.");
            System.out.println("Binary size: " + binaryData.length + " bytes");

            System.out.print("\nDo you want to restore the binary back into a CSV file? (yes/no): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.print("Enter the path to save restored CSV file: ");
                String restoredPath = sc.nextLine();

                Files.write(Paths.get(restoredPath), binaryData);
                System.out.println(" Binary data restored into: " + restoredPath);
            } else {
                System.out.println(" Program exited without restoring.");
            }

        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }

        sc.close();
    }
}
