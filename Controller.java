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
       currentBook = null;
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
     * @return Returns the books HashMap. Which contains all books.
     */
    public HashMap<String, Book> getBooks()
    {
        return books;
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
    public Book getCurrentBook()
    {
        return currentBook;
    }
    
    public Recipe selectRecipe(String recipeName)
    {
        if (currentBook != null){
            recipeName = recipeName.toLowerCase();
            currentRecipe = currentBook.getRecipe(recipeName);
            return currentRecipe;
        }
        System.out.println("Please select a book.");
        return null;
    }
    public Recipe getCurrentRecipe()
    {
        return currentRecipe;
    }
    
    /**
     * Calls addRecipe in the Book class.
     * 
     * @param name The name of the recipe. Used as the key in the Book.recipes HashMap.
     * @return Returns the new recipe. Returns null if no book has been selected.
     */
    public Recipe newRecipe(String name)
    {
        if(currentBook != null){
            name = name.toLowerCase();
            return currentBook.addRecipe(name);
        }
        System.out.println("Please select a book.");
        return null;
    }
}
