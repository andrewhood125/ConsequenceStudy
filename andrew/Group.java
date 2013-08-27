
/**
 * This class houses the 4 groups of shapes and provides methods to interact with them. 
 * 
 * @author Andrew Hood
 */

import java.util.Random;

public class Group
{
    
    // Constants
    public static final int DVRC_ENUM = 0;
    public static final int DVR_ENUM = 1;
    public static final int DC_ENUM = 2;
    public static final int IC_ENUM = 3;
    
    // instance variables
    Condition dvrc, dvr, dc, ic;
    

    /**
     * Constructor for objects of class Groups
     */
    public Group()
    {
       dvrc = new Condition('Φ', 'Ψ', 'λ', 'Ω');
       dvr = new Condition('δ', 'β', 'μ', 'Δ');
       dc = new Condition('α', 'Θ', 'Ξ', 'ζ');
       ic = new Condition('Σ', 'Π');
    }
    
    
    public void establishPreference()
    {
        Random rand = new Random(); 
        int lastCondition = -1;
        boolean preferenceEstablished = false;
        while(!preferenceEstablished)
        {
            // Select the condition at random
            int nextCondition = rand.nextInt(4);
            
            // Check to make sure we don't do the same condition twice in a row
            while(lastCondition == nextCondition)
            {
                nextCondition = rand.nextInt(4); 
            }
            // reset lastGroup to the one we are using this round. 
            lastCondition = nextCondition;
            
            // The condition has been selected. Now select two symbols within that group. 
            Pair toBeDisplayed;
            switch(nextCondition)
            {
                case DVRC_ENUM: toBeDisplayed = dvrc.getRandomPair();
                                dvrc.displayPair(toBeDisplayed);
                                break;
                case DVR_ENUM:  toBeDisplayed = dvr.getRandomPair();
                                dvr.displayPair(toBeDisplayed);
                                break;
                case DC_ENUM:   toBeDisplayed = dc.getRandomPair();
                                dc.displayPair(toBeDisplayed);
                                break;
                case IC_ENUM:   toBeDisplayed = ic.getRandomPair();
                                ic.displayPair(toBeDisplayed);
                                break;
                default: System.err.println("FATAL ERROR: Integer outside the range 0-3 was genereated while eastablishing preference. Exiting."); System.exit(1); break;
            }
            // Check if all conditions are good.
            if(dvrc.preferenceEstablished() && dvr.preferenceEstablished() && dc.preferenceEstablished() && ic.preferenceEstablished())
            {
                preferenceEstablished = true;
            }
        }
    }
}
