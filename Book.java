import java.util.HashMap;
import java.time.LocalDate;
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
    private LocalDate dayPublished;
    private String bookTitle;
    /**
     * Constructor for objects of class Book
     */
    public Book(String author)
    {
       this.author = author;
       dayPublished = LocalDate.now();
       recipes = new HashMap<>();
    }
    
    public void setBookTitle(String bookTitle)
    {
        this.bookTitle = bookTitle;
    }
    public void setDate(int year, int month, int day)
    {
        dayPublished = dayPublished.of(year, month, day);
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
            for (Ingredient ing : rec.getIngredients())
            {
                if(ing.getTags().contains(filter)){
                    rec.setToDisplay(true);
                } else {
                    rec.setToDisplay(false);
                }
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
