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

        preprocessDataSet();
        conversation.startConversation();
    }

    private static void preprocessDataSet() {
        for (int i = 0; i < 1000; i++) {
            RandomUser randomUser = new RandomUser();
            dataSet.addNewUser(randomUser.getUser());
        }
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

    public static void addRatingToUser(User user, double rating) {
        user.updateRating(rating);
    }

    public static void addGamesPlayed(User user, User player) {
        user.updateNumberOfGamesPlayedTogether(player);
        player.updateNumberOfGamesPlayedTogether(user);
    }
}
