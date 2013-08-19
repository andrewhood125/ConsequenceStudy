
/**
 * This is the main class in the DealyedConsequence program. 
 * Everything will be started from here. 
 * @author Andrew Hood 
 */

import java.util.Scanner;
import java.util.Random;
public class DelayedConsequence
{
    // Constants
    public static final int DVRC_ENUM = 0;
    public static final int DVR_ENUM = 1;
    public static final int DC_ENUM = 2;
    public static final int IC_ENUM = 3;

    // instance variables
    Shapes dvrc = new Shapes('Φ', 'Ψ', 'λ', 'Ω');
    Shapes dvr = new Shapes('δ', 'β', 'μ', 'Δ');
    Shapes dc = new Shapes('α', 'Θ', 'Ξ', 'ζ');
    Shapes ic = new Shapes('Σ', 'Π');
    
    public DelayedConsequence()
    {
        
    }
    
    public static void main(String[] args)
    {
        DelayedConsequence dc = new DelayedConsequence();
        // Display startup screen
        dc.startupScreen();
        
        // Establish preference
        dc.establishPreference();
        
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
    
    public void establishPreference()
    {
        Random rand = new Random(); 
        int lastGroup = rand.nextInt(4);
        boolean preferenceEstablished = false;
        while(preferenceEstablished)
        {
            // Select the group at random
            int nextGroup = rand.nextInt(4); 
            // Check to make sure we don't do the same group twice in a row
            while(lastGroup == nextGroup)
            {
                nextGroup = rand.nextInt(4); 
            }
            // reset lastGroup to the one we are using this round. 
            lastGroup = nextGroup;
            
            // The group has been selected. Now select two symbols within that group. 
            switch(nextGroup)
            {
                case DVRC_ENUM: break;
                case DVR_ENUM: break;
                case DC_ENUM: break;
                case IC_ENUM: break;
                default: System.err.println("FATAL ERROR: Integer outside the range 0-3 was genereated while eastablishing preference. Exiting."); System.exit(1); break;
            }
            // Check if all symbols have been displayed at least ten times. 
        }
    }
}
