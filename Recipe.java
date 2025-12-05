
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;

/**
 * Write a description of class Recipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recipe
{
    // instance variables - replace the example below with your own
    private HashMap<Ingredient,Double> ingredients;
    private ArrayList<String> instruction;
    private double portion;
    private String contents;
    private ArrayList<Integer> rating;
    private boolean toDisplay = true;

    /**
     * Constructor for objects of class Recipe
     */
    public Recipe()
    {
         ingredients = new HashMap<>();
         instruction = new ArrayList<>();
    }
    
    public void addIngredient(Ingredient i,double amount)
    {
        ingredients.put(i,amount);
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
    public void setToDisplay(boolean bool) { toDisplay = bool; }
    public void modifyInstruction(int stepNum,String instruction)
    {
        this.instruction.set(stepNum,instruction);
    }
    
    public String getInstruction(int instructionNB)
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
    public int getInstructionSize()
    {
        return instruction.size();
    }
    public boolean getToDisplay(){return toDisplay;}
    
    
    public double getAverageRating()
    {
        double sum = 0;
        //loop through the ratings ArrayList adding the integers to a sum, then divide by the lenght
        for(int star : rating)
        {
            sum = sum + star;
        }
        return sum/(double)rating.size();
    }
    public void listAllIngredients()
    {
        System.out.println(ingredients.toString());
    }
    public Set<Ingredient> getIngredients()
    {
        return ingredients.keySet();
    }
}
