// package BONUS;

import java.util.Scanner;

public class Bitmap {

    // CONSTANTS 
    private final String GREY = "\u001B[47m";
    private final String GREEN = "\033[42;1m";
    private final String BLUE = "\u001B[44m";
    private final String ORANGE = "\u001B[48;2;255;165;0m";
    private final String BROWN = "\u001B[48;2;139;69;19m";
    private final String YELLOW = "\u001B[43m";
    private final String RED = "\u001B[41m";
    private final String RESET = "\033[0m";
    // Class variables
    private char[][] bitmap; // 2D array of characters
    private int sizeX; // width
    private int sizeY; // height

    /**
     * Constructor method
     * @return a new bitmap object
     */
    Bitmap(int sizeX, int sizeY)
    {
        // Initialise the class variables 
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        // Initialise the 2D array with the given width(X) and height(Y)
        bitmap = new char[sizeX][sizeY];
    }

    /** Ask for all the pixel colour codes 
     * @param scanner User input
     * **/
    void input(Scanner scanner)
    {
       
        // Go through each line
        for(int countY = 0; countY < sizeY; countY++)
        {
            // Ask for colour codes
            System.out.print("Enter " + sizeX + " for line " + countY + ": ");

            // Ask for each colour code
            for(int countX = 0; countX < sizeX; countX++)
            {
               bitmap[countX][countY] = scanner.next().charAt(0);
            }
            // Get rid of leftover input
            scanner.nextLine();

        }    
    }

    /**
     * Print the 2D bitmap 
     **/
    void print()
    {
        // Go through each line
        for(int countY = 0; countY < sizeY; countY++)
        {
            // Go through each colour code
            for(int countX = 0; countX < sizeX; countX++)
            {
                // If the code is 0 then print black
                if(bitmap[countX][countY] == '0')
                    System.out.print("  ");  // 2 spaces, so it's a square
                // If the code is 1 then print green
                else if(bitmap[countX][countY] == '1')
                    System.out.print(GREY + "  " + RESET);
                else if(bitmap[countX][countY] == '2')
                    System.out.print(BLUE + "  " + RESET);
                else if(bitmap[countX][countY] == '3')
                    System.out.print(YELLOW + "  " + RESET);
                else if(bitmap[countX][countY] == '4')
                    System.out.print(ORANGE + "  " + RESET);
                else if(bitmap[countX][countY] == '5')
                    System.out.print(BROWN + "  " + RESET);
                else if(bitmap[countX][countY] == '6')
                    System.out.print(GREEN + "  " + RESET);
                else if(bitmap[countX][countY] == '7')
                    System.out.print(RED + "  " + RESET);
            }
            // Go to next line
            System.out.println();
        }
    }
}
