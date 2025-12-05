import java.util.HashMap;
import java.util.Date;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collection;

/**
 * Write a description of class Book here.
 *
 * @author R3dJ4y55
 * @author MP-VC
 * @version 1
 */
public class Book
{
    private HashMap<String,Recipe> recipes;
    private String author;
    private Date dayPublished;
    private String bookTitle;
    /**
     * Constructor for objects of class Book
     */
    public Book(String author)
    {
       this.author = author;
       dayPublished = new Date();
       recipes = new HashMap<>();
    }
    
    public void setBookTitle(String bookTitle)
    {
        this.bookTitle = bookTitle;
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
        System.out.println("Book: " + bookTitle);
        System.out.println("Author: " + author);
        System.out.println("Publish date: " + dayPublished);
    }
    public void listAllRecipes()
    {
        Set<String> recipeName = recipes.keySet();
        for(String food : recipeName)
        {
            System.out.println(food);
        }
    }
    public boolean filterByTag(String filter)
    {
        Collection<Recipe> filterCheck = recipes.values();
        for(Recipe rec : filterCheck)
        {
            if(rec.getIngredient().contains(filter)){
                return true;
            }
        }
        return false;
    }
    public Recipe getRecipe(String name)
    {
        name = name.toLowerCase();
        return recipes.get(name);
    }
}
