package BackEnd;

import java.util.ArrayList;

/**
 * Class used to store all the data needed for the Back-end
 */
public class DataSet {
    private ArrayList<User> users;
    private int userIDCounter; //A counter for specifying a user an ID

    public DataSet() {
        userIDCounter = 1;
        users = new ArrayList<>();
    }

    void addNewUser(User user) {
        user.setID(userIDCounter++);
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
