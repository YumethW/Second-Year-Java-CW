import javax.swing.*;

public class LoginSignupFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public static boolean newPurchase;

    /**
     * Login/ Signup frame
     */

    public LoginSignupFrame () {

        setTitle ("Login/Signup");
        setSize (300, 150);
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel ();
        placeComponents (panel);
        add (panel);

        setVisible (true);

    }

//    ****************************************

    /**
     * Placing the components in the login/ signup frame
     * @param panel panels needed to be aligned
     */

    private void placeComponents (JPanel panel) {

        panel.setLayout (null);

        JLabel userLabel = new JLabel ("Username:");
        userLabel.setBounds (10, 20, 80, 25);
        panel.add (userLabel);

        usernameField = new JTextField (20);
        usernameField.setBounds (100, 20, 165, 25);
        panel.add (usernameField);

        JLabel passwordLabel = new JLabel ("Password:");
        passwordLabel.setBounds (10, 50, 80, 25);
        panel.add (passwordLabel);

        passwordField = new JPasswordField (20);
        passwordField.setBounds (100, 50, 165, 25);
        panel.add (passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds (10, 80, 80, 25);
        panel.add (loginButton);

        JButton signupButton = new JButton("Signup");
        signupButton.setBounds (100, 80, 80, 25);
        panel.add (signupButton);

//        ** Login Button action **

        loginButton.addActionListener (e -> {

            String username = usernameField.getText ();
            char [] password = passwordField.getPassword ();

            User foundUser = findUser (username, password);

            if (foundUser != null) {

                JOptionPane.showMessageDialog (LoginSignupFrame.this, "Successfully logged in");
                Frontend frame = new Frontend (); // Calling the "Frontend" class when successfully logged in
                frame.setTitle ("Westminster Shopping Centre");
                frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                frame.setSize (600, 600);
                frame.setVisible (true);
                foundUser.setFirstPurchase (false);
                newPurchase = true; // Setting the "firstPurchase" boolean to true to get the first purchase discount

            }

            else {
                JOptionPane.showMessageDialog (LoginSignupFrame.this, "Invalid credentials");
            }

        });

        signupButton.addActionListener (e -> {

            String username = usernameField.getText ();
            char [] password = passwordField.getPassword ();

            if (isNewUser (username)) {

                User newUser = new User (username, new String (password));
                User.userArrayList.add (newUser);
                JOptionPane.showMessageDialog (LoginSignupFrame.this, "Successfully signed up");
                Frontend frame = new Frontend ();
                frame.setTitle ("Westminster Shopping Centre");
                frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                frame.setSize (600, 600);
                frame.setVisible (true);
                newUser.setFirstPurchase (false);
                newPurchase = false; // Setting the "firstPurchase" boolean to false to not get the first purchase discount

            }

            else {
                JOptionPane.showMessageDialog (LoginSignupFrame.this, "User already exists");
            }

        });

    }

//    ****************************************

    /**
     * "findUser" method to search for "userArrayList" when the login button is clicked
     * @param username To find the username in the "userArrayList"
     * @param password To find the password in the "userArrayList"
     * @return returns the user that matches the login information or returns nothing
     */

    private User findUser (String username, char [] password) {

        for (User user : User.userArrayList) {

            if (user.getUserName ().equals (username) && new String (password).equals (user.getPassword ())) {
                return user;
            }

        }

        return null;

    }

//    ****************************************

    /**
     * "isNewUser" method to search for "userArrayList" when the signup button is clicked
     * @param username of the new user
     * @return boolean for whether the user exist or not
     */

    private boolean isNewUser (String username) {

        for (User user : User.userArrayList) {

            if (user.getUserName ().equals (username)) {
                return false;
            }

        }

        return true;

    }

}
