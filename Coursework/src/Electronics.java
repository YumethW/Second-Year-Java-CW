public class Electronics extends Product{

//    ******************** Attributes ********************

    private String electronicBrand;
    private int electronicWarrantyPeriod;

//    ******************** Constructors ********************

    /**
     * For creating a new electronic product
     * @param productID the product ID of the product
     * @param productName the product name of the product
     * @param availableNum the product availability of the product
     * @param price the price of the product
     * @param electronicBrand the brand of the electronic product
     * @param electronicWarrantyPeriod the warranty period of the electronic product
     */

    public Electronics (String productID, String productName, int availableNum, double price, String electronicBrand, int electronicWarrantyPeriod) {
        super (productID, productName, availableNum, price);
        this.electronicBrand = electronicBrand;
        this.electronicWarrantyPeriod = electronicWarrantyPeriod;
    }

//    ******************** Getters and Setters ********************

    /**
     * Getting electronic brand
     * @return electronic brand
     */

    public String getElectronicBrand () {
        return electronicBrand;
    }

    /**
     * Setting electronic brand
     * @param electronicBrand setting the parameter's value as electronic brand
     */

    public void setElectronicBrand (String electronicBrand) {
        this.electronicBrand = electronicBrand;
    }

    /**
     * Getting electronic warranty period
     * @return electronic warranty period
     */

    public int getElectronicWarrantyPeriod () {
        return electronicWarrantyPeriod;
    }

    /**
     * Setting electronic warranty period
     * @param electronicWarrantyPeriod setting the parameter's value as electronic warranty period
     */

    public void setElectronicWarrantyPeriod (int electronicWarrantyPeriod) {
        this.electronicWarrantyPeriod = electronicWarrantyPeriod;
    }

//    ****************************************

}
