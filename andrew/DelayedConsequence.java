
/**
 * This is the main class in the DealyedConsequence program. 
 * Everything will be started from here. 
 * @author Andrew Hood 
 */

import java.util.Scanner;
import java.util.Random;

public class DelayedConsequence
{
   

    // instance variables
    Group group;
    
    public DelayedConsequence()
    {
        group = new Group();
    }
    
    public static void main(String[] args)
    {
        DelayedConsequence dc = new DelayedConsequence();
        
        // Display startup screen
        dc.startupScreen();
        
        // Establish preference
        dc.group.establishPreference();
        
    }
    
    
    
    
    
    
    public void startupScreen()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Once you begin the computer program you will be exposed to a variety \n" + 
                            "of different choice options.  Please select the option you most prefer,\n" +
                            "although you may change your decision at any time.  After you select a shape,\n" + 
                            "you will occasionally be given material to read. Continue selecting shapes and\n" + 
                            "reading material until this program automatically ends.\n\n" +
                            "At the top of your screen (top right), you will see a number of points.  These\n" + 
                            "points correspond to raffle tickets.  The more points you have, the more raffle\n" + 
                            "tickets you will have and the better your chances will be of winning the prize\n" + 
                            "(Kindle Fire).  The choices you make on the computer will affect the number of\n" +
                            "points you have. You cannot earn points; you can only lose points.  You may\n" +
                            "leave at any time, but you must complete the program to retain any points.\n\n" + 
                            "Participation in this study will take approximately 2 hours.  Once you begin\n" + 
                            "this program, you should continue and refrain from talking to other participants.\n\n" + 
                            "When you are ready to begin the program, press begin.");
        String response = input.nextLine();
    }
    
    
}
