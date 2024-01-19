# Second-Year-Java-CW

This GitHub repository contains a comprehensive Java program for managing an online shopping system. The system is designed with a console interface for the manager to perform various actions, such as adding or deleting products, printing product lists, and saving/loading product information. Additionally, a Graphical User Interface (GUI) is implemented for users to interact with the system, allowing them to select products, add them to a shopping cart, and visualize the final price with discounts.
Project Features:

    Object-Oriented Design (Phase 1):
        Utilizes UML diagrams for design, including a UML use case diagram and a UML class diagram.
        Implements a superclass Product and subclasses Electronics and Clothing, adhering to inheritance and encapsulation principles.
        Includes a class User for user accounts and a class ShoppingCart for managing the user's cart.
        Implements a class WestminsterShoppingManager that maintains the list of products, following the ShoppingManager interface.

    Console Menu Implementation (Phase 2):
        Displays a console menu with options for adding new products, deleting products, printing product lists, and saving/loading product information.
        Handles the addition of electronics or clothing with relevant information, considering a maximum of 50 products.
        Provides functionality to delete a product using its ID, printing product lists alphabetically, and saving/loading product information to/from a file.

    Graphical User Interface (GUI) Implementation (Phase 3):
        Integrates a GUI that allows users to select the type of product to visualize (all, electronics, or clothes).
        Displays a sortable table of products with information, highlighting items with reduced availability.
        Allows users to select and view detailed product information in a panel below the table.
        Enables users to add selected products to a shopping cart and view the cart with the final price, considering discounts.

    Testing and System Validation (Phase 4):
        Provides a test plan outlining specific instructions and scenarios for testing the program.
        Implements automated testing using JUnit or other suitable tools, covering main use cases.
        Emphasizes code robustness through error handling and input validation, adhering to coding standards and conventions.

This project serves as a comprehensive solution for an online shopping system, showcasing object-oriented design principles, console and GUI interfaces, and robust testing practices. Feel free to explore and contribute to this versatile Java application.
