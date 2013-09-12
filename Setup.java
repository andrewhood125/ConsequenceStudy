/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 * Neal
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

/**
 *
 * @author
 * Neal
 */
public class Setup {
	private static ArrayList<String> introTextScreen;           //The text that will be shown at the start of the program
	private static ArrayList<String> readingIntermission;       //The text that will be show at the intermission(Screen 3)
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
	private static int baseColor;
	private static int symbolSize;
	private static int feedbackFont;
	private static int feedbackDelay;
	private static boolean randomPres;
	private static int baselinePres;

	public static void set(){
		conf = new ArrayList<>();
		readConf();
		parseConf();
		setITS();
		setRI();
	}

	private static void readConf() {                //to read in the config
		FileInputStream fis = null;                             //read in config
		InputStreamReader isr = null;                           //read in config
		BufferedReader br = null;                               //read in config
		try {                                                   //try to read in
			File cFile = new File("config.txt");                //Make it a file obj
			String path = cFile.getAbsolutePath();            //get the abs path of the file
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

	private static void parseConf() {                       //parse all of the text in the config
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
			case 10:baseColor = Integer.parseInt(conf.get(10).substring(index, index2).trim());
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

	private static ArrayList<String> reader (File txt){         //read in the different types of text files with no special encoding
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

	private static void setITS() {                  //setter for the Intro text
		introTextScreen = reader(new File("introText.txt"));
	}

	private static void setRI() {
		readingIntermission = reader(new File("readingText.txt"));  //setter for the intermission text
	}

	public static ArrayList<String> getITS() {              //getter for the intro text
		return introTextScreen;
	}

	public static ArrayList<String> getRI() {               //getter for the Intermission text
		return readingIntermission;
	}

	public static int getPoints() {                 //getter for the points
		return numOfPoints;
	}

	public static void decPoints(int decrement) {           //when the user loses points
		if(numOfPoints > decrement){                    //as long as the user has points to give it will happen
			numOfPoints = numOfPoints - decrement;
		}
		else{                               //if not then user is stuck at 0.
			numOfPoints = 0;
		}   
	}

	public static void setShapes(int a , String s){
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

	public static char[] getShapes(int a){
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

	public static int getRD(){
		return (readingDuration * 1000);
	}

	public static int getPtLost() {
		return ptLost;
	}

	public static boolean isSoundPos() {
		return soundPos;
	}

	public static boolean isSoundNeg() {
		return soundNeg;
	}

	public static int getBasePause() {
		return basePause;
	}

	public static int getBaseColor() {
		return baseColor;
	}

	public static int getSymbolSize() {
		return symbolSize;
	}

	public static int getFeedbackFont() {
		return feedbackFont;
	}

	public static int getFeedbackDelay() {
		return feedbackDelay;
	}

	public static boolean isRandomPres() {
		return randomPres;
	}

	public static int getBaselinePres() {
		return baselinePres;
	}
	
}
