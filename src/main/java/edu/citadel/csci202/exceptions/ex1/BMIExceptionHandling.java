package edu.citadel.csci202.exceptions.ex1;

import java.util.Scanner;

public class BMIExceptionHandling {

    static Scanner scanner = new Scanner(System.in);

    public static int getWeight() throws Exception {

        int weightParam = 0; // User defined weight (lbs)

        // Get user data
        System.out.print("Enter weight (in pounds): ");
        weightParam = scanner.nextInt();

        // Error checking, non-negative weight
        if (weightParam < 0) {
            throw new Exception("Invalid weight.");
        }
        return weightParam;
    }

    public static int getHeight() throws Exception {

        int heightParam = 0; // User defined height (in)

        // Get user data
        System.out.print("Enter height (in inches): ");
        heightParam = scanner.nextInt();

        // Error checking, non-negative height
        if (heightParam < 0) {
            throw new Exception("Invalid height.");
        }
        return heightParam;
    }

    public static void main(String[] args) {
        int weightVal = 0;    // User defined weight (lbs)
        int heightVal = 0;    // User defined height (in)
        float bmiCalc = 0.0f; // Resulting BMI
        char quitCmd = 'a';   // Indicates quit/continue

        while (quitCmd != 'q') {

            try {
                //Get user data
                weightVal = getWeight();
                heightVal = getHeight();

                // Calculate BMI and print user health info if no input error
                // Source: http://www.cdc.gov/
                bmiCalc = ((float) weightVal /
                        (float) (heightVal * heightVal)) * 703.0f;

                System.out.println("BMI: " + bmiCalc);
                System.out.println("(CDC: 18.6-24.9 normal)");
            } catch (Exception ex) {
                // Prints the error message passed by throw statement
                System.out.println(ex.getMessage());
                System.out.println("Cannot compute health info");
            }

            // Prompt user to continue/quit
            System.out.print("\nEnter any key ('q' to quit): ");
            quitCmd = scanner.next().charAt(0);
        }
        scanner.close();
    }


}