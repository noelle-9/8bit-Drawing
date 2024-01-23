// package BONUS;

import java.util.Scanner;

// Name: Noelle Dacayo
// Date: March 17, 2023
// App Name: Terminal Bitmap
// Description: Draw a 2D ASCII art using a 2D array of characters

public class TerminalBitmap {
    
    // CONSTANTS
    static final String LIGHT_BLUE = "\033[38;5;39m";
    static final String RESET = "\033[0m";
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c"; 
    static final String BANNER = LIGHT_BLUE + """
            +---------------------------------+
            |         T E R M I N A L         |      
            |           B I T M A P           |
            +---------------------------------+
            \n""" + RESET;
    static final String INSTRUCTIONS = """
            Colour Codes:
            [0] - Black
            [1] - Grey
            [2] - Blue
            [3] - Yellow
            [4] - Orange
            [5] - Brown
            [6] - Green
            [7] - Red
            """;

    public static void main(String[] args) {
        
        //Set Title
        // Only use this fix if your title doesn't work
        try {
            new ProcessBuilder("cmd", "/c").inheritIO().start().waitFor();
        } catch (Exception exception) {} 
            Scanner scanner = new Scanner(System.in);
            System.out.printf(SET_TITLE, "Terminal Bitmap- Noelle Dacayo");
        
        // Variables
        boolean numeric = false;
        int sizeX = 0;
        int sizeY = 0;

        // Declare the bitmap
        Bitmap bitmap;

        // =======================
        // Intput screen
        // =======================
        System.out.println(BANNER + INSTRUCTIONS);

        // Ask for the size X and Y
        do {
            System.out.print("Enter the bitmap X and Y dimensions: ");
            try {
                sizeX = scanner.nextInt();
                sizeY = scanner.nextInt();
                numeric = true;
            } catch (Exception e) {
                numeric = false;
            }

            if(!numeric) System.out.println("\nError - size must be numeric\n");

            // Get rid of any leftover input
            scanner.nextLine();

        } while (!numeric);

        // Create a new bitmap with the XY size
        bitmap = new Bitmap(sizeX, sizeY);

        // Ask for the colour codes
        bitmap.input(scanner);

        // =======================
        // Outtput screen
        // =======================
        System.out.println(CLEAR_TERMINAL + BANNER);

        // Print bitmap
        bitmap.print();
        System.out.println();
        
        System.out.println("\n\nPress Enter to exit: ");
        scanner.nextLine();
        scanner.close();
    }
}

// This was such a fun lab haha I really enjoyed this!! 
// I showed this lab to a friend of mine who's an alumni and he was very jealous haha he said he didn't get to do anything
// fun like this in his first year :') 
// Best prof honestly!