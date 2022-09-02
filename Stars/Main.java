import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    

    // Filepath
    public static final String FILEPATH = "./mag_5_stars.csv";

    /**
     * @description - loads file to array
     * @return - an array starts
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static ArrayList<Star> loadData() throws FileNotFoundException, IOException {

        // Declare ArrayList
        ArrayList<Star> data = new ArrayList<Star>();
        File file = new File(FILEPATH);
        Scanner sc = new Scanner(file);
        sc.nextLine();

        // Check file using Scanner
        while (sc.hasNextLine()) {
            Star star = new Star(sc.nextLine());
            data.add(star);
        }

        // Closes scanner and returns data to loadData() method for exporting
        sc.close();
        return data;
    }

    /**
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {

        try (Scanner sc = new Scanner(System.in)) {

            // Boolean will keep repeating in WHILE loop until its false, COUNT just keeps a
            // stationary 0 until updated
            boolean shouldContinue = true;
            int count = 0;
            while (shouldContinue) {
                try {
                    System.out.print("Constellation (three letters): ");
                    String search = sc.nextLine();

                    /*
                     * Using Java 1.8 stream() method to filter out every constellation name in the
                     * CSV file based on user search.
                     * Then putting everything that returned back into the list, but only looking at
                     * those constellation names.
                     */
                    List<Star> stars = loadData().stream()
                            .filter(star -> star.getConstellationName().equalsIgnoreCase(search))
                            .collect(Collectors.toList());

                    // Default the brightest and most distant star to index 0 or the top of the
                    // array.
                    Star farthest = stars.get(0);
                    Star brightest = stars.get(0);

                    // Start at index 1 <skipping over the headers> to the max of the searched stars
                    for (int i = 1; i < stars.size(); i++) {
                        Star star = stars.get(i);
                        count++;

                        // Using Star.java search the array based on search for the one with the
                        // farthest distance
                        if (star.getDistance() > farthest.getDistance()) {
                            farthest = star;
                        }

                        // Using Star.java search the array based on search for the one with the lowest
                        // Visual Magnitude ABOVE 0
                        if (star.getVisualMagnitude() < brightest.getVisualMagnitude()
                                && brightest.getVisualMagnitude() < 0.0) {
                            brightest = star;
                        }
                    }

                    // Prints out Star.toString() StringBuilder append
                    System.out
                            .println("**************\nStar report for: " + search + "\n\nTotal number of stars found: "
                                    + count + "\n\nBrightest:\n" + brightest + "\nMost Distant:\n" + farthest);
                    System.out.println("Do you wish to enter another star?");
                    String answer = sc.nextLine();

                    // Checks if returned answer contains a "y" or anything else and stops program
                    // if !"y"
                    if (!answer.contains("y")) {
                        shouldContinue = false;
                        System.out.println("Thank you for using the DCC Star Constellation Database.\nGood Bye!");
                    }

                    // catch method in try_catch to see if the search yields a matching result and
                    // repeats the question
                } catch (Exception e) {
                    System.out.println(
                            "Oops! Sorry, what you have searched for is not in our database or is not a valid entry. Try again.");
                    shouldContinue = true;
                }
            }
        }
    }
}
