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

    void addNewUser(User user) {
        user.setID(userIDCounter++);
        users.add(user);
    }

    ArrayList<User> getUsers() {
        return users;
    }
}
