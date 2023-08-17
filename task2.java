import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter '1' to input text manually, or '2' to provide a file path:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            String text = "";

            if (choice == 1) {
                System.out.println("Enter the text: ");
                text = scanner.nextLine();
            } else if (choice == 2) {
                System.out.println("Enter the file path: ");
                String filePath = scanner.nextLine();

                try {
                    text = readFromFile(filePath);
                } catch (IOException e) {
                    System.out.println("Error reading the file. Make sure the file path is correct.");
                    System.exit(1);
                }
            } else {
                System.out.println("Invalid choice. Please enter '1' or '2'.");
                System.exit(1);
            }

            // Split the input text into an array of words using space and punctuation as delimiters
            String[] words = text.split("[\\s\\p{Punct}]+");

            // Initialize the counter variable
            int wordCount = words.length;

            // Display the total count of words
            System.out.println("Total number of words: " + wordCount);
        }
    }

    // Helper method to read the content from a file and return it as a string
    private static String readFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        System.out.println(content.toString());
        return content.toString();
        

    }
}
