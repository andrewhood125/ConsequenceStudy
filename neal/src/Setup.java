
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
    private static ArrayList<Shapes> shapeList;			//list of all possible shape objects
    private static ArrayList<Shapes[]> basisList;		//basis list (10 of each letter)
    private static int readingDuration;                         //In SEC how long does the intermission stay up
    private static int numOfGroups;                             //The number of groups that will be in the program.
    private static int numOfPoints;				//The number of points that the person has left. 
    private static int basisCounter;			//counter for the basis step
    
    public static void set(){
	shapeList = new ArrayList<>();
	conf = new ArrayList<>();
	readConf();
	parseConf();
	setITS();
	setRI();
	basisCounter = 0;
    }
    
    private static void readConf() {				//to read in the config
        FileInputStream fis = null;                             //read in config
        InputStreamReader isr = null;                           //read in config
        BufferedReader br = null;                               //read in config
        try {                                                   //try to read in
            File cFile = new File("config.txt");                //Make it a file obj
            //String path = cFile.getAbsolutePath();            //get the abs path of the file
            fis = new FileInputStream(cFile);                   //start to read in
            isr = new InputStreamReader(fis, "UTF-8");          //UTF-8 encoding for the special chars
            br = new BufferedReader(isr);                       //read in
            String line;                                        //new string 
            while((line = br.readLine())!= null) {              //add all of the strings to the arraylist
                conf.add(line);                                //add
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {     //catch block
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); //catch block
        } catch (IOException ex) {                                              //catch block
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); //catch block
        } finally {                                                             //close all of the readers
            try {
                fis.close();                                                    //close
                isr.close();                                                    //close
                br.close();                                                     //close
            } catch (IOException ex) {                                          //catch
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }									//return
    }
    
    private static void parseConf() {						//parse all of the text in the config
        for(int i = 0; i < conf.size(); i++){					//read all of the lines 
            int index = conf.get(i).indexOf("=");				//keep a count of where the delim is for everything but shapes.
	    String name;							//temp string for name of shape catagory
	    String[] shapeIcon;							//after splitting needs string array
            if(conf.get(i).startsWith("Reading")) {				//to config the amount of SEC to wait
                readingDuration = Integer.parseInt(conf.get(i).substring(index));   //read in the int and modify the global var.
            }
            if(conf.get(i).startsWith("#")) {					//to config the number of groups.
                numOfGroups = Integer.parseInt(conf.get(i).substring(index+2));	//update the global var
            }
            if(conf.get(i).startsWith("-Start")) {				//start reading in the different groups
		int temp2 = i + 1 + numOfGroups;
                for(int j = i+1; j < temp2; j++) {						//i is at delim line, so j needs to start 1 after to read in first group
		    name = conf.get(j).substring(0, conf.get(j).indexOf("="));			//from start of the line to the delim = is the name of the group
		    String temp = conf.get(j).substring(conf.get(j).indexOf("=")+1);		//make a new string that is everything after the delim =
		    shapeIcon = temp.split(",");						//split the string into parts with delim ,
		    for(int k = 0; k < shapeIcon.length; k++){					//new for loop to read in the split up icons 
			shapeList.add(new Shapes(name.trim() , k , shapeIcon[k].trim()));	//add to the ArrayList of shapes with proper name, number in group, and icon from text file.
		    }
		}	
            }
	    if(conf.get(i).startsWith("Starting")) {						//set the starting points
		numOfPoints = Integer.parseInt(conf.get(i).substring(index + 1).trim());		//from the config file.
	    }
        }
    }
    
    private static ArrayList<String> reader (File txt){			//read in the different types of text files with no special encoding
        ArrayList<String> lines = new ArrayList<>();			//make a temp arraylist
        try {
            Scanner scan = new Scanner(txt);				//scan it in
            while(scan.hasNext()){					//while there is a line
                lines.add(scan.nextLine());				//ADD
            }
        } catch (FileNotFoundException ex) {				//catch
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lines;							//return arraylist of the text file
    }
        
    private static void setITS() {					//setter for the Intro text
        introTextScreen = reader(new File("introText.txt"));
    }
    
    private static void setRI() {
        readingIntermission = reader(new File("readingText.txt"));	//setter for the intermission text
    }
    
    public static ArrayList<String> getITS() {				//getter for the intro text
        return introTextScreen;
    }
    
    public static ArrayList<String> getRI() {				//getter for the Intermission text
        return readingIntermission;
    }
    
    public static int getPoints() {					//getter for the points
	return numOfPoints;
    }
        
    public static void decPoints(int decrement) {			//when the user loses points
	if(numOfPoints > decrement){					//as long as the user has points to give it will happen
	    numOfPoints = numOfPoints - decrement;
	}
	else{								//if not then user is stuck at 0.
	    numOfPoints = 0;
	}	
    }
    
    public static void addBasisCounter() {
	basisCounter++;
    }
    
    public static int getBasisCount() {
	return basisCounter;
    }
    
    public static ArrayList<Shapes[]> getBasis(){
	return basisList;
    }
    
    public static ArrayList<Shapes> getShapes(){
	return shapeList;
    }
    
    public static int getRD(){
	return readingDuration * 1000;
    }
}
