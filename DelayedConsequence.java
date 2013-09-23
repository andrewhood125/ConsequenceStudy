
/**
 * DelayedConsequence is the entry point for the program.
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

public class DelayedConsequence
{
    // instance variables
    private Controller controller;
    
    /**
     * Constructor for objects of class DelayedConsequence
     */
    public DelayedConsequence()
    {
        controller= new Controller();
        
        // If using random show the instruction sheet 
        if(Setup.isRandomPres())
        {
            controller.showInstructionSheet();
        } else {
            // If not give control to the manualProgram method. 
            controller.manualProgram();
        }
    }
    
    
    /**
     * The main method, makes a new instance of DelayedConsequence
     */
    public static void main(String[] args)
    {
        // bootstrap the program. 
        new DelayedConsequence();
    }

}
