
/**
 * Write a description of class Model here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import java.util.ArrayList;

public class Model
{
    public final int DVRC_ENUM = 0; 
    public final int DVR_ENUM = 1;
    public final int DC_ENUM = 2;
    public final int IC_ENUM = 3; 
    private final int D_GROUPS_MAX_RENEW = 2;
    private final int IC_GROUP_MAX_RENEW = 6;
    private int dvrcRenewedTimes = 0;
    private int dvrRenewedTimes = 0;
    private int dcRenewedTimes = 0;
    private int icRenewedTimes = 0;
    private int lastGroup = -1;
    
    private ArrayList[] groups;
    private ArrayList<Pair> dvrc_pairs;
    private ArrayList<Pair> dvr_pairs;
    private ArrayList<Pair> dc_pairs;
    private ArrayList<Pair> ic_pairs;
    
    private ArrayList<Pair> dGroupPairs;
    private ArrayList<Pair> icGroupPairs;
    
    private char[] dvrc_chars = {'Φ','Ψ','λ','Ω'};
    private char[] dvr_chars = {'δ','β','μ','Δ'};
    private char[] dc_chars = {'α','Θ','Ξ','ζ'};
    private char[] ic_chars = {'Σ','Π'};
    
    private char[][] charCube = {dvrc_chars, dvr_chars, dc_chars, ic_chars};
    public Model()
    {
        dGroupPairs = new ArrayList<Pair>();
        populateDGroupPairs();
        icGroupPairs = new ArrayList<Pair>();
        populateICGroupPairs();
        
        dvrc_pairs = new ArrayList<Pair>(dGroupPairs);
        dvr_pairs = new ArrayList<Pair>(dGroupPairs);
        dc_pairs = new ArrayList<Pair>(dGroupPairs);
        ic_pairs = new ArrayList<Pair>(icGroupPairs);
        
        groups = new ArrayList[4];
        groups[DVRC_ENUM] = dvrc_pairs;
        groups[DVR_ENUM] = dvr_pairs;
        groups[DC_ENUM] = dc_pairs;
        groups[IC_ENUM] = ic_pairs;
    }
    
    private void populateDGroupPairs()
    {
        dGroupPairs.add(new Pair(0,1));
        dGroupPairs.add(new Pair(0,2));
        dGroupPairs.add(new Pair(0,3));
        dGroupPairs.add(new Pair(1,0));
        dGroupPairs.add(new Pair(1,2));
        dGroupPairs.add(new Pair(1,3));
        dGroupPairs.add(new Pair(2,0));
        dGroupPairs.add(new Pair(2,1));
        dGroupPairs.add(new Pair(2,3));
        dGroupPairs.add(new Pair(3,0));
        dGroupPairs.add(new Pair(3,1));
        dGroupPairs.add(new Pair(3,2));
    }
    
    private void populateICGroupPairs()
    {
        icGroupPairs.add(new Pair(0,1));
        icGroupPairs.add(new Pair(1,0));
    }
    
    public Pair getRandomPair()
    {
        int thisGroup;
        Pair returnPair = null;
        Random rand = new Random();
        
        do
        {
            thisGroup = rand.nextInt(4);
            if(thisGroup == lastGroup)
            {
                System.out.println("DEBUG: getRandomPair() - same group as last time, trying again.");
            }
            if(groups[thisGroup] == null)
            {
                System.out.println("DEBUG: getRandomPair() - That group is complete, try another group.");
            }
        } while(thisGroup == lastGroup || groups[thisGroup] == null);
        lastGroup = thisGroup;
        System.out.println("DEBUG: getRandomPair() - group: " + thisGroup + " has been selected.");
        
        switch(thisGroup)
        {
            case DVRC_ENUM: if(dvrc_pairs.size() == 1)
                            {
                                System.out.println("DEBUG: getRandomPair() - dvrc_pairs has only 1 element left. Removing element at index 0.");
                                returnPair = dvrc_pairs.remove(0);
                                returnPair.setGroup(DVRC_ENUM);
                            } else {
                                System.out.println("DEBUG: getRandomPair() - dvrc_pairs has more than 1 element left. Randomly selecting an element.");
                                returnPair = dvrc_pairs.remove(rand.nextInt(dvrc_pairs.size()));
                                returnPair.setGroup(DVRC_ENUM);
                            }
            
                            if(dvrc_pairs.isEmpty()) 
                            {
                                System.out.println("DEBUG: getRandomPair() - dvrc_pairs is empty!");
                                if(dvrcRenewedTimes < D_GROUPS_MAX_RENEW) 
                                {
                                    System.out.println("DEBUG: getRandomPair() - dvrc_pairs needs to be renewed.");
                                    dvrc_pairs.addAll(dGroupPairs);
                                    dvrcRenewedTimes++;
                                } else {
                                    System.out.println("DEBUG: getRandomPair() - dvrc_pairs has been depleted setting the reference to null.");
                                    groups[DVRC_ENUM] = null;
                                }
                            }
                            
                            break;
                            
            case DVR_ENUM: if(dvr_pairs.size() == 1)
                            {
                                returnPair = dvr_pairs.remove(0);
                                returnPair.setGroup(DVR_ENUM);
                            } else {
                                returnPair = dvr_pairs.remove(rand.nextInt(dvr_pairs.size()));
                                returnPair.setGroup(DVR_ENUM);
                            }
            
                            if(dvr_pairs.isEmpty()) 
                            {
                                if(dvrRenewedTimes < D_GROUPS_MAX_RENEW) 
                                {
                                    dvr_pairs.addAll(dGroupPairs);
                                    dvrRenewedTimes++;
                                } else {
                                    groups[DVR_ENUM] = null;
                                }
                            }
                            
                            break;
                            
            case DC_ENUM: if(dc_pairs.size() == 1)
                            {
                                returnPair = dc_pairs.remove(0);
                                returnPair.setGroup(DC_ENUM);
                            } else {
                                returnPair = dc_pairs.remove(rand.nextInt(dc_pairs.size()));
                                returnPair.setGroup(DC_ENUM);
                            }
            
                            if(dc_pairs.isEmpty()) 
                            {
                                if(dcRenewedTimes < D_GROUPS_MAX_RENEW) 
                                {
                                    dc_pairs.addAll(dGroupPairs);
                                    dcRenewedTimes++;
                                } else {
                                    groups[DC_ENUM] = null;
                                }
                            }
                            
                            break;
            case IC_ENUM: if(ic_pairs.size() == 1)
                            {
                                returnPair = ic_pairs.remove(0);
                                returnPair.setGroup(IC_ENUM);
                            } else {
                                returnPair = ic_pairs.remove(rand.nextInt(ic_pairs.size()));
                                returnPair.setGroup(IC_ENUM);
                            }
            
                            if(ic_pairs.isEmpty()) 
                            {
                                if(icRenewedTimes < IC_GROUP_MAX_RENEW) 
                                {
                                    ic_pairs.addAll(icGroupPairs);
                                    icRenewedTimes++;
                                } else {
                                    groups[IC_ENUM] = null;
                                }
                            }
                            
                            break;
            default: System.exit(1);
        }
        System.out.println("DEBUG: getRandomPair() - the following pair is being returned: " + returnPair);
        return returnPair;
    }
    
    public boolean isBaselineEstablished()
    {
        System.out.println("DEBUG: isBaselineEstablished() - groups[0] is null: " + (groups[0] == null) + " groups[1] is null: " + (groups[1] == null) + " groups[2] is null: " + (groups[2] == null) + " groups[3] is null: " + (groups[3] == null));
        return groups[0] == null && groups[1] == null && groups[2] == null && groups[3] == null;
    }
    
    public char getLeftChar(Pair pair)
    {
        return charCube[pair.getGroup()][pair.getLeftIndex()];
    }
    
    public char getRightChar(Pair pair)
    {
        return charCube[pair.getGroup()][pair.getRightIndex()];
    }
}
