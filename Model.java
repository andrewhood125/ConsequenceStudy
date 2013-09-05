
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
    public static final int DVRC_ENUM = 0; 
    public static final int DVR_ENUM = 1;
    public static final int DC_ENUM = 2;
    public static final int IC_ENUM = 3; 
    private final int D_GROUPS_MAX_RENEW = 2;
    private final int IC_GROUP_MAX_RENEW = 6;
    private int dvrcRenewedTimes = 0;
    private int dvrRenewedTimes = 0;
    private int dcRenewedTimes = 0;
    private int icRenewedTimes = 0;
    private ArrayList lastGroup = null;
    
    private ArrayList<ArrayList> groups;
    private ArrayList<Pair> dvrc_pairs;
    private ArrayList<Pair> dvr_pairs;
    private ArrayList<Pair> dc_pairs;
    private ArrayList<Pair> ic_pairs;
    
    private ArrayList<Pair> dGroupPairs;
    private ArrayList<Pair> icGroupPairs;
    
    private char[] dvrc_chars = Setup.getShapes(0);
    private char[] dvr_chars = Setup.getShapes(1);
    private char[] dc_chars = Setup.getShapes(2);
    private char[] ic_chars = Setup.getShapes(3);    
    private char[][] charCube = {dvrc_chars, dvr_chars, dc_chars, ic_chars};
    
    public Model()
    {       
        dGroupPairs = new ArrayList<Pair>();
        populateDGroupPairs();
        icGroupPairs = new ArrayList<Pair>();
        populateICGroupPairs();
        groups = new ArrayList<ArrayList>();
        dvrc_pairs = new ArrayList<Pair>(dGroupPairs);
        dvr_pairs = new ArrayList<Pair>(dGroupPairs);
        dc_pairs = new ArrayList<Pair>(dGroupPairs);
        ic_pairs = new ArrayList<Pair>(icGroupPairs);        
        groups.add(dvrc_pairs);
        groups.add(dvr_pairs);
        groups.add(dc_pairs);
        groups.add(ic_pairs);
    }
    
    private void populateDGroupPairs()
    {
        for(int i = 0; i < 3; i++)
        	{
        	    for(int j = 0; j < Setup.getShapes(i).length; j++)
            	    {
            		if(i != j)
                		{
                		    dGroupPairs.add(new Pair(i,j));
                		}
            	    }
        	}	
    }
    
    private void populateICGroupPairs()
    {
        for(int i = 0; i < Setup.getShapes(3).length-1; i++)
            {
                if(i != (Setup.getShapes(3).length-1))
                    {
                        icGroupPairs.add(new Pair(i,(Setup.getShapes(3).length - 1 - i)));
                    }
            }
    }
    
    public Pair getRandomPair()
    {
        ArrayList thisGroup;
        Pair returnPair = null;
        Random rand = new Random();        
        do
        {
            if(groups.size() == 1)
            {
                System.out.println("DEBUG: getRandomPair() - groups is size 1 removing the first index and breaking.");
                thisGroup = groups.remove(0);
                break;
            }
            thisGroup = groups.get(rand.nextInt(groups.size()));            
            if(thisGroup == lastGroup)
            {
                System.out.println("DEBUG: getRandomPair() - same group as last time, trying again.");
            }
            if(thisGroup == null)
            {
                System.out.println("DEBUG: getRandomPair() - That group is complete, try another group.");
            }            
        } while(thisGroup == lastGroup || thisGroup == null);
        lastGroup = thisGroup;
        System.out.println("DEBUG: getRandomPair() - group: " + thisGroup + " has been selected.");
        int whichGroup = 0;        
        if(thisGroup == dvrc_pairs)
        {
            whichGroup = 0;
            System.out.println("DEBUG: getRandomPair() - whichGroup = 0");
        }
        if(thisGroup == dvr_pairs)
        {
            whichGroup = 1;
            System.out.println("DEBUG: getRandomPair() - whichGroup = 1");
        }
        if(thisGroup == dc_pairs)
        {
            whichGroup = 2;
            System.out.println("DEBUG: getRandomPair() - whichGroup = 2");
        }
        if(thisGroup == ic_pairs)
        {
            whichGroup = 3;
            System.out.println("DEBUG: getRandomPair() - whichGroup = 3");
        }        
        switch(whichGroup)
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
                                    groups.remove(dvrc_pairs);
                                    
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
                                    groups.remove(dvr_pairs);
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
                                    groups.remove(dc_pairs);
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
                                    groups.remove(ic_pairs);
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
        System.out.println("DEBUG: isBaselineEstablished() - groups.isEmpty() is " + groups.isEmpty());
        return groups.isEmpty();
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
