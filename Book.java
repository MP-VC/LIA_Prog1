import java.util.HashMap;
import java.util.Date;
import java.util.ArrayList;
import java.util.Set;

/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    private HashMap<String,Recipe> recipes;
    private String author;
    private Date dayPublished;
    /**
     * Constructor for objects of class Book
     */
    public Book(String author)
    {
       this.author = author;
       dayPublished = new Date();
       recipes = new HashMap<>();
    }
    
    public HashMap<String, Recipe> getRecipes()
    {
        return recipes;
    }
    
    public Recipe addRecipe(String name)
    {
        Recipe r = new Recipe();
        recipes.put(name,r);
        return r;
    }
       
    public void printBookDetails()
    {
        System.out.println("Author: " + author);
        System.out.println("Publish date: " + dayPublished);
    }
    public void listAllRecipes()
    {
        recipe.values();
    }
    public void addRecipe(String name,Recipe food)
    {
        recipe.put(name, food);
    }
}
