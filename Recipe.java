
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.Map;
import java.util.HashSet;

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
    private boolean toDisplay = true;
    private String type = "normal";
    /**
     * Constructor for objects of class Recipe
     */
    public Recipe()
    {
        ingredient = new HashMap<>();
        instruction = new ArrayList<>();
        rating = new ArrayList<>();
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
    
    public int getRatingSize()
    {
        return rating.size();
    }
    
    public String getType()
    {
        return type;
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

    public int getAverageRating()
    {
        double sum = 0;
        if(rating.size() == 0)
        {
            return 0;
        }
        //loop through the ratings ArrayList adding the integers to a sum, then divide by the lenght
        for(int star : rating)
        {
            sum = sum + star;
        }
        return (int)Math.round(sum/(double)rating.size());
    }

    public void listAllIngredients()
    {
        System.out.println(ingredient.toString());
        for(Map.Entry<Ingredient,Double> set : ingredient.entrySet())
        {
            System.out.println("Ingredient: "+set.getKey());
            System.out.print(" " + set.getValue() + " " + set.getKey().getUnit().toString());
        }
    }

    public Set<Ingredient> getIngredients()
    {
        return ingredient.keySet();
    }
    
    public Set<Tag> getAllTag()
    {
        HashSet<Tag> all = new HashSet<>();
        for(Map.Entry<Ingredient,Double> set : ingredient.entrySet())
        {
            all.addAll(set.getKey().getTags());
        }
        return all;
    }
}
