import java.util.*;

public class ShoppingCart {

//    ******************** Attributes ********************

    private ArrayList <Product> userShoppingList;

//    ******************** Constructors ********************

    /**
     * For creating a new Shopping cart
     */

    public ShoppingCart () {
        this.userShoppingList = new ArrayList <> ();
    }

//    ****************************************

    /**
     * Method for adding a product to the cart
     * @param selectedItem the users' selected an item
     */

    public void addItemToCart (Product selectedItem) {
        userShoppingList.add (selectedItem);
        System.out.println ("Item " + selectedItem.getProductName() + " added to the cart");
    }

//    ****************************************

    /**
     * Method for remove a product from the cart
     * @param selectedItem the users' selected an item
     */

    public void removeItemFromCart (Product selectedItem) {


        Iterator <Product> iterator = userShoppingList.iterator ();

        int nonExistingVar = 0;

        while (iterator.hasNext ()) {

            Product tempProduct = iterator.next ();

            if (tempProduct.equals (selectedItem)) {
                iterator.remove ();
                System.out.println ("Item " + selectedItem.getProductID() + " removed successfully");
                break;
            }

            else {
                nonExistingVar += 1;
            }

        }

        if (nonExistingVar == userShoppingList.size ()) {
            System.out.println ("Selected product not found on the cart");
        }

    }

//    ****************************************

    /**
     * Method for calculating the total products from the cart
     * @return The total of the products in the cart
     */

    public double calcTotalCart (){

//        ** Iterator to loop through the Array list "userShoppingList" **

        Iterator <Product> iterator = userShoppingList.iterator ();

        double currentTotal = 0;

        while (iterator.hasNext ()) {

            Product tempProduct = iterator.next ();

            double currentIteratorsPrice = tempProduct.getPrice ();
            currentTotal = currentTotal + currentIteratorsPrice;

        }

        return currentTotal;
    }

//    ******************** Getters and Setters ********************

    /**
     * Getting the "userShoppingList" Array List
     * @return userShoppingList
     */

    public ArrayList <Product> getUserShoppingList () {
        return userShoppingList;
    }

//    ****************************************

}
