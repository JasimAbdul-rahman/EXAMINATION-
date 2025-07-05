import java.util.Scanner; 

public class UgandaWordCounter {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- NLU Book Description Analyzer ---");
        System.out.println("Please enter the book description:");
        System.out.print("Description: ");

        String bookDescription = scanner.nextLine();

        scanner.close();

        String normalizedDescription = bookDescription.toLowerCase();

        String searchWord = "uganda";

        int count = 0;

        String[] words = normalizedDescription.split("\\W+"); 
        for (String word : words) {
            if (word.equals(searchWord)) {
                count++;
            }
        }

        System.out.println("\n--- Analysis Complete ---");
        System.out.println("Original Description: \"" + bookDescription + "\"");
        System.out.println("The word \"" + searchWord + "\" (case-insensitive) appears " + count + " time(s).");
    }
}
