import org.junit.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class WestminsterShoppingManagerTest {

    private final InputStream originalInput = System.in; // The variable the user inputs

//    ** Redirecting standard input during the "WestminsterShoppingManagerTest" execution **

    @Before // Executed before each test case

    public void setUpStreams () {

        System.setIn (originalInput);

    }

    @After // Execute after each test case

    public void restoreStreams () {

        System.setIn (originalInput);

    }

    /**

     * Testing the "menu()" function

     */

    @org.junit.jupiter.api.Test

    void testMenuValidInput () {

        String input = "3\n"; // Simulated user input
        System.setIn (new ByteArrayInputStream (input.getBytes ())); // Converts user input as bytes
        int result = WestminsterShoppingManager.menu ();

        assertEquals (3, result);

    }

//    ** Testing an invalid input followed by a valid input **

    @org.junit.jupiter.api.Test

    void testMenuInvalidInputThenValidInput () {

        String input = "invalid\n2\n"; // Simulated user input (inputs "invalid" and after "2")
        System.setIn (new ByteArrayInputStream (input.getBytes ())); // Converts user input as bytes
        int result = WestminsterShoppingManager.menu ();

        assertEquals (2, result);

    }

//    ** Testing an invalid input **

    @Test (expected = NoSuchElementException.class) // Expects a "NoSuchElementException" exception

    public void testMenuInvalidInput () {

        String input = "invalid\n"; // Simulated user input
        System.setIn (new ByteArrayInputStream (input.getBytes ())); // Converts user input as bytes

        WestminsterShoppingManager.menu (); // Call "menu ()" method

    }

//    ****************************************

    /**
     * Testing the "superClassParameters ()" function
     */

    @org.junit.jupiter.api.Test

    void testSuperClassParametersValidInput () {

        String input = "P001\nLaptop\n10\n1000.00\n"; // Simulated user input
        System.setIn(new ByteArrayInputStream (input.getBytes ())); // Converts user input as bytes

        WestminsterShoppingManager.superClassParameters (); // Call "superClassParameters ()" method (Error gets removed when debugging)

        assertEquals ("P001", WestminsterShoppingManager.productID);
        assertEquals ("Laptop", WestminsterShoppingManager.productName);
        assertEquals (10, WestminsterShoppingManager.availability);
        assertEquals (1000.00, WestminsterShoppingManager.price);

    }

//    ** Testing an invalid input followed by a valid input **

    @org.junit.jupiter.api.Test

    public void testSuperClassParametersInvalidInputThenValidInput () {

        String input = "P002\nSmartphone\ninvalid\n15\n1200.00\n";
        System.setIn (new ByteArrayInputStream (input.getBytes ()));

        WestminsterShoppingManager.superClassParameters(); // Error gets removed when debugging

        assertEquals ("P002", WestminsterShoppingManager.productID);
        assertEquals ("Smartphone", WestminsterShoppingManager.productName);
        assertEquals (15, WestminsterShoppingManager.availability);
        assertEquals (1200.00, WestminsterShoppingManager.price);

    }

//    ** Testing an invalid input followed by a valid input **

    @org.junit.jupiter.api.Test

    public void testSuperClassParametersInvalidInput () {

        String input = "P002\nSmartphone\ninvalid\n";
        System.setIn (new ByteArrayInputStream (input.getBytes ()));

//        ** Expects a "NoSuchElementException" exception **

        try {
            WestminsterShoppingManager.superClassParameters ();
        }

        catch (NoSuchElementException e) {
            assertNull(e.getMessage());
        }

    }

//    ****************************************

    /**

     * Testing the "chooseCategory ()" function

     */

    @org.junit.jupiter.api.Test

    void chooseCategory () {

        String input = "1\n"; // Simulated user input
        System.setIn (new ByteArrayInputStream (input.getBytes ())); // Converts user input as bytes

        int result = WestminsterShoppingManager.chooseCategory();

        assertEquals(1, result);

    }

//    ****************************************

    /**

     * Testing the "electronicsParameters ()" function

     */

    @org.junit.jupiter.api.Test

    void electronicsParameters () {

        String input = "Apple\n12\n"; // Simulated user input for electronic brand and warranty period
        System.setIn (new ByteArrayInputStream (input.getBytes ())); // Converts user input as bytes

        WestminsterShoppingManager.electronicsParameters (); // Call "electronicsParameters ()" method

        assertEquals("Apple", WestminsterShoppingManager.electronicBrand);
        assertEquals(12, WestminsterShoppingManager.electronicWarrantyPeriod);

    }

//    ****************************************

    /**

     * Testing the "clothingParameters ()" function

     */

    @org.junit.jupiter.api.Test

    void clothingParameters () {

        String input = "24\nRed\n"; // Simulated user input for electronic brand and warranty period
        System.setIn (new ByteArrayInputStream (input.getBytes ())); // Converts user input as bytes

        WestminsterShoppingManager.clothingParameters (); // Call "clothingParameters ()" method

        assertEquals (24, WestminsterShoppingManager.clothingSize);
        assertEquals ("Red", WestminsterShoppingManager.clothingColor);

    }

//    ****************************************

    /**

     * Testing the "sortAlphabetically ()" function

     */

    @org.junit.jupiter.api.Test

    void sortAlphabetically () {

//    ** Adding products to the availableProducts list for testing **

        WestminsterShoppingManager.availableProducts.clear(); // Clearing the arraylist so other test case data doesn't interfere
        WestminsterShoppingManager.availableProducts.add (new Electronics ("003", "ProductC", 5, 50.0, "Apple", 12));
        WestminsterShoppingManager.availableProducts.add (new Clothing ("001", "ProductA", 10, 100.0, 6, "Red"));
        WestminsterShoppingManager.availableProducts.add (new Electronics ("002", "ProductB", 8, 80.0, "LG", 12));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (outputStream));

        WestminsterShoppingManager.sortAlphabetically (); // Call "sortAlphabetically ()" method
        System.setOut (System.out); // Restore System.out

        String expectedOutput = "001\n002\n003\n";
        assertEquals (expectedOutput, outputStream.toString ());

    }

//    ****************************************

    /**

     * Testing the "repeatFunction ()" function

     */

    @org.junit.jupiter.api.Test

    void testRepeatFunctionValidInput () {

        String input = "1\n"; // Simulated user input
        System.setIn (new ByteArrayInputStream (input.getBytes ()));

        int result = WestminsterShoppingManager.repeatFunction(); // Call "repeatFunction ()" method

        assertEquals(1, result);

    }

//    ** Testing an invalid input followed by a valid input **

    @org.junit.jupiter.api.Test

    void testRepeatFunctionInvalidInputThenValidInput () {

        String input = "invalid\n2\n"; // Simulated user input
        System.setIn (new ByteArrayInputStream (input.getBytes ()));

        int result = WestminsterShoppingManager.repeatFunction (); // Call "repeatFunction ()" method

        assertEquals (2, result);

    }

//    ** Testing an invalid input **

    @org.junit.jupiter.api.Test

    void testRepeatFunctionInvalidInput () {

        String input = "invalid\n"; // Simulated user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(NoSuchElementException.class, WestminsterShoppingManager::repeatFunction);

    }

//    ****************************************

    /**

     * Testing the "saveAvailableProducts ()" function

     */

    @org.junit.jupiter.api.Test

    void saveAvailableProducts () throws IOException {

//        ** Adding dummy products for testing **

        ArrayList <Product> dummyProducts = new ArrayList <> ();
        dummyProducts.add (new Electronics ("E001", "Laptop", 10, 999.99, "Dell", 24));
        dummyProducts.add (new Clothing ("C001", "Shirt", 20, 19.99, 42, "Blue"));
        WestminsterShoppingManager.availableProducts = dummyProducts;

        WestminsterShoppingManager.saveAvailableProducts(); // Call "saveAvailableProducts ()" method

        BufferedReader reader = new BufferedReader(new FileReader("Products.txt")); // Read the content of the saved file
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine ()) != null) {
            content.append(line).append(System.lineSeparator());
        }

        reader.close();

        String expectedContent =
                "Product ID E001, Product Name Laptop, Product Price 999.99, Product Available number 10, Electronic Brand Dell, Electronic Warranty Period 24\n" + "Product ID C001, Product Name Shirt, Product Price 19.99, Product Available number 20, Clothing Size 42, Clothing Color Blue\n";
        assertEquals(expectedContent, content.toString());

    }

//    ****************************************

    /**

     * Testing the "loadTxtFile ()" function

     */
    
    @org.junit.jupiter.api.Test

    void loadTxtFile () {

        File testFile; // Creating a temporary file with sample content

        try {
            testFile = createTempFileWithContent("Products.txt", "Product ID E001, Product Name Laptop, Product Price 999.99, Product Available number 10, Electronic Brand Dell, Electronic Warranty Period 24\n" + "Product ID C001, Product Name Shirt, Product Price 19.99, Product Available number 20, Clothing Size 42, Clothing Color Blue\n");
        }

        catch (IOException e) {
            fail("Failed to create a temporary file for testing.");
            return;
        }

        ArrayList <Product> originalProducts = new ArrayList <> (WestminsterShoppingManager.availableProducts); // Getting the previous availableProducts list

        WestminsterShoppingManager.loadTxtFile (); // Call "loadTxtFile ()" method

        ArrayList<Product> loadedProducts = WestminsterShoppingManager.availableProducts; // Reading the content of the list after calling loadTxtFile

        WestminsterShoppingManager.availableProducts = originalProducts; // Getting the original availableProducts list

        assertEquals(2, loadedProducts.size()); // Verifying if the loadedProducts list matches the expected products

//        ** Verify the first product (Electronic) **

        Product electronicProduct = loadedProducts.getFirst();
        assertInstanceOf(Electronics.class, electronicProduct);
        assertEquals("E001", electronicProduct.getProductID());
        assertEquals("Laptop", electronicProduct.getProductName());
        assertEquals(10, electronicProduct.getAvailableNum());
        assertEquals(999.99, electronicProduct.getPrice(), 0.01);
        assertEquals("Dell", ((Electronics) electronicProduct).getElectronicBrand());
        assertEquals(24, ((Electronics) electronicProduct).getElectronicWarrantyPeriod());

//        ** Verify the second product (Clothing) **

        Product clothingProduct = loadedProducts.get(1);
        assertInstanceOf(Clothing.class, clothingProduct);
        assertEquals("C001", clothingProduct.getProductID());
        assertEquals("Shirt", clothingProduct.getProductName());
        assertEquals(20, clothingProduct.getAvailableNum());
        assertEquals(19.99, clothingProduct.getPrice(), 0.01);
        assertEquals(42, ((Clothing) clothingProduct).getClothingSize());
        assertEquals("Blue", ((Clothing) clothingProduct).getClothingColor());

    }

//    ** Method to create a temporary file with specified content **

    private File createTempFileWithContent (String fileName, String content) throws IOException {

        File tempFile = File.createTempFile(fileName, null);

        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.write(content);
        }

        return tempFile;

    }

//    ****************************************

}