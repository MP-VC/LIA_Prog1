import java.util.ArrayList;
import java.util.HashMap;
/**
 * Write a description of class FrozenRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FrozenRecipe extends Recipe
{
    // instance variables - replace the example below with your own
    private int meltingPoint;
    private String type = "frozen";
    /**
     * Constructor for objects of class FrozenRecipe
     */
    public FrozenRecipe()
    {
    }
    
    public void setMeltingPoint(int temp)
    {
        meltingPoint = temp;
    }
    public int getMeltingPoint()
    {
        return meltingPoint;
    }
}
