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
    private HashMap<Ingredient,Double> ingredient;
    private ArrayList<String> instruction;
    private double portion;
    private String contents;
    private ArrayList<Integer> rating;

    /**
     * Constructor for objects of class BakedRecipe
     */
    public BakedRecipe(HashMap<Ingredient,Double> ingredient,ArrayList<String> instruction, double portion,ArrayList<Integer> rating)
    {
        super(ingredient,instruction,portion,rating);
    }
}
