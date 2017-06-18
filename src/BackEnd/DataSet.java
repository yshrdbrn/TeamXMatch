package BackEnd;

import java.util.ArrayList;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class DataSet {
    private ArrayList<User> users;
    private int userIDCounter;

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
