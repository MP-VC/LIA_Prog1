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
    private HashMap<Ingredient,Double> ingredient;
    private ArrayList<String> instruction;
    private double portion;
    private String contents;
    private ArrayList<Integer> rating;
    
    /**
     * Constructor for objects of class FrozenRecipe
     */
    public FrozenRecipe()
    {
    }
}
