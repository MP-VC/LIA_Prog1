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
    private Set<Tag> tags;
    private String name;
    public Unit unit;

    /**
     * Constructor for objects of class Ingredients
     */
    public Ingredient(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    public void setSugar(int amount)
    {
        sugar = amount;
    }
    public void setProtein(int amount)
    {
        protein = amount;
    }
    public void setUnit(Unit unit)
    {
        this.unit = unit;
    }
    public void AddVitamin(String name, int value)
    {
        vitamins.put(name, value);
    }
    public void addTags(Tag tag)
    {
        this.tags.add(tag);
    }
    public void removeTags(Tag tag)
    {
        this.tags.remove(tag);
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
        return tags;
    }
    public Unit getUnit()
    {
        return unit;
    }
}
