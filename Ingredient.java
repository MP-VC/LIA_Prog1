import java.util.HashMap;
import java.util.Set;

/**
 * Write a description of class Ingredients here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ingredient
{
    
    private int sugar;
    private int protein;
    private HashMap<String,Integer> vitamins;
    private Set<Tag> tag;
    private String name;
    public Unit unit;

    /**
     * Constructor for objects of class Ingredients
     */
    public Ingredient(String name)
    {
        this.name = name;
    }
    
    public void setSugar(int amount)
    {
        sugar = amount;
    }
    public void setProtein(int amount)
    {
        protein = amount;
    }
    public void AddVitamin(String name, int value)
    {
        vitamins.put(name, value);
    }
    public void setTags(Tag tag)
    {
        this.tag.add(tag);
    }
    
    public int getSugar()
    {
        return sugar;
    }
    public int getProtein()
    {
        return protein;
    }
    public HashMap getVitamins()
    {
        return vitamins;
    }
    public Set getTags()
    {
        return tag;
    }
}
