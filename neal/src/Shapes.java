/**
 *
 * @author Neal
 */
public class Shapes {
    
    private int hitBasis;
    private String group;
    private int subType;
    private String shapeIcon;
    
    public Shapes(String type , int sub, String icon){
        hitBasis = 0; //number of times this shape has been used on basis
        group = type; //the group number this shape belongs to.
        subType = sub; //out of the group what number is this.
        shapeIcon = icon; //the actual shape         
    }
    
    public int getHit(){		//check how many times this shape has been hit on basis
	return hitBasis;
    }
    
    public void hitMarker() {		//add a hit marker on the shape for basis
	hitBasis++;
    }
    
    public String getGroup(){		//what group is the shape from?
	return group;
    }
    
    public int getSubType(){		//out of the group what number is this shape?
	return subType;
    }
    
    public String getShapeIcon(){	//display the icon!
	return shapeIcon;
    }
    
    @Override
    public String toString(){
	return shapeIcon + " " + group + "\n";
    }
    
    
}
