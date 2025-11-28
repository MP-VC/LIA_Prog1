import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

/**
 * Write a description of class Recipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recipe
{
    // instance variables - replace the example below with your own
    private HashMap<Ingredient, Integer> ingredients;
    private ArrayList<String> instruction;
    private int portions;
    private String contents;
    private ArrayList<Integer> rating;

    /**
     * Constructor for objects of class Recipe
     */
    public Recipe()
    {
        
    }
    
    public void addIngredient(Ingredient i, Integer quantity)
    {
        ingredients.put(i, quantity);
    }
    public void addInstrution(String instruction)
    {
        this.instruction.add(instruction);
    }
    public void addRating(int rating)
    {
        if(!(rating>10||rating<0))
        {
            this.rating.add(rating);
        }
    }
    public void setNumberOfPortions(int nbOfPortion)
    {
        portions = nbOfPortion;
    }
    public void modifyInstruction(int stepNum,String instruction)
    {
        this.instruction.set(stepNum,instruction);
    }
    
    public Ingredient getIngredient(Ingredient i)
    {
        Set<Ingredient> key = ingredients.keySet();
        for (Ingredient ingredient : key){
            if (i.equals(ingredient)){
                return i;
            }
        }
        return null;
    }
    public void getInstrution(String instruction)
    {
        this.instruction.add(instruction);
    }
    public void getRating(int rating)
    {
        this.rating.add(rating);
    }
    public void getNumberOfPortions(int nbOfPortiond)
    {
        portions = nbOfPortiond;
    }
    
    public int averageRating()
    {
        int sum = 0;
        //loop through the ratings ArrayList adding the integers to a sum, then divide by the lenght
        return sum;
    }
}
