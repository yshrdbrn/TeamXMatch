package BackEnd;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class used for all the AI features needed for the app
 * It provides an API for finding 4 other people to play with for a certain user
 */
public class AI {
    /**
     * Finds best matches for the user requesting players to play with
     * It sorts other users based on their dot product value and gets top users
     * @param user the person who wants a match
     * @param users potential candidates for the match
     * @return a list of the other 4 users
     */
    public ArrayList<User> findMatch(User user, ArrayList<User> users) {
        ArrayList<User> availableUsers = new ArrayList<>();
        //Filtering out all the players who are not available at the moment
        for (User candidate : users) {
            if(candidate.isFree() && candidate != user)
                availableUsers.add(candidate);
        }

        ArrayList<User> input = new ArrayList<>();
        input.add(user);
        ArrayList<User> finalList = findBestPeople(input, availableUsers);
        finalList.remove(0);
        return finalList;
    }

    /**
     * Finds the best people possible given the people that are already in the match
     * @param chosenPeople the people that are already in the match
     * @param availableUsers potential users to be matched
     * @return the list of the whole team containing the user itself
     */
    private ArrayList<User> findBestPeople(ArrayList<User> chosenPeople, ArrayList<User> availableUsers) {
        if (chosenPeople.size() >= 5) //the match list is full
            return chosenPeople;

        ArrayList<User> temp = new ArrayList<>();
        User user = chosenPeople.get(chosenPeople.size() - 1); //Last person added to the match
        for (User availableUser : availableUsers) {

            availableUser.calculateVector(user);
            user.calculateVector(availableUser);
            availableUser.calculateDotProduct(user.getVector());
        }

        Collections.sort(availableUsers, (a, b) -> (int)(b.getDotProductResult() - a.getDotProductResult()));
        chosenPeople.add(availableUsers.get(0)); //Best match possible
        availableUsers.remove(0);

        if ( (chosenPeople.size() + availableUsers.size()/5 ) > 5 ) {
            for (int i = 0; i < availableUsers.size() / 5; i++) { //Reducing the potential people array to 1/5 size
                temp.add(availableUsers.get(i));
            }
            return findBestPeople(chosenPeople, temp);
        }
        else {
            int count = 0;
            while (chosenPeople.size() < 5) {
                chosenPeople.add(availableUsers.get(count));
                count++;
            }

            return chosenPeople;
        }
    }
}
