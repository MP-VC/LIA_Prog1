import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This is what the user interacts with.
 *
 * @author R3dJ4y55
 * @author MP-VC
 * @version 1
 */
public class Controller
{
    private static HashMap<String,Book> books = new HashMap<>();

    private Book currentBook=null;
    private Recipe currentRecipe;
    private Ingredient currentIngredient;
    /**
     * Constructor for objects of class Controller
     */
    public static void main(String[] args)
    {
        mainMenu();
    }
    
    public static void mainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select an option");
        System.out.println("1: Create a book");
        System.out.println("2: Create a recipe");
        System.out.println("3: Select a book");
        System.out.println("4: Select a recipe");
        System.out.println("5: List selected options");
        System.out.println("6: List book");
        int option = scanner.nextInt();
        switch(option)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Select a filter");
                System.out.println("1: No filter");
                System.out.println("2: Rating sort");
                System.out.println("3: Name/ingredient/tag filter");
                int filter = scanner.nextInt();
                switch(filter)
                {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Please select a valid option");
                        mainMenu();
                        break; 
                }
                break;
            default:
                System.out.println("Please select a valid option");
                mainMenu();
                break;
        }
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
        b.setBookTitle(name);
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

    public void newIngredient(String name, double quantity)
    {
        if (currentBook != null && currentRecipe != null) currentRecipe.addIngredient(new Ingredient(name), quantity);
    }

    public void selectIngredient(String name)
    {
        if (currentBook != null && currentRecipe != null) 
        {
            for(Ingredient ingredient : currentRecipe.getIngredients())
            {
                currentIngredient = ingredient.toString().toLowerCase().equals(name.toLowerCase()) ? ingredient : null;
            }
        }
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

    /**
     * Print the current recipes instructions
     */
    public void printInstruction()
    {
        int i = 0;
        while(i<currentRecipe.getInstructionSize())
        {
            System.out.println(currentRecipe.getInstruction(i));
            i++;
        }
    }

    /**
     * Add instructions in the current recipe
     */
    public void addInstruction(String instruction)
    {
        currentRecipe.addInstrution(instruction);
    }

    /**
     * Lets the user add ingredients inside the current recipe
     */
    public void addIngredient(String food, Unit mesurementUnit, double amount)
    {
        Ingredient f = new Ingredient(food);
        f.setUnit(mesurementUnit);
        currentRecipe.addIngredient(f, amount);
    }

    /**
     * Prints the whole selected book while sorting by highest to lowest rating
     */
    public void printFullRatingSortBook()
    {
        int i = 0;
        int max = 10;
        currentBook.printBookDetails();
        while(currentRecipe.getRatingSize()>i)
        {
            for(Map.Entry<String,Recipe> a: currentBook.getRecipes().entrySet())
            {
                if(currentRecipe.getAverageRating()==max)
                {
                    currentRecipe = a.getValue();
                    System.out.println(a.getKey().toString() + " " + currentRecipe.getAverageRating() + " Stars");
                    currentRecipe.listAllIngredients();
                    printInstruction();
                }
            }
            max--;
        }
    }

    /**
     * Prints the whole selected book
     */
    public void printFullBook()
    {
        currentBook.printBookDetails();
        for(Map.Entry<String,Recipe> a: currentBook.getRecipes().entrySet())
        {
            currentRecipe = a.getValue();
            System.out.println(a.getKey().toString() + " " + currentRecipe.getAverageRating() + " Stars");
            currentRecipe.listAllIngredients();
            printInstruction();
        }
    }

    /**
     * Print the book with the search
     */
    public void printSearchFullBook(String title,Ingredient ingredient, Tag tag)
    {
        int i = 0;
        currentBook.printBookDetails();
        for(Map.Entry<String,Recipe> a: currentBook.getRecipes().entrySet())
        {
            if(a.getKey().toString().equals(title)||currentRecipe.getIngredients().contains(ingredient)||tag.equals(currentRecipe.getAllTag()))
            {
                currentRecipe = a.getValue();
                System.out.println(a.getKey().toString() + " " + currentRecipe.getAverageRating() + " Stars");
                currentRecipe.listAllIngredients();
                printInstruction();
            }
        }
    }
}
