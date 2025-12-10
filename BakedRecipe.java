import java.util.ArrayList;
import java.util.HashMap;
/**
 * Write a description of class BakedRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BakedRecipe extends Recipe
{
    // instance variables - replace the example below with your own
    private int bakeTemperature;
    private String type = "baked";
    /**
     * Constructor for objects of class BakedRecipe
     */
    public BakedRecipe()
    {
    }
    
    public void setBakeTemperature(int temp)
    {
        bakeTemperature = temp;
    }
    public int getBakeTemperature()
    {
        return bakeTemperature;
    }
}
