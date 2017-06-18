package BackEnd;

import UserEnd.Conversation;

import java.util.ArrayList;

/**
 * The class where the whole program starts
 * Because we don't yet have the front-end, the basic front-end is initiated in here
 */
public class Engine {
    private static final int MOCK_USER_NUM = 1000;
    private static AI ai;
    private static DataSet dataSet;

    public static void main(String[] args) {
        ai = new AI();
        dataSet = new DataSet();
        Conversation conversation = new Conversation();

        preprocessDataSet();
        conversation.startConversation();
    }

    /**
     * Adds fake users to the Dataset for the purpose of testing
     */
    private static void preprocessDataSet() {
        for (int i = 0; i < MOCK_USER_NUM; i++) {
            RandomUser randomUser = new RandomUser();
            dataSet.addNewUser(randomUser.getUser());
        }
    }

    /**
     * Finds the other 4 players for a certain user
     * @param user the player who wants 4 other players to play with
     * @return a list of 4 players which is suggested to the user
     */
    public static ArrayList<User> findMatch(User user) {
        return ai.findMatch(user, dataSet.getUsers());
    }

    /**
     * Changes given user's isFree attribute to the given value
     * @param user the person who wants change his status
     * @param value is true if user wants to set its attribute to free
     */
    public static void changeUserStatus(User user, boolean value) {
        user.setFree(value);
    }

    /**
     * Adds given user to the DataSet
     * @param user the person who wants to be added
     */
    public static void addUser(User user) {
        dataSet.addNewUser(user);
    }

    /**
     * Updates the given user's rating based on the new rating given
     * @param user the person who we want to change its rating
     * @param rating the new rating value
     */
    public static void addRatingToUser(User user, double rating) {
        user.updateRating(rating);
    }

    /**
     * Increments the number of games two specific players played with each other
     * @param user the first player
     * @param player the second player
     */
    public static void addGamesPlayed(User user, User player) {
        user.updateNumberOfGamesPlayedTogether(player);
        player.updateNumberOfGamesPlayedTogether(user);
    }
}
