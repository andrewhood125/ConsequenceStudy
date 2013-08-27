
/**
 * A class designed to hold 2 or 4 symbols it can be instantiated multiple times to 
 * hold dvrc, dvr, dc and ic. 
 * 
 * @author Andrew Hood
 */

import java.util.Random;
public class Condition
{
    // instance variables
    
    char[] symbols;
    // This will hold the number of exact clicks each symbol while establishing preference
    int[] preference;
    // This will hold the number of exact clicks each symbol had during the study.
    int[] timesClicked;
    // This will hold all the pairs for the condition 
    Pair[] pairs;
    int mostPreferredIndex;
    int leastPreferredIndex;
    int timesAllPairsDisplayed;
    int timesPairsRequiredDisplayed;
    
    public Condition(char x, char y)
    {
        symbols = new char[] {x,y};
        preference = new int[2];
        timesClicked = new int[2];
        pairs = new Pair[] {new Pair(0,1), new Pair(1,0)};
        timesAllPairsDisplayed = 0;
        timesPairsRequiredDisplayed = 12;
    }
    
    public Condition(char x, char y, char z, char e)
    {
        symbols = new char[] {x,y,z,e};
        preference = new int[4];
        timesClicked = new int[4];
        pairs = new Pair[] {new Pair(0,1), new Pair(0,2), new Pair(0,3), 
                            new Pair(1,0), new Pair(1,2), new Pair(1,3),
                            new Pair(2,0), new Pair(2,1), new Pair(2,3), 
                            new Pair(3,0), new Pair(3,1), new Pair(3,2)};
       timesAllPairsDisplayed = 0;
       timesPairsRequiredDisplayed = 2;
    }
    
    public void displayPair(Pair pair)
    {
        System.out.println(symbols[pair.getLeftIndex()] + " " + symbols[pair.getRightIndex()]);
    }
    
    public Pair getRandomPair()
    {
        Random rand = new Random();
        boolean foundGoodPair = false;
        int randomPairIndex = 0;
        int originalIndex;
        while(!foundGoodPair)
        {
            foundGoodPair = true;
            originalIndex = randomPairIndex = rand.nextInt(pairs.length);
            // This pair has been shown this round already
            if(pairs[randomPairIndex].getTimesDisplayed() > timesAllPairsDisplayed)
            {
                // pick another pair
                if(randomPairIndex+1 < pairs.length)
                {
                    randomPairIndex++;
                } else {
                    randomPairIndex = 0;
                }
                
                // All pairs have been selected increment timesAllPairsDisplayed and
                // return the pair at originalIndex
                if(randomPairIndex == originalIndex)
                {
                    timesAllPairsDisplayed++;
                    pairs[originalIndex].incrementTimesDisplayed();
                    return pairs[originalIndex];
                }
                foundGoodPair = false;
            }
        }
        // Good pair Found
        pairs[randomPairIndex].incrementTimesDisplayed();
        return pairs[randomPairIndex];
    }
    
    public boolean preferenceEstablished()
    {
        return timesAllPairsDisplayed == timesPairsRequiredDisplayed;
    }
    
}
