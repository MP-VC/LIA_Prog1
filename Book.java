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
    // instance variables - replace the example below with your own
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
