import java.util.HashMap;

/**
 * This is what the user interacts with.
 *
 * @author R3dJ4y55
 * @author MP-VC
 * @version 0
 */
public class Controller
{
    // instance variables - replace the example below with your own
    private HashMap<String,Book> books;
    private HashMap<Integer,Order> orders;
    /**
     * Constructor for objects of class Controller
     */
    public Controller()
    {
        
    }
    
    /**
     * Creates a new recipe book.
     * 
     * @param name The name of the book
     * @param author The author's name
     */
    public void newBook(String name, String author){
        Book b = new Book(author);
        books.put(name, b);
    }
    
    /**
     * Returns a book by name.
     * 
     * @param book The name of the book.
     * @return The book paired with the specified name in the books HashMap.
     */
    public Book getBook(String book)
    {
        Book b = books.get(book);
        return b;
    }
}
