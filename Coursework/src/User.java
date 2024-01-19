import java.util.ArrayList;

public class User {

    //    ******************** Attributes ********************

    static ArrayList <User> userArrayList = new ArrayList <> ();
    private String userName;
    private String password;
    private Boolean firstPurchase;

//    ******************** Constructors ********************

    public User (String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.firstPurchase = true;
    }

//    ******************** Getters and Setters ********************

    /**
     * Getting the username
     * @return the username
     */

    public String getUserName () {
        return userName;
    }

    /**
     * Setting the username
     * @param userName setting the parameter's value as the username
     */

    public void setUserName (String userName) {
        this.userName = userName;
    }

    /**
     * Getting the password
     * @return the password
     */

    public String getPassword () {
        return password;
    }

    /**
     * Setting the password
     * @param password setting the parameter's value as the password
     */

    public void setPassword (String password) {
        this.password = password;
    }

    /**
     * Getting the first purchase boolean
     * @return the first purchase boolean
     */

    public Boolean getFirstPurchase () {
        return firstPurchase;
    }

    /**
     * Setting the first purchase boolean
     * @param firstPurchase setting the parameter's value as the first purchase
     */

    public void setFirstPurchase (boolean firstPurchase) {
        this.firstPurchase = firstPurchase;
    }

    //    ****************************************

}
