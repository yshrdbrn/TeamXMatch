package BackEnd;

import java.util.ArrayList;

/**
 * Class used to store all the data needed for the Back-end
 */
class DataSet {
    private ArrayList<User> users;
    private int userIDCounter; //A counter for specifying a user an ID

    DataSet() {
        userIDCounter = 1;
        users = new ArrayList<>();
    }

    /**
     * Adds a new user to the data set
     * @param user the person who we need to add
     */
    void addNewUser(User user) {
        user.setID(userIDCounter++); //Assigning ID to the given user
        users.add(user);
    }

    ArrayList<User> getUsers() {
        return users;
    }
}
