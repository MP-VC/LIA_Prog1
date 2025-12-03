import java.util.HashMap;

/**
 * This is what the user interacts with.
 *
 * @author R3dJ4y55
 * @author MP-VC
 * @version 1
 */
public class Controller
{
    private HashMap<String,Book> books;
    
    private Book currentBook;
    private Recipe currentRecipe;
    private Ingredient currentIngredient;
    /**
     * Constructor for objects of class Controller
     */
    public Controller()
    {
       books = new HashMap<>(); 
    }
    
    /**
     * Creates a new recipe book.
     * 
     * @param name The name of the book
     * @param author The author's name
     */
    public void newBook(String name, String author){
        Book b = new Book(author.toLowerCase());
        books.put(name.toLowerCase(), b);
    }
    
    /**
     * Returns a book by name.
     * 
     * @param book The name of the book.
     * @return The book paired with the specified name in the books HashMap.
     */
    public Book getBook(String book)
    {
        book = book.toLowerCase();
        Book b = books.get(book);
        return b;
    }
    
    /**
     * Sets the specified book to the one the user is reading.
     * This allows us not to have the users specify the book every time.
     * 
     * @param bookName The name of the book. The key for the books HashMap.
     */
    public Book selectBook(String bookName)
    {
        bookName = bookName.toLowerCase();
        currentBook = books.get(bookName);
        return currentBook;
    }
    
    public Recipe selectRecipe(String recipeName)
    {
        recipeName = recipeName.toLowerCase();
        currentRecipe = currentBook.getRecipe(recipeName);
        return currentRecipe;
    }
    
    /**
     * Calls addRecipe in the Book class.
     * 
     * @param name The name of the recipe. Used as the key in the Book.recipes HashMap.
     */
    public Recipe newRecipe(String name)
    {
        name = name.toLowerCase();
        return currentBook.addRecipe(name);
    }
}
