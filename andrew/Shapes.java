
/**
 * A class designed to hold 2 or 4 symbols it can be instantiated multiple times to 
 * hold dvrc, dvr, dc and ic. 
 * 
 * @author Andrew Hood
 * @version (a version number or a date)
 */
public class Shapes
{
    // instance variables - replace the example below with your own
    char[] symbols;

    /**
     * Constructor for objects of class Shapes
     */
    public Shapes(char x, char y)
    {
        symbols = new char[] {x,y};
    }
    
    public Shapes(char x, char y, char z, char e)
    {
        symbols = new char[] {x,y,z,e};
    }
    
}
