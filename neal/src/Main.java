/**
 *
 * @author Neal
 */
public class Main {
    
    @SuppressWarnings("empty-statement")
    public static void main (String[] args){			 //MAIN       
        Setup.set();						//setup the classes
	CardsGUI iF = new CardsGUI();				//start the intro frame
        iF.setVisible(true);					//make it visible
    }
}