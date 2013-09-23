
/**
 * Interact with the data collected from the program. 
 * 
 * @author Andrew Hood, Neal Patel
 * @version 2013-09-23
 * Copyright (c) 2013 Andrew Hood, Neal Patel
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import java.util.Random;
import java.util.ArrayList;

public class Model
{
    public static final int DVRC_ENUM = 0; 
    public static final int DVR_ENUM = 1;
    public static final int DC_ENUM = 2;
    public static final int IC_ENUM = 3; 
    private final int D_GROUPS_MAX_RENEW = 1*Setup.getBaselinePres();
    private final int IC_GROUP_MAX_RENEW = 3*Setup.getBaselinePres();
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
    
    private static char[] dvrc_chars = Setup.getShapes(0);
    private static char[] dvr_chars = Setup.getShapes(1);
    private static char[] dc_chars = Setup.getShapes(2);
    private static char[] ic_chars = Setup.getShapes(3);    
    private static char[][] charCube = {dvrc_chars, dvr_chars, dc_chars, ic_chars};
    
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
                thisGroup = groups.remove(0);
                break;
            }
            thisGroup = groups.get(rand.nextInt(groups.size()));            
                        
        } while(thisGroup == lastGroup || thisGroup == null);
        
        lastGroup = thisGroup;
        int whichGroup = 0;        
        if(thisGroup == dvrc_pairs)
        {
            whichGroup = 0;
        }
        if(thisGroup == dvr_pairs)
        {
            whichGroup = 1;
        }
        if(thisGroup == dc_pairs)
        {
            whichGroup = 2;
        }
        if(thisGroup == ic_pairs)
        {
            whichGroup = 3;
        }        
        switch(whichGroup)
        {
            case DVRC_ENUM: if(dvrc_pairs.size() == 1)
                            {
                                returnPair = dvrc_pairs.remove(0);
                                returnPair.setGroup(DVRC_ENUM);
                            } else {
                                returnPair = dvrc_pairs.remove(rand.nextInt(dvrc_pairs.size()));
                                returnPair.setGroup(DVRC_ENUM);
                            }
            
                            if(dvrc_pairs.isEmpty()) 
                            {
                                if(dvrcRenewedTimes < D_GROUPS_MAX_RENEW) 
                                {
                                    dvrc_pairs.addAll(dGroupPairs);
                                    dvrcRenewedTimes++;
                                } else {
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
        return returnPair;
    }
    
    public boolean isBaselineEstablished()
    {
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
    
    public static char getMyShape(int a, int b)
    {
    	return charCube[a][b];
    }
}
