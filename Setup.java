/**
 * The Setup class collects data from the config files. 
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;
import java.util.Queue;


public class Setup
{
    private static ArrayList<String> introTextScreen;           //The text that will be shown at the start of the program
    private static ArrayList<String> conf;                      //The configuration file contents
    private static int readingDuration;                         //In SEC how long does the intermission stay up
    private static int numOfPoints;                             //The number of points that the person has left. 
    private static char[] dvrc;
    private static char[] dvr;
    private static char[] dc;
    private static char[] ic;
    private static int ptLost;
    private static boolean soundPos;
    private static boolean soundNeg;
    private static int basePause;
    private static int[] baseColor = new int[3];
    private static int symbolSize;
    private static int feedbackFont;
    private static int feedbackDelay;
    private static boolean randomPres;
    private static int baselinePres;
    private static File dcLeast = new File("dcLeast.txt");
    private static File dcMost = new File("dcMost.txt");
    private static File dvrcLeast = new File("dvrcLeast.txt");
    private static File dvrMost = new File("dvrMost.txt");
    private static File dvrLeast = new File("dvrLeast.txt");
    private static File icLeast = new File("icLeast.txt");
    private static File icMost = new File("icMost.txt");
    private static ArrayList<String> dcLeastTXT;
    private static ArrayList<String> dcMostTXT;
    private static ArrayList<String> dvrcLeastTXT;
    private static ArrayList<String> dvrMostTXT;
    private static ArrayList<String> dvrLeastTXT;
    private static ArrayList<String> icLeastTXT;
    private static ArrayList<String> icMostTXT;
    private static ArrayList<String> reading;
    private static File readingPath = new File("readingText.txt");
    
    public static void set()
    {
        conf = new ArrayList<>();
        readConf();
        parseConf();
        setITS();
        setTexts();
    }

    private static void readConf()
    {                //to read in the config
        FileInputStream fis = null;                             //read in config
        InputStreamReader isr = null;                           //read in config
        BufferedReader br = null;                               //read in config
        try {                                                   //try to read in
            File cFile = new File("config.txt");                //Make it a file obj
            String path = cFile.getAbsolutePath();              //get the abs path of the file
            fis = new FileInputStream(cFile);                   //start to read in
            isr = new InputStreamReader(fis, "UTF-8");          //UTF-8 encoding for the special chars
            br = new BufferedReader(isr);                       //read in
            String line;                                        //new string 
            while((line = br.readLine())!= null) {              //add all of the strings to the arraylist
                conf.add(line);                                //add
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {     //catch block
            Logger.getLogger(DelayedConsequence.class.getName()).log(Level.SEVERE, null, ex); //catch block
        } catch (IOException ex) {                                              //catch block
            Logger.getLogger(DelayedConsequence.class.getName()).log(Level.SEVERE, null, ex); //catch block
        } finally {                                                             //close all of the readers
            try {
                fis.close();                                                    //close
                isr.close();                                                    //close
                br.close();                                                     //close
            } catch (IOException ex) {                                          //catch
                Logger.getLogger(DelayedConsequence.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }                                   //return
    }

    private static void parseConf()
    {                       //parse all of the text in the config
        for(int o = 0; o < conf.size(); o++){
            int index = conf.get(o).indexOf("=");               //keep a count of where the delim is for everything but shapes.
            int index2 = conf.get(o).indexOf(";");
            index++;
            switch(o){
            case 0:String temp = conf.get(o).substring(index , index2).trim();
            setShapes(o, temp);
            break;
            case 1:temp = conf.get(o).substring(index , index2).trim();
            setShapes(o, temp);
            break;
            case 2:temp = conf.get(o).substring(index , index2).trim();
            setShapes(o, temp);
            break;
            case 3:temp = conf.get(o).substring(index , index2).trim();
            setShapes(o, temp);
            break;
            case 4:readingDuration = Integer.parseInt(conf.get(4).substring(index,index2).trim());
            break;
            case 5:numOfPoints = Integer.parseInt(conf.get(5).substring(index,index2).trim()); 
            break;
            case 6:ptLost = Integer.parseInt(conf.get(6).substring(index,index2).trim());
            break;
            case 7:soundPos = Boolean.parseBoolean(conf.get(7).substring(index, index2).trim().toLowerCase());
            break;
            case 8:soundNeg = Boolean.parseBoolean(conf.get(8).substring(index, index2).trim().toLowerCase());
            break;
            case 9:basePause = Integer.parseInt(conf.get(9).substring(index, index2).trim());
            break;
            case 10:String[] rgb = conf.get(10).substring(index, index2).trim().split(",");
                baseColor[0] = Integer.parseInt(rgb[0]);
                baseColor[1] = Integer.parseInt(rgb[1]);
                baseColor[2] = Integer.parseInt(rgb[2]);
            break;
            case 11:symbolSize = Integer.parseInt(conf.get(11).substring(index, index2).trim());
            break;
            case 12:feedbackFont = Integer.parseInt(conf.get(12).substring(index, index2).trim());
            break;
            case 13:feedbackDelay = Integer.parseInt(conf.get(13).substring(index, index2).trim());
            break;
            case 14:randomPres = Boolean.parseBoolean(conf.get(14).substring(index, index2).trim().toLowerCase());
            break;
            case 15:baselinePres = Integer.parseInt(conf.get(15).substring(index, index2).trim());
            break;  
            }  
        }
    }

    private static ArrayList<String> reader(File txt)
    {         //read in the different types of text files with no special encoding
        ArrayList<String> lines = new ArrayList<>();            //make a temp arraylist
        try {
            Scanner scan = new Scanner(txt);                //scan it in
            while(scan.hasNext()){                  //while there is a line
                lines.add(scan.nextLine());             //ADD
            }
        } catch (FileNotFoundException ex) {                //catch
            Logger.getLogger(DelayedConsequence.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lines;                           //return arraylist of the text file
    }

    private static void setITS()
    {                  //setter for the Intro text
        introTextScreen = reader(new File("introText.txt"));
    }

    public static ArrayList<String> getITS()
    {              //getter for the intro text
        return introTextScreen;
    }

    public static int getPoints()
    {                 //getter for the points
        return numOfPoints;
    }

    public static void decPoints(int decrement)
    {           //when the user loses points
        if(numOfPoints > decrement){                    //as long as the user has points to give it will happen
            numOfPoints = numOfPoints - decrement;
        }
        else{                               //if not then user is stuck at 0.
            numOfPoints = 0;
        }   
    }

    public static void setShapes(int a , String s)
    {
        if(a == 0){
            dvrc = s.toCharArray();
        }else if (a == 1){
            dvr= s.toCharArray();
        }else if (a == 2){
            dc= s.toCharArray();
        }else if (a == 3){
            ic= s.toCharArray();
        }else{}
    }

    public static char[] getShapes(int a)
    {
        if(a == 0){
            return dvrc;
        }else if (a == 1){
            return dvr;
        }else if (a == 2){
            return dc;
        }else if (a == 3){
            return ic;
        }else{
            return null;
        }
    }

    public static int getRD()
    {
        return (readingDuration * 1000);
    }

    public static int getPtLost()
    {
        return ptLost;
    }

    public static boolean isSoundPos()
    {
        return soundPos;
    }

    public static boolean isSoundNeg() 
    {
        return soundNeg;
    }

    public static int getBasePause() 
    {
        return basePause;
    }

    public static int[] getBaseColor() 
    {
        return baseColor;
    }

    public static int getSymbolSize() 
    {
        return symbolSize;
    }

    public static int getFeedbackFont()
    {
        return feedbackFont;
    }

    public static int getFeedbackDelay() 
    {
        return feedbackDelay;
    }

    public static boolean isRandomPres() 
    {
        return randomPres;
    }

    public static int getBaselinePres()
    {
        return baselinePres;
    }
    
    public static void setTexts()
    {
        dcLeastTXT = reader(dcLeast);
        dcMostTXT = reader(dcMost);
        dvrcLeastTXT = reader(dvrcLeast);
        dvrMostTXT = reader(dvrMost);
        dvrLeastTXT = reader(dvrLeast);
        icLeastTXT = reader(icLeast);
        icMostTXT = reader(icMost);
        reading = reader(readingPath);
    }
    
    public static String getDcLeastTXT() 
    {
        StringBuilder returnString = new StringBuilder();
        if(dcLeastTXT == null)
        {
            setTexts();
            System.out.println(dcLeastTXT);
        }
        
        for(int i = 0; i < dcLeastTXT.size(); i++)
        {
            returnString.append(dcLeastTXT.get(i));
        }
        return returnString.toString();
    }

    public static String getDcMostTXT() 
    {
        StringBuilder returnString = new StringBuilder();
        if(dcMostTXT == null)
        {
            setTexts();
            System.out.println(dcMostTXT);
        }
        
        for(int i = 0; i < dcMostTXT.size(); i++)
        {
            returnString.append(dcMostTXT.get(i));
        }
        return returnString.toString();
    }

    public static String getDvrcLeastTXT()
    {
        StringBuilder returnString = new StringBuilder();
        if(dvrcLeastTXT == null)
        {
            setTexts();
            System.out.println(dvrcLeastTXT);
        }
        
        for(int i = 0; i < dvrcLeastTXT.size(); i++)
        {
            returnString.append(dvrcLeastTXT.get(i));
        }
        return returnString.toString();
    }
    

    public static String getDvrMostTXT()
    {
        StringBuilder returnString = new StringBuilder();
        if(dvrMostTXT == null)
        {
            setTexts();
            System.out.println(dvrMostTXT);
        }
        
        for(int i = 0; i < dvrMostTXT.size(); i++)
        {
            returnString.append(dvrMostTXT.get(i));
        }
        return returnString.toString();
    }

    public static String getDvrLeastTXT() 
    {
        StringBuilder returnString = new StringBuilder();
        if(dvrLeastTXT == null)
        {
            setTexts();
            System.out.println(dvrLeastTXT);
        }
        
        for(int i = 0; i < dvrLeastTXT.size(); i++)
        {
            returnString.append(dvrLeastTXT.get(i));
        }
        return returnString.toString();
    }

    public static String getIcLeastTXT()
    {
        StringBuilder returnString = new StringBuilder();
        if(icLeastTXT == null)
        {
            setTexts();
            System.out.println(icLeastTXT);
        }
        
        for(int i = 0; i < icLeastTXT.size(); i++)
        {
            returnString.append(icLeastTXT.get(i));
        }
        return returnString.toString();
    }

    public static String getIcMostTXT() 
    {
        StringBuilder returnString = new StringBuilder();
        if(icMostTXT == null)
        {
            setTexts();
            System.out.println(icMostTXT);
        }
        
        for(int i = 0; i < icMostTXT.size(); i++)
        {
            returnString.append(icMostTXT.get(i));
        }
        return returnString.toString();
    }
    
    public static ArrayList<String> getRI() 
    {
        return reading;
    }
    
    public static LinkedList<String> getManualProgram()
    {
        LinkedList<String> program = new LinkedList<String>();
        try {
            Scanner scan = new Scanner(new File("program.txt"));                //scan it in
            while(scan.hasNext()){                  //while there is a line
                program.add(scan.nextLine());             //ADD
            }
        } catch (FileNotFoundException ex) {                //catch
            System.out.println("program.txt not found. Shutting down.");
            System.exit(1);
        }        
        return program;     
    }
    
}
