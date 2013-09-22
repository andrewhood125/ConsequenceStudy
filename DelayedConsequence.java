
/**
 * Write a description of class DelayedConsequence here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Queue;

public class DelayedConsequence
{
    Controller controller;
    public DelayedConsequence()
    {
        System.out.println("DEBUG: main() - making a new controller.");
        controller= new Controller();
        
        if(Setup.isRandomPres())
        {
            System.out.println("DEBUG: main() - show instruction sheet.");
            controller.showInstructionSheet();
        } else {
            controller.manualProgram();
        }
    }
    
    public static void main(String[] args)
    {
        new DelayedConsequence();
    }

}
