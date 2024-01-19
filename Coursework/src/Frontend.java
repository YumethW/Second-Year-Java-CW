import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

public class Frontend extends JFrame {

    private String selectedCategory = "All"; // For the dropdown selection to select everything
    private DefaultTableModel tableModel;
    private JTable productTable;
    private JTextArea textArea;
    private ShoppingCart shoppingCart;
    private JFrame shoppingCartFrame;

    /**
     *Adding products to the shopping cart
     */

    private void addToShoppingCart () {

        int selectedRow = productTable.getSelectedRow ();

        if (selectedRow != -1) {

            Product selectedProduct = WestminsterShoppingManager.availableProducts.get(selectedRow);

            if (selectedProduct.getAvailableNum() > 0) {

                shoppingCart.addItemToCart(selectedProduct);
                selectedProduct.setAvailableNum(selectedProduct.getAvailableNum () - 1);
                refreshTable ();
                showShoppingCart ();

            }

        }

    }

//    ****************************************

    /**
     * Colors rows with less than 3 available
     */

    private void colorRows () {

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer () {

            @Override
            public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);

//                ** Check the condition for coloring rows **

                if (WestminsterShoppingManager.availableProducts.get (row).getAvailableNum () < 3) {
                    component.setBackground (Color.RED);
                }

                else {
                    component.setBackground (Color.WHITE);
                    component.setForeground (Color.BLACK);
                }

                return component;

            }

        };


        for (int i = 0; i < productTable.getColumnCount(); i++) {
            productTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

    }

//    ****************************************

    /**
     * Refresh table to display products in the "productTable" table each time a product is clicked
     */

    private void refreshTable () {

        tableModel.setRowCount (0);

        for (int i = 0; i < WestminsterShoppingManager.availableProducts.size (); i++) {

            Product currentProduct = WestminsterShoppingManager.availableProducts.get (i);

            if ("All".equals(selectedCategory) || ((currentProduct instanceof Electronics) && "Electronics".equals (selectedCategory)) || ((currentProduct instanceof Clothing) && "Clothing".equals (selectedCategory))) {
                Object [] tempObjectArray = new Object [] {
                        currentProduct.getProductID (),
                        currentProduct.getProductName (),
                        "",
                        currentProduct.getPrice (),
                        ""
                };

                if (currentProduct instanceof Electronics) {
                    tempObjectArray [2] = "Electronics";
                    tempObjectArray [4] = ((Electronics) currentProduct).getElectronicBrand () + ((Electronics) currentProduct).getElectronicWarrantyPeriod ();
                }

                if (currentProduct instanceof Clothing) {
                    tempObjectArray [2] = "Clothing";
                    tempObjectArray [4] = ((Clothing) currentProduct).getClothingSize () + ((Clothing) currentProduct).getClothingColor ();
                }

                tableModel.addRow (tempObjectArray);

            }

        }

    }

//    ****************************************

    /**
     * Update the text area for when the user clicks product and displays product details
     * @param selectedRow the row of the table user clicks
     */

    private void updateTextArea (int selectedRow) {

        textArea.setText (""); // Clearing the previous text
        String productInfo = getProductInfo (selectedRow);
        textArea.append (productInfo); // Adding the selected row details

    }

//    ****************************************

    /**
     * Displays product information on the text area
     * @param row the user selected row
     * @return an empty string to display nothing when the user clicks nothing
     */

    private String getProductInfo (int row) {

        if (row >= 0 && row < WestminsterShoppingManager.availableProducts.size ()) {

            Product selectedProduct = WestminsterShoppingManager.availableProducts.get (row);

            return "Product ID: " + selectedProduct.getProductID () +
                    "\nProduct Name: " + selectedProduct.getProductName () +
                    "\nAvailability: " + selectedProduct.getAvailableNum () +
                    "\nPrice: " + selectedProduct.getPrice () +
                    getProductSpecificInfo (selectedProduct);

        }

        return ""; // Returning an empty string when a row isn't clicked

    }

//    ****************************************

    /**
     * Getting the information on the row the user selected
     * @param product the product of the row the user selects
     * @return an empty string to display nothing when the user clicks nothing
     */

    private String getProductSpecificInfo (Product product) {

        if (product instanceof Electronics electronicsProduct) {

            return "\nElectronic Brand: " + electronicsProduct.getElectronicBrand () +
                    "\nElectronic Warranty Period: " + electronicsProduct.getElectronicWarrantyPeriod ();

        }

        if (product instanceof Clothing clothingProduct) {

            return "\nClothing Size: " + clothingProduct.getClothingSize () +
                    "\nClothing Color: " + clothingProduct.getClothingColor ();

        }

        return ""; // Returning an empty string when a row isn't clicked
    }

//    ****************************************

    /**
     * Shows the shopping cart in another frame
     */

    private void showShoppingCart () {

        if (shoppingCartFrame == null) {

            shoppingCartFrame = new JFrame ("Shopping Cart");
            shoppingCartFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        }

        JPanel cartPanel = new JPanel ();
        cartPanel.setLayout (new BoxLayout (cartPanel, BoxLayout.Y_AXIS));

        DefaultTableModel cartTableModel = new DefaultTableModel ();
        JTable cartTable = new JTable (cartTableModel);

        cartTableModel.addColumn ("Product");
        cartTableModel.addColumn ("Quantity");
        cartTableModel.addColumn ("Price");

        Map <Product, Integer> productQuantityMap = new HashMap <> ();

        for (Product product : shoppingCart.getUserShoppingList ()) {
            productQuantityMap.put (product, productQuantityMap.getOrDefault (product, 0) + 1);
        }

        double totalCartPrice = 0;
        double discountedPrice = 0;
        double firstTimePurchase = 0;

        for (Map.Entry <Product, Integer> entry : productQuantityMap.entrySet ()) {

            String additionalinfo = "";

            if (entry.getKey() instanceof Electronics) {
                additionalinfo = ((Electronics) entry.getKey()).getElectronicBrand() + "\n" + ((Electronics) entry.getKey()).getElectronicWarrantyPeriod();
            }

            if (entry.getKey() instanceof Clothing) {
                additionalinfo = ((Clothing) entry.getKey()).getClothingColor() + "\n" + ((Clothing) entry.getKey()).getClothingSize();
            }

            Object [] rowData = {

                    entry.getKey ().getProductID () + entry.getKey().getProductName() + additionalinfo,
                    entry.getValue (),
                    entry.getKey ().getPrice () * entry.getValue ()

            };

            cartTableModel.addRow (rowData);
            totalCartPrice += entry.getKey ().getPrice () * entry.getValue ();

            if (entry.getValue () >= 3) {
                discountedPrice = totalCartPrice * 0.2; // Apply 20% discount
            }

            if (!LoginSignupFrame.newPurchase) {
                firstTimePurchase = totalCartPrice * 0.1; // Apply 10% discount
            }

            if (LoginSignupFrame.newPurchase) {
                firstTimePurchase = 0; // If it's a returning customer
            }

        }

        JLabel totalPriceLabel = new JLabel ("Total : " + totalCartPrice);
        JLabel firstPurchaseDiscountLabel = new JLabel ("First Purchase Discount (10%) : " + firstTimePurchase);
        JLabel discountedPriceLabel = new JLabel ("Three Items in the same Category Discount (20%) : " + discountedPrice);
        JLabel finalPriceLabel = new JLabel ("Final Total : " + (totalCartPrice - discountedPrice));

        cartPanel.add (new JScrollPane (cartTable));
        cartPanel.add (totalPriceLabel);
        cartPanel.add (firstPurchaseDiscountLabel);
        cartPanel.add (discountedPriceLabel);
        cartPanel.add (finalPriceLabel);

        shoppingCartFrame.getContentPane ().removeAll (); // Clear existing content
        shoppingCartFrame.getContentPane ().add (cartPanel);
        shoppingCartFrame.setSize (400, 300);
        shoppingCartFrame.setVisible (true);

    }

    /**
     * Frontend class that holds all the Westminster shopping center frame and shopping cart
     */

    public Frontend () {

//        ******************** Drop Down Menu ********************

        JPanel mainPanel = new JPanel (new GridLayout (5, 1));

        JPanel dropDownButtonPanel = new JPanel (new FlowLayout (FlowLayout.CENTER));
        JLabel SelectCategory = new JLabel ("Select Product Category: ");
        String [] productCategories = {"All", "Electronics", "Clothing"};
        JComboBox <String> categorySelectionOption = new JComboBox <> (productCategories);

        categorySelectionOption.addActionListener (e -> {

            selectedCategory = (String) categorySelectionOption.getSelectedItem ();
            refreshTable ();

        });


        dropDownButtonPanel.add (SelectCategory);
        dropDownButtonPanel.add (categorySelectionOption);

//        ******************** Shopping Cart Button ********************

        shoppingCart = new ShoppingCart ();

        JPanel shoppingCartButtonPanel = new JPanel (new FlowLayout(FlowLayout.RIGHT));
        JButton shoppingCartButton = new JButton ("Shopping Cart");
        shoppingCartButton.addActionListener (e -> showShoppingCart ());


        shoppingCartButtonPanel.add (shoppingCartButton);

//        ******************** Product Table ********************

//        ** Define the columns for the table **

        JPanel productTablePanel = new JPanel (new BorderLayout ());
        tableModel = new DefaultTableModel ();
        productTable = new JTable (tableModel);
        JScrollPane tableScrollPane = new JScrollPane (productTable);
        productTablePanel.add (tableScrollPane, BorderLayout.CENTER);

        ArrayList <Object []> productObjectTableArray = new ArrayList <> ();
        String [] tableColumns = {"Product ID", "Name", "Category", "Price", "Info"};
        tableModel.setColumnIdentifiers (tableColumns);

        for (int i = 0; i < WestminsterShoppingManager.availableProducts.size (); i++) {

            Object [] tempObjectArray = new Object [] {WestminsterShoppingManager.availableProducts.get (i).getProductID (), WestminsterShoppingManager.availableProducts.get (i).getProductName (), "", WestminsterShoppingManager.availableProducts.get (i).getPrice (), ""};

            if (WestminsterShoppingManager.availableProducts.get (i) instanceof Electronics) {
                tempObjectArray [2] = "Electronic";
                tempObjectArray [4] = "Electronic Brand " + ((Electronics) WestminsterShoppingManager.availableProducts.get (i)) .getElectronicBrand () + " Electronic Warranty Period " + ((Electronics) WestminsterShoppingManager.availableProducts.get (i)).getElectronicWarrantyPeriod ();
                productObjectTableArray.add (tempObjectArray);
            }

            if (WestminsterShoppingManager.availableProducts.get (i) instanceof Clothing) {
                tempObjectArray [2] = "Clothing";
                tempObjectArray [4] = "Clothing Size " + ((Clothing) WestminsterShoppingManager.availableProducts.get (i)).getClothingSize () + " Clothing Color " + ((Clothing) WestminsterShoppingManager.availableProducts.get (i)).getClothingColor ();
                productObjectTableArray.add (tempObjectArray);
            }

        }

        productObjectTableArray.sort (Comparator.comparing (obj -> obj [0].toString ()));

        for (Object [] rowData : productObjectTableArray) {
            tableModel.addRow (rowData);
        }

        colorRows();

//        ******************** Add to Shopping Cart Button ********************

        JPanel addToShoppingCartPanel = new JPanel (new FlowLayout (FlowLayout.CENTER));
        JButton addToShoppingCartButton = new JButton ("Add to Shopping Cart");
        addToShoppingCartButton.addActionListener (e -> addToShoppingCart ());

        addToShoppingCartPanel.add (addToShoppingCartButton);

//        ******************** Text Area ********************

        JPanel textAreaPanel = new JPanel (new FlowLayout (FlowLayout.CENTER));
        textArea = new JTextArea (10, 50); // Set rows and columns for the JTextArea
        JScrollPane textAreaScrollPane = new JScrollPane (textArea);
        textAreaPanel.add (textAreaScrollPane);

//        ** Updating text field when a row is selected from the table **

        productTable.getSelectionModel ().addListSelectionListener (

                e -> {

                    int selectedRow = productTable.getSelectedRow ();
                    if (selectedRow != -1) {
                        updateTextArea (selectedRow);

                    }

                }

        );

//        ******************** Adding panels to the main panel ********************

        mainPanel.add (shoppingCartButtonPanel);
        mainPanel.add (dropDownButtonPanel);
        mainPanel.add (productTablePanel);
        mainPanel.add (textAreaPanel);
        mainPanel.add (addToShoppingCartPanel);

        setContentPane (mainPanel); // Setting the main panel as the content pane of the frame

    }

}