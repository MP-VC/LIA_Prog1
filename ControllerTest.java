import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

/**
 * The test class ControllerTest.
 *
 * @author  R3dJ4y55
 * @version 1
 */
public class ControllerTest
{
    Controller c = new Controller();
    /**
     * Default constructor for test class ControllerTest
     */
    public ControllerTest()
    {
        
    }
    
    @Test 
    public void newBookTest()
    {
        assertEquals(0, c.getBooks().size());
        c.newBook("Book of Food", "Chef of Meals");
        assertEquals(1, c.getBooks().size());
    }
    @Test
    public void selectBookTest()
    {
        assertEquals(0, c.getBooks().size());
        c.newBook("Book of Good Recipes", "Man of Good Cooking");
        assertEquals(1, c.getBooks().size());
        Book b = c.getBook("Book of Good Recipes");
        assertEquals(b, c.selectBook("BOOK of GoOd recipes")); // Also testing case-sensitivity
        assertEquals(b, c.getCurrentBook());
    }
    
    @Test
    public void newRecipeTest()
    {
        assertEquals(null, c.newRecipe("Polyparaphenylene terephthalamide"));
        c.newBook("Aramid Fibers", "DuPont");
        c.selectBook("aramid fibers");
        assertEquals(c.newRecipe("Polyparaphenylene terephthalamide"), c.getCurrentBook().getRecipe("Polyparaphenylene terephthalamide"));
    }
    @Test
    public void selectRecipeTest()
    {
        assertEquals(null, c.getCurrentRecipe());
        c.newBook("100 cool Names for Books", "Man of a hundred Names");
        c.selectBook("100 cool names for books");
        Recipe r = c.newRecipe("Cool Recipe Name");
        assertEquals(r, c.selectRecipe("cool recipe name"));
        assertEquals(r, c.getCurrentRecipe());
    }
    
    @Test
    public void filterByTagTest()
    {
        c.newBook("100 Ice-Based Recipes for Weather when Temperature exceeds 35C", "Jake 'cold' F-rost");
        c.selectBook("100 ice-based recipes for weather when temperature exceeds 35c");
        c.newRecipe("Ice-Flavoured Pie");
        c.selectRecipe("Ice-Flavoured Pie");
        c.newIngredient("Ice", 4.8);
        c.selectIngredient("Ice");
    }
    
    

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /*
     *  Add tests for all select and add methods
     */
    
    
    
}
