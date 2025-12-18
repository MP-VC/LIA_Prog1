import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
    private static boolean running = true;
    private static Book currentBook;
    private static Recipe currentRecipe;
    private static Ingredient currentIngredient;
    private static double portions = 1;
    /**
     * Constructor for objects of class Controller
     */
    public static void main(String[] args)
    {
        loadPreset();
        mainMenu();
    }

    private static void mainMenu()
    {
        while(running)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select an option");
            System.out.println("1: Create a book");
            System.out.println("2: Create a recipe");
            System.out.println("3: Select a book");
            System.out.println("4: Select a recipe");
            System.out.println("5: List selected options");
            System.out.println("6: List book");
            System.out.println("7: Add rating to selected recipe");
            System.out.println("8: Set portions");
            System.out.println("9: Modify selected recipe");
            System.out.println("0: Quit");
            int option = scanner.nextInt();
            switch(option)
            {
                case 1:
                    //Create a book
                    System.out.println("Specify Title and Author");
                    System.out.println("Title:");
                    String title = scanner.next();
                    System.out.println("Author:");
                    String author = scanner.next();
                    newBook(title,author);
                    System.out.println("New book titled " + title +" by " + author + " has made created");
                    mainMenu();
                    break;
                case 2:
                    //Create a recipe
                    if (currentBook == null) {
                        System.out.println("Please select a book first!");
                        break;
                    }
                    System.out.println("Enter recipe name:");
                    String recipeName = scanner.next();
                    currentRecipe = currentBook.addRecipe(recipeName.toLowerCase());
                    System.out.println("Recipe created!");
                    break;
                case 3:
                    //Select a book
                    System.out.println("Input the title of the book");
                    String title2 = scanner.next();
                    currentBook = books.get(title2);
                    break;
                case 4:
                    //Select a recipe
                    if (currentBook == null) {
                        System.out.println("Please select a book first!");
                        break;
                    }
                    System.out.println("Enter recipe name:");
                    String recipeSelect = scanner.next();
                    currentRecipe = currentBook.getRecipe(recipeSelect);
                    if (currentRecipe == null) {
                        System.out.println("Recipe not found!");
                    } else {
                        System.out.println("Recipe selected!");
                    }
                    break;
                case 5:
                    //List selected options
                    System.out.println("Current selections:");
                    System.out.println("Book: " + (currentBook != null ? currentBook.getTitle() : "None"));
                    System.out.println("Recipe: " + (currentRecipe != null ? "Selected" : "None"));
                    break;
                case 6:
                    //List book
                    System.out.println("Select an option");
                    System.out.println("1: No filter");
                    System.out.println("2: Rating sort");
                    System.out.println("3: Name/ingredient/tag filter");
                    System.out.println("4: List all books");
                    int filter = scanner.nextInt();
                    switch(filter)
                    {

                        case 1:
                            if(currentBook!=null){
                                printFullBook();
                            }
                            else{System.out.println("Please select a book first");}
                            break;
                        case 2:
                            if(currentBook!=null){
                                printFullRatingSortBook();
                            }
                            else{System.out.println("Please select a book first");}
                            break;
                        case 3:
                            if(currentBook!=null){
                                String title3 = null;
                                Ingredient ingredient = null;
                                Tag tag = null;
                                
                                System.out.println("Search by:");
                                System.out.println("1: Recipe title");
                                System.out.println("2: Ingredient");
                                System.out.println("3: Tag");

                                int searchChoice = scanner.nextInt();

                                switch (searchChoice)
                                {
                                    case 1:
                                        System.out.println("Enter recipe title:");
                                        title3 = scanner.next();
                                        break;

                                    case 2:
                                        System.out.println("Enter ingredient name:");
                                        String ingredientName = scanner.next();
                                        ingredient = new Ingredient(ingredientName);
                                        break;

                                    case 3:
                                        System.out.println("Enter tag:");
                                        String tagInput = scanner.next();
                                        tag = Tag.valueOf(tagInput.toUpperCase());
                                        break;

                                    default:
                                        System.out.println("Invalid search option!");
                                        break;
                                }
                                printSearchFullBook(title3,ingredient,tag);
                            }
                            else{System.out.println("Please select a book first");}
                            break;
                        case 4:
                            printAllBooks();
                            break;
                        default:
                            System.out.println("Please select a valid option");
                            mainMenu();
                            break; 
                    }
                    break;
                case 7:
                    //add rating
                    if (currentBook == null) {
                        System.out.println("Please select a book first");
                        break;
                    }

                    if (currentRecipe == null) {
                        System.out.println("Please select a recipe first");
                        break;
                    }

                    System.out.println("Enter rating (1 - 10):");
                    int rating = scanner.nextInt();
                    scanner.nextLine();

                    if (rating < 1 || rating > 10) {
                        System.out.println("Rating must be between 1 and 10");
                    } else {
                        currentRecipe.addRating(rating);
                        System.out.println("Rating added. Current average: " + currentRecipe.getAverageRating());
                    }
                    break;
                case 8:
                    //set portions
                    System.out.println("Enter number of portions:");
                    int newPortions = scanner.nextInt();
                    scanner.nextLine();

                    if (newPortions <= 0) {
                        System.out.println("Portions must be greater than 0");
                    } else {
                        portions = newPortions;
                        System.out.println("Portions set to " + portions);
                    }
                    break;
                case 9:
                    if (currentRecipe == null) {
                        System.out.println("Please select a recipe first!");
                        break;
                    }

                    System.out.println("Modifying recipe: " + currentRecipe.toString());
                    System.out.println("Enter ingredients first");
                    System.out.println("Type 'done' when finished adding ingredients");

                    while (true) {
                        System.out.println("Ingredient name:");
                        String ingredientName = scanner.next();

                        if (ingredientName.equalsIgnoreCase("done")) {
                            break;
                        }

                        System.out.println("Quantity:");
                        double quantity = scanner.nextDouble();
                        scanner.next();

                        System.out.println("Unit (ex: GRAM, ML, CUP):");
                        String unitInput = scanner.next();

                        Unit unit = Unit.valueOf(unitInput.toUpperCase());
                        Ingredient ingredient = new Ingredient(ingredientName);
                        ingredient.setUnit(unit);
                        currentRecipe.addIngredient(ingredient, quantity);
                        System.out.println("Ingredient added!");

                        System.out.println("Invalid unit! Ingredient skipped!");
                    }

                    System.out.println("Now add instructions");
                    System.out.println("Type 'done' when finished adding instructions");

                    while (true) {
                        System.out.println("Instruction:");
                        String instruction = scanner.next();

                        if (instruction.equalsIgnoreCase("done")) {
                            break;
                        }

                        currentRecipe.addInstrution(instruction);
                        System.out.println("Instruction added!");
                    }

                    System.out.println("Recipe modification complete!");
                    break;

                case 0:
                    //Quit
                    System.out.println("Ending program");
                    running = false;
                    break;
                default:
                    System.out.println("Please select a valid option");
                    mainMenu();
                    break;
            }
        }
    }

    /**
     * Creates a new recipe book.
     * 
     * @param name The name of the book
     * @param author The author's name
     */
    private static void newBook(String name, String author){
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
    private static Book getBook(String book)
    {
        book = book.toLowerCase();
        Book b = books.get(book);
        return b;
    }

    /**
     * @return Returns the books HashMap. Which contains all books.
     */
    private static HashMap<String, Book> getBooks()
    {
        return books;
    }

    /**
     * Sets the specified book to the one the user is reading.
     * This allows us not to have the users specify the book every time.
     * 
     * @param bookName The name of the book. The key for the books HashMap.
     */
    private static Book selectBook(String bookName)
    {
        bookName = bookName.toLowerCase();
        currentBook = books.get(bookName);
        return currentBook;
    }

    private static Book getCurrentBook()
    {
        return currentBook;
    }

    private static Recipe selectRecipe(String recipeName)
    {
        if (currentBook != null){
            currentRecipe = currentBook.getRecipe(recipeName);
            return currentRecipe;
        }
        System.out.println("Please select a book.");
        return null;
    }

    private static Recipe getCurrentRecipe()
    {
        return currentRecipe;
    }

    private static void newIngredient(String name, double quantity)
    {
        if (currentBook != null && currentRecipe != null) currentRecipe.addIngredient(new Ingredient(name), quantity);
    }

    private static void selectIngredient(String name)
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
    private static Recipe newRecipe(String name)
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
    private static void printInstruction()
    {
        int i = 0;
        while(i<currentRecipe.getInstructionSize())
        {
            System.out.println((i+1)+". "+currentRecipe.getInstruction(i));
            i++;
        }
    }

    private static void printAllBooks()
    {
        Set<String> bookSet = books.keySet();
        int i = 1;
        for (String s : bookSet){
            System.out.println("" + i + ". " + s + " by " + books.get(s).getAuthor());
            i++;
        }
    }

    /**
     * Add instructions in the current recipe
     */
    private static void addInstruction(String instruction)
    {
        currentRecipe.addInstrution(instruction);
    }

    /**
     * Lets the user add ingredients inside the current recipe
     */
    private static void addIngredient(String food, Unit mesurementUnit, double amount)
    {
        Ingredient f = new Ingredient(food);
        f.setUnit(mesurementUnit);
        currentRecipe.addIngredient(f, amount);
    }

    /**
     * Prints the whole selected book while sorting by highest to lowest rating
     */
    private static void printFullRatingSortBook()
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
                    currentRecipe.listAllIngredients(portions);
                    printInstruction();
                }
            }
            max--;
        }
    }

    /**
     * Prints the whole selected book
     */
    private static void printFullBook()
    {
        if (currentBook != null){
            currentBook.printBookDetails();
            System.out.println();
            for(Map.Entry<String,Recipe> a: currentBook.getRecipes().entrySet())
            {
                currentRecipe = a.getValue();
                System.out.println(a.getKey().toString() + " " + currentRecipe.getAverageRating() + " Stars");
                currentRecipe.listAllIngredients(portions);
                System.out.println();
                printInstruction();
            }
        } else{
            System.out.println("No book selected!");
        }
    }

    /**
     * Print the book with the search
     */
    private static void printSearchFullBook(String title,Ingredient ingredient, Tag tag)
    {
        int i = 0;
        currentBook.printBookDetails();
        for(Map.Entry<String,Recipe> a: currentBook.getRecipes().entrySet())
        {
            if(a.getKey().toString().equals(title)||currentRecipe.getIngredients().contains(ingredient)||tag.equals(currentRecipe.getAllTag()))
            {
                currentRecipe = a.getValue();
                System.out.println(a.getKey().toString() + " " + currentRecipe.getAverageRating() + " Stars");
                currentRecipe.listAllIngredients(portions);
                printInstruction();
            }
        }
    }

    private static void loadPreset()
    {
        // Create book
        Book book = new Book("John Neerdowell");
        book.setBookTitle("Evil_book");
        books.put("Evil_book", book);

        // Create recipe
        Recipe recipe = book.addRecipe("Malice");

        // Ingredients
        Ingredient ingredient = new Ingredient("Sin");
        ingredient.setUnit(Unit.CUP);
        recipe.addIngredient(ingredient, 1.5);

        Ingredient ingredient2 = new Ingredient("Hate");
        ingredient2.setUnit(Unit.CUP);
        recipe.addIngredient(ingredient2, 1.25);

        Ingredient ingredient3 = new Ingredient("Corruption");
        ingredient3.setUnit(Unit.UNIT);
        recipe.addIngredient(ingredient3, 1);

        // Instructions
        recipe.addInstrution("Mix all ingredients together");
        recipe.addInstrution("Burn the mixture in purgatory");
        recipe.addInstrution("Absorb");

        // Ratings
        recipe.addRating(9);
        recipe.addRating(10);
        recipe.addRating(8);
        
        // Second Book
        
        // Create book
        book = new Book("Saint Doe");
        book.setBookTitle("Good_book");
        books.put("Good_book", book);

        // Create recipe
        Recipe recipe2 = book.addRecipe("Benevolence");

        // Ingredients
        ingredient = new Ingredient("Virtue");
        ingredient.setUnit(Unit.CUP);
        recipe2.addIngredient(ingredient, 1.5);

        ingredient2 = new Ingredient("Love");
        ingredient2.setUnit(Unit.CUP);
        recipe2.addIngredient(ingredient2, 1.25);

        ingredient3 = new Ingredient("Justice");
        ingredient3.setUnit(Unit.UNIT);
        recipe2.addIngredient(ingredient3, 1);

        // Instructions
        recipe2.addInstrution("Mix all ingredients together");
        recipe2.addInstrution("Show it the wonders of life");
        recipe2.addInstrution("Share it to all");

        // Ratings
        recipe2.addRating(1);
        recipe2.addRating(4);
        recipe2.addRating(3);
    }

}
