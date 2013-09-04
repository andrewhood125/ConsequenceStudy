
/**
 * Write a description of class Pair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pair
{
    int group;
    int leftIndex;
    int rightIndex;
    
    public Pair(int left, int right, int group)
    {
        this.group = group;
        this.leftIndex = left;
        this.rightIndex = right;
    }
    
    public Pair(int left, int right)
    {
        this.leftIndex = left;
        this.rightIndex = right;
    }
    
    public String toString()
    {
        return "group: " + group + "\tleftIndex: " + leftIndex + "\trightIndex: " + rightIndex;
    }
    
    public void setGroup(int group)
    {
        this.group = group;
    }
    
    public int getGroup()
    {
        return group;
    }
    
    public int getLeftIndex()
    {
        return leftIndex;
    }
    
    public int getRightIndex()
    {
        return rightIndex;
    }
}
