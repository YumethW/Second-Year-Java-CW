import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {

    static ArrayList <Product> availableProducts = new ArrayList <> ();

//    ** Super class parameters **

    static String productID = null;
    static String productName = null;
    static int availability = 0;
    static double price = 0;

//    ** Electronics subclass parameters **

    static String electronicBrand = null;
    static  int electronicWarrantyPeriod = 0;

//    ** Clothing subclass parameters **

    static int clothingSize = 0;
    static String clothingColor = null;

    static Scanner userInputtingProductDetails = new Scanner (System.in);

    /**
     *User menu selection
     * @return user selected option from 1 to 7
     */

    public static int menu () {

        System.out.println ("Please select an option:");
        System.out.println ("Press 1 to Add a new product");
        System.out.println ("Press 2 to Delete a product");
        System.out.println ("Press 3 to Print the list of the products alphabetically");
        System.out.println ("Press 4 to Save in a file");
        System.out.println ("Press 5 to Load saved file");
        System.out.println ("Press 6 to open the GUI");
        System.out.println ("Press 7 to exit");

        System.out.print ("Enter selection: ");
        Scanner userInput = new Scanner (System.in); // Getting the user's selection

        int user = 8; // Making the "user" a global variable
        boolean inputEntered = true; // Boolean to initiate the "While" loop

        while (inputEntered) {

            try {
                user = userInput.nextInt ();

                while (user < 1 || user > 7) {
                    System.out.print ("Please enter a value between 1 and 7. Enter selection: ");
                    user = userInput.nextInt ();
                }

                inputEntered = false; // To exit the "While" loop

            }

            catch (Exception e) {
                System.out.print ("Entered selection is invalid. Please enter a valid value: ");
                userInput.next (); // Not "userInput.nextInt" in case the user inputting another invalid value and causing an error
            }

        }

        return user;
    }

//    ****************************************

    /**
     * Getting the super class parameters
     */

    public static void superClassParameters () {

        System.out.print ("Enter the products' product ID: ");

        boolean inputEntered1 = true; // Boolean to initiate the "While" loop

        while (inputEntered1) {

            try {
                productID = userInputtingProductDetails.next ();
                inputEntered1 = false; // To exit the "While" loop
            }

            catch (Exception e) {
                System.out.print ("Entered response is invalid. Please enter a valid response: ");
                userInputtingProductDetails.next ();
            }

        }

//        ** Getting the products' product name **

        System.out.print ("Enter the products' product Name: ");

        inputEntered1 = true; // Boolean to initiate the "While" loop

        while (inputEntered1) {

            try {
                productName = userInputtingProductDetails.next ();
                inputEntered1 = false; // To exit the "While" loop
            }

            catch (Exception e) {
                System.out.println ("Entered response is invalid. Please enter a valid response: ");
                userInputtingProductDetails.next ();
            }

        }

//        ** Getting the products' availability **

        System.out.print ("Enter the products' availability: ");

        inputEntered1 = true; // Boolean to initiate the "While" loop

        while (inputEntered1) {

            try {
                availability = userInputtingProductDetails.nextInt ();
                inputEntered1 = false; // To exit the "While" loop
            }

            catch (Exception e) {
                System.out.println("Entered response is invalid. Please enter a valid response: ");
                userInputtingProductDetails.next ();
            }

        }

//        ** Getting the products' price **

        System.out.print ("Enter the products' price: ");

        inputEntered1 = true; // Boolean to initiate the "While" loop

        while (inputEntered1) {

            try {
                price = userInputtingProductDetails.nextDouble ();
                inputEntered1 = false; // To exit the "While" loop
            }

            catch (Exception e) {
                System.out.print ("Entered response is invalid. Please enter a valid response: ");
                userInputtingProductDetails.next ();
            }

        }

    }

//    ****************************************

    /**
     * Choosing Product category
     * @return User choice on whether to pick clothing or electronics
     */

    public static int chooseCategory () {

        System.out.print ("Enter 1 to add a new electronic product or enter 2 to add a new clothing product: ");

        Scanner productTypeInput = new Scanner(System.in); // Getting the user's selection

        boolean inputEntered3 = true; // Boolean to initiate the "While" loop

        int chooseProductType = 0; // Making the "chooseProductType" a global variable

        while (inputEntered3) {

            try {
                chooseProductType = productTypeInput.nextInt ();

                while (chooseProductType < 1 || chooseProductType > 2) {
                    System.out.print("Please enter either 1 or 2. Enter product category: ");
                    chooseProductType = productTypeInput.nextInt ();
                }

                inputEntered3 = false; // To exit the "While" loop

            }

            catch (Exception e) {
                System.out.print ("Entered response is invalid. Please enter a valid response: ");
                productTypeInput.next ();
            }

        }

        return chooseProductType;

    }

//    ****************************************

    /**
     *Getting the Electronics class parameters
     */

    public static void electronicsParameters () {

//        ** Getting the electronic brand **

        System.out.print ("Enter the electronics's brand name: ");

        boolean inputEntered2 = true; // Boolean to initiate the while loop

        while (inputEntered2) {

            try {
                electronicBrand = userInputtingProductDetails.next ();
                inputEntered2 = false;
            }

            catch (Exception e) {
                System.out.print ("Entered response is invalid. Please enter a valid response: ");
                userInputtingProductDetails.next ();
            }

        }

//        ** Getting the electronic warranty period **

        System.out.print ("Enter the electronics's warranty period in months: ");

        inputEntered2 = true; // Boolean to initiate the while loop

        while (inputEntered2) {

            try {
                electronicWarrantyPeriod = userInputtingProductDetails.nextInt ();
                inputEntered2 = false;
            }

            catch (Exception e) {
                System.out.print ("Entered response is invalid. Please enter a valid response: ");
                userInputtingProductDetails.next ();
            }

        }

    }

//    ****************************************

    /**
     * Getting the Clothing class parameters
     */

    public static void clothingParameters () {

//        ** Getting the clothing size **

        System.out.print ("Enter the clothing size: ");

        boolean inputEntered2 = true; // Boolean to initiate the while loop

        while (inputEntered2) {

            try {
                clothingSize = userInputtingProductDetails.nextInt ();
                inputEntered2 = false;
            }

            catch (Exception e) {
                System.out.print ("Entered response is invalid. Please enter a valid response: ");
                userInputtingProductDetails.next ();
            }

        }

//        ****************************************

//        ** Getting the clothing color **

        System.out.print ("Enter the clothing color: ");

        inputEntered2 = true; // Boolean to initiate the while loop

        while (inputEntered2) {

            try {
                clothingColor = userInputtingProductDetails.next ();
                inputEntered2 = false;
            }

            catch (Exception e) {
                System.out.print ("Entered response is invalid. Please enter a valid response: ");
                userInputtingProductDetails.next ();
            }

        }

    }

//    ****************************************

    /**
     * Repeating method to get multiple user inputs
     * @return either 1 or 2 depending on whether the user wants to add more inputs or not
     */

    public static int repeatFunction () {

        int repeatFunctionAgain = 0; // For when the user wants to make more changes

        System.out.print ("Would you like to add/ delete more products? Enter 1 to proceed, enter 2 to exit to the main menu: ");

        boolean inputEntered3 = true; // Boolean to initiate the "While" loop

        while (inputEntered3) {

            Scanner addMore = new Scanner (System.in);

            try {
                repeatFunctionAgain = addMore.nextInt ();

                while (repeatFunctionAgain < 1 || repeatFunctionAgain > 2) {
                    System.out.print ("Entered response is invalid. Please enter a valid response: ");
                    repeatFunctionAgain = addMore.nextInt ();
                }

                inputEntered3 = false; // To exit the "while" loop
            }

            catch (Exception e) {
                System.out.print ("Entered response is invalid. Please enter a valid response: ");
                addMore.next ();
            }

        }

        return repeatFunctionAgain;

    }

//    ****************************************

    /**
     * User adding new Product
     */

    public static void addNewProduct () {

        if (availableProducts.size () > 50) {
            System.out.println("System reached maximum capacity");
        }

        else {

            Product newProductToBeAdded;
            int addMoreProducts; // For when the user adds more than 1 product

            do {

                superClassParameters ();
                int chooseProductType = chooseCategory ();

                if (chooseProductType == 1) {

                    electronicsParameters ();

                    newProductToBeAdded = new Electronics (productID, productName, availability, price, electronicBrand, electronicWarrantyPeriod);
                    availableProducts.add(newProductToBeAdded); // Adding the new product to the "availableProducts" array list
                    System.out.println("New electronic item added");

                }

//                ** When clothing is inputted**

                if (chooseProductType == 2) {

                    clothingParameters ();

                    newProductToBeAdded = new Clothing (productID, productName, availability, price, clothingSize, clothingColor);
                    availableProducts.add (newProductToBeAdded); //Adding the new product to the "availableProducts" array list
                    System.out.println ("New clothing item added");

                }

//                ****************************************

                addMoreProducts = repeatFunction ();

            }

            while (addMoreProducts == 1);
        }

        System.out.println ("Product(s) added successfully");

    }

//    ****************************************

    /**
     * User deleting Product
     */

    public static void deleteProducts () {

        int deleteMoreProducts; // Making "deleteMoreProducts" a global variable

        do {

            System.out.print ("Enter the products' product ID: ");
            boolean inputEntered1 = true; // Boolean to initiate the "While" loop

            while (inputEntered1) {

                try {
                    productID = userInputtingProductDetails.next ();
                    inputEntered1 = false; // To exit the "While" loop
                }

                catch (Exception e) {
                    System.out.println ("Entered response is invalid. Please enter a valid response: ");
                    userInputtingProductDetails.next ();
                }

            }

//            ****************************************

            int indexOfTheDeletingProduct = -1; // Making "indexOfTheDeletingProduct" a global variable

            for (int i = 0; i < availableProducts.size (); i++) {

                if (availableProducts.get (i).getProductID ().equals (productID)) {
                    indexOfTheDeletingProduct = i;
                    break;
                }

            }

//            ** Deleting the product **

            if (indexOfTheDeletingProduct != -1) {
                availableProducts.remove (availableProducts.get (indexOfTheDeletingProduct));
                System.out.println ("Product with ID " + productID + " deleted successfully");
            }

            else {
                System.out.println ("Products with the ID " + productID + " not found");
            }

//            ** When deleting another product **

            deleteMoreProducts = repeatFunction ();

        }

        while (deleteMoreProducts == 1);

        System.out.println("Product(s) deleted successfully");

    }

//    ****************************************

    /**
     * Print alphabetically
     */

    public static void sortAlphabetically () {

        ArrayList <String> productIDArraylist = new ArrayList <> ();

        for (Product availableProduct : availableProducts) {
            productIDArraylist.add (availableProduct.getProductID());
        }

        Collections.sort (productIDArraylist);

        for (String s : productIDArraylist) {
            System.out.println (s);
        }

    }

//    ****************************************

    /**
     * User saving Products
     */

    public static void saveAvailableProducts () {

        try (BufferedWriter writer = new BufferedWriter (new FileWriter ("Products.txt"))) {

            for (Product product : availableProducts) {

                String productLine = "Product ID " + product.getProductID () + ", " + "Product Name " + product.getProductName () + ", " + "Product Price " + product.getPrice () + ", " + "Product Available number " + product.getAvailableNum ();

                if (product instanceof Electronics) {
                    productLine += ", " + "Electronic Brand " + (((Electronics) product).getElectronicBrand ()) + ", " + "Electronic Warranty Period " + (((Electronics) product).getElectronicWarrantyPeriod ());
                }

                if (product instanceof Clothing) {
                    productLine += ", " + "Clothing Size " + (((Clothing) product).getClothingSize ()) + ", " + "Clothing Color " + (((Clothing) product).getClothingColor ());
                }

                writer.write (productLine);
                writer.newLine();

            }

        }

        catch (IOException e) {

            System.out.println ("An error occurred while saving the available products to the file.");
            e.printStackTrace ();

        }

    }

//    ****************************************

    /**
     * User loading saved data
     */

    public static void loadTxtFile () {

        try (BufferedReader reader = new BufferedReader(new FileReader("Products.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] attributes = line.split(", ");

                String productID = attributes[0].substring(11);
                String productName = attributes[1].substring(13);
                String price = attributes[2].substring(14);
                String availableNum = attributes[3].substring(25);

                if (attributes[4].contains("Electronic Brand")) {

                    String electronicBrand = attributes[4].substring(17);
                    String electronicWarrantyPeriod = attributes[5].substring(27);
                    Product product = new Electronics(productID, productName, Integer.parseInt(availableNum), Double.parseDouble(price),electronicBrand, Integer.parseInt(electronicWarrantyPeriod));
                    availableProducts.add(product);

                }

                if (attributes[4].contains("Clothing Size")) {

                    String clothingSize = attributes[4].substring(14);
                    String clothingColor = attributes[5].substring(15);
                    Product product = new Clothing (productID, productName, Integer.parseInt(availableNum), Double.parseDouble(price), Integer.parseInt(clothingSize), clothingColor);
                    availableProducts.add (product);

                }

            }

        }

        catch (IOException e) {

            System.out.println("An error occurred while loading the available products from the file.");
            e.printStackTrace();

        }

    }

//    ****************************************
//    ****************************************

    /**
     * Main method to run the programme
     * @param args
     */

    public static void main (String[] args) {

//        Creating a file

        try {

            File file = new File("Products.txt"); // The path for the created text file, variable "file"
            boolean file_created = file.createNewFile();

            if (file_created){}

            else {
                System.out.println("Error while creating file: " + file.getName());
            }

        }

        catch (IOException e) {
            e.printStackTrace();
        }

//        Calling the "Menu" method

        boolean menuRepeat = true; // Boolean to initiate the "While" loop
        while (menuRepeat) {

            int user = menu ();

//            ******************** When the user inputs "1" ********************

            if (user == 1) {
                addNewProduct (); // Calling the "addNewProduct" method
            }

//            ******************** When the user inputs "2" ********************

            if (user == 2) {
                deleteProducts (); // Calling the "deleteProducts" method
            }

//            ******************** When the user inputs "3" ********************

            if (user == 3) {
                sortAlphabetically (); // Calling the "sortAlphabetically" method
            }

//            ******************** When the user inputs "4" ********************

            if (user == 4) {
                saveAvailableProducts (); // Calling the "saveAvailableProducts" method
                System.out.println ("Product List saved successfully");
            }

//            ******************** When the user inputs "5" ********************

            if (user == 5) {
                loadTxtFile (); // Calling the "loadTxtFile" method
                System.out.println ("Product List loaded successfully");
            }

//            ******************** When the user inputs "6" ********************

            if (user == 6) {

                new LoginSignupFrame ();

            }

//            ******************** When the user inputs "7" ********************

            if (user == 7) {
                menuRepeat = false; // To exit the "While" loop
                System.out.println ("Have a nice day!!");
            }

//            ****************************************

        }

    }

}