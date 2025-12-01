
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a description of class Recipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recipe
{
    // instance variables - replace the example below with your own
    private HashMap<Ingredient,Double> ingredient;
    private ArrayList<String> instruction;
    private double portion;
    private String contents;
    private ArrayList<Integer> rating;

    /**
     * Constructor for objects of class Recipe
     */
    public Recipe(HashMap<Ingredient,Double> ingredient,ArrayList<String> instruction, double portion,ArrayList<Integer> rating)
    {
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.portion = portion;
        this.contents = contents;
        this.rating = rating;
    }
    
    public void addIngredient(Ingredient i,double amount)
    {
        ingredient.put(i,amount);
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
    public void setNumberOfPortions(double nbOfPortion)
    {
        portion = nbOfPortion;
    }
    public void modifyInstruction(int stepNum,String instruction)
    {
        this.instruction.set(stepNum,instruction);
    }
    
       public String getInstrution(int instructionNB)
    {
        return instruction.get(instructionNB);
    }
    public int getRating(int i)
    {
        return this.rating.get(i);
    }
    public double getNumberOfPortions()
    {
        return portion;
    }
    
    public int averageRating()
    {
        int sum = 0;
        //loop through the ratings ArrayList adding the integers to a sum, then divide by the lenght
        return sum;
    }
}
