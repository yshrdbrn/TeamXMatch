package BackEnd;

import UserEnd.Conversation;

import java.util.ArrayList;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class Engine {
    private static AI ai;
    private static DataSet dataSet;
    private static Conversation conversation;

    public static void main(String[] args) {
        ai = new AI();
        dataSet = new DataSet();
        conversation = new Conversation();

        //TODO
    }

    public static ArrayList<User> findMatch(User user) {
        return ai.findMatch(user, dataSet.getUsers());
    }

    public static void changeUserStatus(User user, boolean value) {
        user.setFree(value);
    }

    public static void addUser(User user) {
        dataSet.addNewUser(user);
    }
}
