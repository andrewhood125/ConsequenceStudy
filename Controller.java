
/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller
{
    // instance variables
    private View view;
    private Model model;
    private int points = 100;
    private int[] hitCount;
    private int dvrcMostPreferred, dvrcLeastPreferred;
    private int dvrMostPreferred, dvrLeastPreferred;
    private int dcMostPreferred, dcLeastPreferred;
    private int icMostPreferred, icLeastPreferred;
    
    // constructor
    public Controller()
    {
        Setup.set();
        points = Setup.getPoints();
        view = new View(this);
        model = new Model();
        hitCount  = new int[14];
    }
    
    
    // methods
    public void showInstructionSheet()
    {
        System.out.println("DEBUG: showInstructionSheet() - Setting title to Instruction Sheet.");
        view.setCurrentTitle("Instruction Sheet");
        System.out.println("DEBUG: showInstructionSheet() - Setting the points to initial value of 100.");
        view.setPoints(points);
        System.out.println("DEBUG: showInstructionSheet() - envoke showInstructionSheet from view.");
        view.showInstructionSheet();
    }
    
    public void getBaselineCondition()
    {
        System.out.println("DEBUG: getBaselineCondition() - Setting title to Baseline Condition.");
        view.setCurrentTitle("Baseline Condition");
        
        System.out.println("DEBUG: getBaselineCondition() - Get Random Pair.");
        Pair thisPair = model.getRandomPair();
          
        System.out.println("DEBUG: getBaselineCondition() - invoke view.establishPreference(" + model.getLeftChar(thisPair) + "," +  model.getRightChar(thisPair) + "," +  thisPair.getGroup() + "," + thisPair.getLeftIndex() + "," + thisPair.getRightIndex() + ")");    
        view.establishPreference(model.getLeftChar(thisPair), model.getRightChar(thisPair), thisPair.getGroup(), thisPair.getLeftIndex(), thisPair.getRightIndex());
    }
    
    public void continueBaselineCondition()
    {
        if(model.isBaselineEstablished() == false)
        {
            System.out.println("DEBUG - continueBaselineCondition() - isBaseLineEstablished is false");
            Pair thisPair = model.getRandomPair();
            System.out.println("DEBUG - continueBaselineCondition() - the following pair was selected:" + thisPair);
            System.out.println("DEBUG: continueBaselineCondition() - invoke view.establishPreference(" + model.getLeftChar(thisPair) + "," +  model.getRightChar(thisPair) + "," +  thisPair.getGroup() + "," + thisPair.getLeftIndex() + "," + thisPair.getRightIndex() + ")");    
            view.establishPreference(model.getLeftChar(thisPair), model.getRightChar(thisPair), thisPair.getGroup(), thisPair.getLeftIndex(), thisPair.getRightIndex());
        } else {
            System.out.println("DEBUG - continueBaselineCondition() - The baseline has been established. Show instructionSheet() for now.");
            view.showInstructionSheet();
            System.out.println("DEBUG - continueBaselineCondition() - print the baseline stats");
            printBaselineStats();
            // Set the most preferred and least preferred for each group. 
            setPreference();
        }
    }
    
    public void setPreference()
    {
        // DVRC
        int max, min, i = 0;
        
        max = 0;
        min = 0;
        
        for(; i < 4; i++)
        {
            if(hitCount[i] > hitCount[max]) 
            {
                // This index is higher than what is at index max. 
                max = i;
            } 
            
            if(hitCount[i] < hitCount[min])
            {
                min = i;
            }
        } 
        dvrcMostPreferred = max;
        dvrcLeastPreferred = min;
        
        System.out.println("DEBUG - setPreference() - dvrcMostPreferred = " + dvrcMostPreferred);
        System.out.println("DEBUG - setPreference() - dvrcLeastPreferred = " + dvrcLeastPreferred);
        
        
        max = 4;
        min = 4;
        for(; i < 8; i++)
        {
            if(hitCount[i] > hitCount[max]) 
            {
                // This index is higher than what is at index max. 
                max = i;
            } 
            
            if(hitCount[i] < hitCount[min])
            {
                min = i;
            }
        }
        dvrMostPreferred = max-4;
        dvrLeastPreferred = min-4;
        
        System.out.println("DEBUG - setPreference() - dvrMostPreferred = " + dvrMostPreferred);
        System.out.println("DEBUG - setPreference() - dvrLeastPreferred = " + dvrLeastPreferred);
        
        max = 8;
        min = 8;
        for(; i < 12; i++)
        {
            if(hitCount[i] > hitCount[max]) 
            {
                // This index is higher than what is at index max. 
                max = i;
            } 
            
            if(hitCount[i] < hitCount[min])
            {
                min = i;
            }
        }
        
        dcMostPreferred = max-8;
        dcLeastPreferred = min-8;
        
        System.out.println("DEBUG - setPreference() - dcMostPreferred = " + dcMostPreferred);
        System.out.println("DEBUG - setPreference() - dcLeastPreferred = " + dcLeastPreferred);
        
        max = 12;
        min = 12;
        for(; i < 14; i++)
        {
             if(hitCount[i] > hitCount[max]) 
            {
                // This index is higher than what is at index max. 
                max = i;
            } 
            
            if(hitCount[i] < hitCount[min])
            {
                min = i;
            }
        }
        
        icMostPreferred = max-12;
        icLeastPreferred = min-12;
        
        System.out.println("DEBUG - setPreference() - icMostPreferred = " + icMostPreferred);
        System.out.println("DEBUG - setPreference() - icLeastPreferred = " + icLeastPreferred);
    }
    
    public void incrementHitCount(int group, int index)
    {
        int hitCountIndex = group*4+index;
        System.out.println("DEBUG - incrementHitCount() - incrementing hitCount[" + hitCountIndex + "]");
        hitCount[hitCountIndex]++;
    }
    
    public void printBaselineStats()
    {
        for(int i = 0; i < hitCount.length; i++)
        {
            if(i < 4)
            {
                System.out.println("DVRC index[" + i + "]: " + hitCount[i]);
            } else if(i < 8) {
                System.out.println("DVR index[" + (i-4) + "]: " + hitCount[(i-4)]);
            } else if(i < 12) {
                System.out.println("DC index[" + (i-8) + "]: " + hitCount[(i-8)]);
            } else {
                System.out.println("IC index[" + (i-12) + "]: " + hitCount[(i-12)]);
            }
        }
    }
    
    
}
