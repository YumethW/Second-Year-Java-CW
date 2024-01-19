public class Clothing extends Product {

//    ******************** Attributes ********************

    private int clothingSize;
    private String clothingColor;

//    ******************** Constructors ********************

    /**
     * For creating a new clothing product
     * @param productID the product ID of the product
     * @param productName the product name of the product
     * @param availableNum the product availability of the product
     * @param price the price of the product
     * @param clothingSize the size of the clothing product
     * @param clothingColor the color of the clothing product
     */

    public Clothing (String productID, String productName, int availableNum, double price, int clothingSize, String clothingColor) {
        super (productID,productName,availableNum,price);
        this.clothingSize = clothingSize;
        this.clothingColor = clothingColor;
    }

//    ******************** Getters and Setters ********************

    /**
     * Getting clothing size
     * @return clothing size
     */

    public int getClothingSize () {
        return clothingSize;
    }

    /**
     * Setting clothing size
     * @param clothingSize setting the parameter's value as clothing size
     */

    public void setClothingSize (int clothingSize) {
        this.clothingSize = clothingSize;
    }

    /**
     * Getting clothing color
     * @return clothing color
     */

    public String getClothingColor () {
        return clothingColor;
    }

    /**
     * Setting clothing color
     * @param clothingColor setting the parameter's value as clothing color
     */

    public void setClothingColor (String clothingColor) {
        this.clothingColor = clothingColor;
    }

//    ****************************************

}
