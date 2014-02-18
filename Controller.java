/**
 * The Controller is in charge of the logical flow of the program 
 * it interacts with the view and the model to keep the structure organized.
 * 
 * @author Andrew Hood, Neal Patel 
 * @version 2013-09-23
 * 
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

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Queue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Controller
{
    // instance variables
    private View view;
    private Model model;
    private int points;
    private int ptsDed;
    private int[] hitCount;
    private int[][] conditionCount;
    public int dvrcMostPreferred, dvrcLeastPreferred, dvrcLeft, dvrcRight;
    public int dvrMostPreferred, dvrLeastPreferred, dvrLeft, dvrRight;
    public int dcMostPreferred, dcLeastPreferred, dcLeft, dcRight;
    public int icMostPreferred, icLeastPreferred;
    private ArrayList<Condition> conditionArray;
    private Condition dvrc, dvr, dc, ic, lastCondition = null;
    private boolean sound;
    private Queue<String> manualProgramList;
    private boolean instructionSheetShown = false;
    static BufferedWriter writer;
    static int caret;
    
    public Controller()
    {
        Setup.set();
        points = Setup.getPoints();
        ptsDed = Setup.getPtLost();
        view = new View(this);
        model = new Model();
        hitCount  = new int[14];
        conditionCount = new int[4][4];
        conditionArray = new ArrayList<Condition>();
        dvrc = new Condition();
        dvr = new Condition();
        dc = new Condition();
        ic = new Condition();
        sound = false;
        conditionArray.add(dvrc);
        conditionArray.add(dvr);
        conditionArray.add(dc);
        conditionArray.add(ic);
        manualProgramList = Setup.getManualProgram();
        String filename = "" + (System.currentTimeMillis()/10000);
        filename += ".csv";
        try
        {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
        } catch(IOException ex) {
            System.out.println("DEBUG - caught exception making a writer, exiting.");
            System.exit(1);
        }
        
    }
    
    public void writePreferences()
    {
        writeToCSV("Group,Most Preferred, Left, Right, Least Preferred");
        writeToCSV("DVRC," + Model.getMyShape(0,dvrcMostPreferred) + "," + Model.getMyShape(0,dvrcLeft) + "," + Model.getMyShape(0,dvrcRight) + "," + Model.getMyShape(0,dvrcLeastPreferred));
        writeToCSV("DVR," + Model.getMyShape(1,dvrMostPreferred) + "," + Model.getMyShape(1,dvrLeft) + "," + Model.getMyShape(1,dvrRight) + "," + Model.getMyShape(1,dvrLeastPreferred));
        writeToCSV("DC," + Model.getMyShape(2,dcMostPreferred) + "," + Model.getMyShape(2,dcLeft) + "," + Model.getMyShape(2,dcRight) + "," + Model.getMyShape(2,dcLeastPreferred));
        writeToCSV("IC," + Model.getMyShape(3,icMostPreferred) + ",,," + Model.getMyShape(3,dvrcLeastPreferred));
    }
    
    public void calculatePointLoss(int group, int index)
    {
        switch(group)
        {
            case Model.DVRC_ENUM:
                if(index == dvrcMostPreferred)
                {
                    points -= ptsDed;
                    sound = false;
                } else {
                    sound = true;
                }
                break;
            
            case Model.DVR_ENUM:
                if(index == dvrMostPreferred)
                {
                    points -= ptsDed;
                    sound = false;
                } else {
                    sound = true;
                }
                break;
            
            case Model.DC_ENUM: 
                if(index == dcMostPreferred)
                {
                    points -= ptsDed;
                    sound = false;
                } else {
                    sound = true;
                }
                break;
            
            case Model.IC_ENUM:
                if(index == icMostPreferred)
                {
                    points -= ptsDed;
                    sound = false;
                } else {
                    sound = true;
                }
                break;
        }
    }
    
    public char getCharCubeChar(int group, int index)
    {
        return Model.getMyShape(group, index);
    }
    
    public void updatePoints()
    {
        playSound();
        view.setPoints(points);
    }

    public void showInstructionSheet()
    {
        view.setPoints(points);
        view.showInstructionSheet();
    }
    
    public void showBaseline(int group, int left, int right)
    {
        Pair thisPair = new Pair(left, right, group);
        view.establishPreference(model.getLeftChar(thisPair), model.getRightChar(thisPair), thisPair.getGroup(), thisPair.getLeftIndex(), thisPair.getRightIndex());
    }

    public void getBaselineCondition()
    {
        Pair thisPair = model.getRandomPair();
        System.out.println("DEBUG: getBaselineCondition() - invoke view.establishPreference(" + model.getLeftChar(thisPair) + "," +  model.getRightChar(thisPair) + "," +  thisPair.getGroup() + "," + thisPair.getLeftIndex() + "," + thisPair.getRightIndex() + ")");    
        view.establishPreference(model.getLeftChar(thisPair), model.getRightChar(thisPair), thisPair.getGroup(), thisPair.getLeftIndex(), thisPair.getRightIndex());
    }

    public void continueBaselineCondition()
    {
        if(model.isBaselineEstablished() == false)
        {
            Pair thisPair = model.getRandomPair();
            view.establishPreference(model.getLeftChar(thisPair), model.getRightChar(thisPair), thisPair.getGroup(), thisPair.getLeftIndex(), thisPair.getRightIndex());
        } else {
            view.showInstructionSheet();
            setPreference();
            presentCondition();
        }
    }
    
   
    public void presentCondition()
    {
        Condition thisCondition = null;
        Random rand = new Random();
        
        do
        {
            if(conditionArray.size() == 1)
            {
                thisCondition = conditionArray.get(0);
                break;
            } else if(conditionArray.size() > 1) {
                thisCondition= conditionArray.get(rand.nextInt(conditionArray.size()));
            }
        } while(lastCondition == thisCondition);
        
        if(thisCondition == null)
        {
            view.gameOver(points);
            return;
        }
        
        lastCondition = thisCondition;
        thisCondition.incrementTimesShown();
            
        if(thisCondition.getTimesShown() > 6)
        {
            conditionArray.remove(thisCondition);
        }
            
        if(thisCondition == dvrc)
        {
            view.dvrc(Model.getMyShape(Model.DVRC_ENUM, dvrcMostPreferred), Model.getMyShape(Model.DVRC_ENUM, dvrcLeastPreferred), Model.DVRC_ENUM, dvrcMostPreferred, dvrcLeastPreferred);
        }
        
        if(thisCondition == dvr)
        {
            view.dvr(Model.getMyShape(Model.DVR_ENUM, dvrMostPreferred), Model.getMyShape(Model.DVR_ENUM, dvrLeastPreferred), Model.DVR_ENUM, dvrMostPreferred, dvrLeastPreferred);
        }
        
        if(thisCondition == dc)
        {
            view.dc(Model.getMyShape(Model.DC_ENUM, dcMostPreferred), Model.getMyShape(Model.DC_ENUM, dcLeastPreferred), Model.DC_ENUM, dcMostPreferred, dcLeastPreferred);
        }
        
        if(thisCondition == ic)
        {
            view.ic(Model.getMyShape(Model.IC_ENUM, icMostPreferred), Model.getMyShape(Model.IC_ENUM, icLeastPreferred), Model.IC_ENUM, icMostPreferred, icLeastPreferred);
        }
    }

    public void setPreference()
    {
        // DVRC
        int max, min;

        max = 0;
        min = 0;
        boolean middleSet = false;
        
        for(int i = 0; i < 4; i++)
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
        
        for(int j = 0; j < 4; j++)
        {
            if(middleSet) 
            {
                if(j != max && j!= min)
                {
                    dvrcLeft = j;
                }
            } else {
                if(j != max && j!= min)
                {
                    dvrcRight = j;
                    middleSet = true;
                }
                
            }
        }
        
        dvrcMostPreferred = max;
        dvrcLeastPreferred = min;

        max = 4;
        min = 4;
        for(int i = 4; i < 8; i++)
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
        middleSet = false;
         for(int j = 4; j < 8; j++)
        {
            if(middleSet) 
            {
                if(j != max && j!= min)
                {
                    dvrLeft = j-4;
                }
            } else {
                if(j != max && j!= min)
                {
                    dvrRight = j-4;
                    middleSet = true;
                }
                
            }
        }
        dvrMostPreferred = max-4;
        dvrLeastPreferred = min-4;

        max = 8;
        min = 8;
        for(int i = 8; i < 12; i++)
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
        
        middleSet = false;
         for(int j = 8; j < 12; j++)
        {
            if(middleSet) 
            {
                if(j != max && j!= min)
                {
                    dcLeft = j-8;
                }
            } else {
                if(j != max && j!= min)
                {
                    dcRight = j-8;
                    middleSet = true;
                }
                
            }
        }
        
        dcMostPreferred = max-8;
        dcLeastPreferred = min-8;

        max = 12;
        min = 12;
        for(int i = 12; i < 14; i++)
        {
            if(hitCount[i] > hitCount[max]) 
            {
                // This index is higher than what is at index max. 
                max = i;
            } 
        }
        
        if(max-12 == 0)
        {
            icMostPreferred = max-12;
            icLeastPreferred = 1;
        } else {
            icMostPreferred = 1;
            icLeastPreferred = 0;
        }
    }
    
    public int getDVRCleft()
    {
        return dvrcLeft;
    }
    
    public int getDVRCright()
    {
        return dvrcRight;
    }
    
    public int getDVRleft()
    {
        return dvrLeft;
    }
    
    public int getDVRright()
    {
        return dvrRight;
    }
    
    public int getDCleft()
    {
        return dcLeft;
    }
    
    public int getDCright()
    {
        return dcRight;
    }

    public void incrementHitCount(int group, int index)
    {
        int hitCountIndex = group*4+index;
        hitCount[hitCountIndex]++;
    }
    
    public void incrementConditionCount(int group, int index)
    {
        conditionCount[group][index]++;
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
    
    public void printConditionStats()
    {
        for(int i = 0; i < conditionCount.length; i++)
        {
            for(int j = 0; j < conditionCount[i].length; j++)
            {
                if(i == 3 && j == 2)
                {
                    break;
                }
                
                switch(i)
                {
                    case 0: System.out.print("\tDVRC index[" + j + "]:" + conditionCount[i][j]); break;
                    case 1: System.out.print("\tDVR index[" + j + "]:" + conditionCount[i][j]); break;
                    case 2: System.out.print("\tDC index[" + j + "]:" + conditionCount[i][j]); break;
                    case 3: System.out.print("\tIC index[" + j + "]:" + conditionCount[i][j]); break;
                }
            }
            System.out.println();
        }
    }
    
    public void playSound()
    {
        if(sound == false)
        {
            View.playLossSound();
        }
        else
        {
            View.playWinSound();
        }
    }
    
    
    public void beginDvrcSequence()
    {
        view.dvrc(Model.getMyShape(Model.DVRC_ENUM, dvrcMostPreferred), Model.getMyShape(Model.DVRC_ENUM, dvrcLeastPreferred), Model.DVRC_ENUM, dvrcMostPreferred, dvrcLeastPreferred);
    }
    
    public void beginDvrSequence()
    {
        view.dvr(Model.getMyShape(Model.DVR_ENUM, dvrMostPreferred), Model.getMyShape(Model.DVR_ENUM, dvrLeastPreferred), Model.DVR_ENUM, dvrMostPreferred, dvrLeastPreferred);
    }
    
    public void beginDcSequence()
    {
        view.dc(Model.getMyShape(Model.DC_ENUM, dcMostPreferred), Model.getMyShape(Model.DC_ENUM, dcLeastPreferred), Model.DC_ENUM, dcMostPreferred, dcLeastPreferred);
    }
    
    public void beginIcSequence()
    {
        view.ic(Model.getMyShape(Model.IC_ENUM, icMostPreferred), Model.getMyShape(Model.IC_ENUM, icLeastPreferred), Model.IC_ENUM, icMostPreferred, icLeastPreferred);
    }
    
    public void delayView(int sleepTime)
    {
        view.delayView(sleepTime);
    }
    
    public void gameOver()
    {
        view.gameOver(points);
    }
    
    
    public void manualProgram()
    {
        if(instructionSheetShown)
        {
            if(manualProgramList.peek() != null)
            {
                String line = manualProgramList.remove();
                String[] lineArray = line.split(",");
                if(lineArray[0].equals("BASELINE_DVRC"))
                {
                    view.setBeginPanelColorDefault();
                    showBaseline(Model.DVRC_ENUM, Integer.parseInt(lineArray[1].trim()), Integer.parseInt(lineArray[2].trim()));
                } else if(lineArray[0].equals("START_BASELINE_DVRC") || lineArray[0].equals("START_BASELINE_DVR") || 
                            lineArray[0].equals("START_BASELINE_DC") || lineArray[0].equals("START_BASELINE_IC")) {
                    writeToCSV("GROUP,SELECTED,NOT SELECTED");
                }else if(lineArray[0].equals("BASELINE_DVR")) {
                     view.setBeginPanelColorDefault();
                    showBaseline(Model.DVR_ENUM, Integer.parseInt(lineArray[1].trim()), Integer.parseInt(lineArray[2].trim()));
                } else if(lineArray[0].equals("BASELINE_DC")) {
                     view.setBeginPanelColorDefault();
                    showBaseline(Model.DC_ENUM, Integer.parseInt(lineArray[1].trim()), Integer.parseInt(lineArray[2].trim()));
                } else if(lineArray[0].equals("BASELINE_IC")) { 
                     view.setBeginPanelColorDefault();
                    showBaseline(Model.IC_ENUM, Integer.parseInt(lineArray[1].trim()), Integer.parseInt(lineArray[2].trim()));
                } else if(lineArray[0].equals("DVRC_SEQUENCE")) { 
                    setPreference(); beginDvrcSequence(); 
                } else if(lineArray[0].equals("DVR_SEQUENCE")) { 
                    setPreference(); beginDvrSequence(); 
                } else if(lineArray[0].equals("DC_SEQUENCE")) { 
                    setPreference(); beginDcSequence(); 
                } else if(lineArray[0].equals("IC_SEQUENCE")) { 
                    setPreference(); beginIcSequence(); 
                } else if(lineArray[0].equals("DELAY")) {
                    int sleepTime = 0;
                    try {
                        sleepTime = Integer.parseInt(lineArray[1].trim());
                    } catch(Exception ex) {
                        view.crashDialog("Could not parse delay length.");
                        System.exit(1);
                    }
                    // Sleep for lineArray[1] milliseconds
                    delayView(sleepTime);
                }else { 
                    manualProgram();
                }
            } else {
                gameOver();
            }
        } else {
            instructionSheetShown = true;
            view.setPoints(Setup.getPoints());
            view.showInstructionSheet();
        }
    } 
    
    public static void writeToCSV(String s)
    {
        try
        {
            writer.write(s + "\n");
        } catch(IOException e) {
            System.out.println("DEBUG - writeToCSV()");
            System.exit(1);
        }
        
    }
    
    public static void closeCSV()
    {
        try {writer.close();} catch (Exception ex) {}
    }
}
