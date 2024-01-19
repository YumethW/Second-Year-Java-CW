public abstract class Product { // "Product" class declared as abstract due to having abstract methods

//    ******************** Attributes ********************

    private String productID;
    private String productName;
    private int availableNum;
    private double price;

//    ******************** Constructors ********************

    /**
     * For creating a new product
     * @param productID the product ID of the product
     * @param productName the product name of the product
     * @param availableNum the product availability of the product
     * @param price the price of the product
     */

    public Product (String productID, String productName, int availableNum, double price) {
        this.productID = productID;
        this.productName = productName;
        this.availableNum = availableNum;
        this.price = price;
    }

//    ****************************************

    /**
     * Method to decrease availableNum
     * @param addedQuantity the number of products added to the cart
     */
    public void decrementAvailableNum(int addedQuantity) {
        if (addedQuantity > 0 && addedQuantity <= availableNum) {
            availableNum -= addedQuantity;
        }
    }

//    ******************** Getters and Setters ********************

    /**
     * Getting product ID
     * @return product ID
     */

    public String getProductID () {
        return productID;
    }

    /**
     * Setting product ID
     * @param productID setting the parameter's value as product ID
     */

    public void setProductID (String productID) {
        this.productID = productID;
    }

    /**
     * Getting product Name
     * @return product Name
     */

    public String getProductName () {
        return productName;
    }

    /**
     * Setting product Name
     * @param productName setting the parameter's value as product Name
     */

    public void setProductName (String productName) {
        this.productName = productName;
    }

    /**
     * Getting product availability
     * @return product availability
     */

    public int getAvailableNum () {
        return availableNum;
    }

    /**
     * Setting product availability
     * @param availableNum setting the parameter's value as product availability
     */

    public void setAvailableNum (int availableNum) {
        this.availableNum = availableNum;
    }

    /**
     * Getting product price
     * @return product price
     */

    public double getPrice () {
        return price;
    }

    /**
     * Setting product price
     * @param price setting the parameter's value as product price
     */

    public void setPrice (double price) {
        this.price = price;
    }

//    ****************************************

}
