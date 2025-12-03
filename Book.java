import java.util.HashMap;
import java.util.Date;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collection;

/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    private HashMap<String,Recipe> recipe;
    private String author;
    private Date dayPublished;
    /**
     * Constructor for objects of class Book
     */
    public Book(String author)
    {
       this.author = author;
       dayPublished = new Date();
       recipe = new HashMap<>();
    }
    
    public HashMap<String, Recipe> getRecipes()
    {
        return recipe;
    }
    
    public Recipe addRecipe(String name)
    {
        Recipe r = new Recipe();
        recipe.put(name,r);
        return r;
    }
       
    public void printBookDetails()
    {
        System.out.println("Author: " + author);
        System.out.println("Publish date: " + dayPublished);
    }
    public void listAllRecipes()
    {
        Set<String> recipeName = recipe.keySet();
        for(String food : recipeName)
        {
            System.out.println(food);
        }
    }
    public boolean filterByTag(String filter)
    {
        Collection<Recipe> filterCheck = recipe.values();
        for(Recipe rec : filterCheck)
        {
            if(rec.getIngredient().contains(filter)){
                return true;
            }
        }
        return false;
    }
}
