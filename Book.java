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
    //public void defaultRecipe()
    //{
    //    ArrayList<Integer> rat1 = new ArrayList<>();
    //    int por1 = 1;
     //   ArrayList<String> ins1 = new ArrayList<>();
    //    String name ="One day blinding soup";
    //    int sugar = 1000;
    //    int protein = 0;
    //    HashMap<String,Integer> vitamins = new HashMap<>();
    //    Set<Tag> tag;
    //    Unit unit;
    //    Ingredient ingredient = new Ingredient(name, sugar, protein, vitamins,tag,unit);
    //    HashMap<Ingredient,Double> ing1 = new HashMap<>();
    //    Recipe r = new Recipe(ing1,ins1,por1,rat1);
    //}
}
