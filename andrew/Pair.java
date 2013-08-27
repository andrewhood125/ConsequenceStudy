
/**
 * Keeps track of the indicies for all the generated pairs for a condition. 
 * 
 * @author Andrew Hood
 */
public class Pair
{
    int indexLeft, indexRight, timesDisplayed;

    public Pair(int x, int y)
    {
        indexLeft = x;
        indexRight = y;
        timesDisplayed = 0;
    }
    
    public int getTimesDisplayed()
    {
        return timesDisplayed;
    }
    
    public int getLeftIndex()
    {
        return indexLeft;
    }
    
    public int getRightIndex()
    {
        return indexRight;
    }
    
    public void incrementTimesDisplayed()
    {
        timesDisplayed++;
    }
}
