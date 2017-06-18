package BackEnd;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class AI {
    public ArrayList<User> findMatch(User user, ArrayList<User> users) {
        ArrayList<User> availableUsers = new ArrayList<>();
        for (User candidate : users) {
            if(candidate.isFree())
                availableUsers.add(candidate);
        }

        ArrayList<User> input = new ArrayList<>();
        input.add(user);
        ArrayList<User> finalList = findBestPeople(input, availableUsers);
        finalList.remove(0);
        return finalList;
    }

    private ArrayList<User> findBestPeople(ArrayList<User> chosenPeople, ArrayList<User> availableUsers) {
        if (chosenPeople.size() >= 5)
            return chosenPeople;

        ArrayList<User> temp = new ArrayList<>();
        for (User availableUser : availableUsers) {
            availableUser.calculateVector(chosenPeople.get(chosenPeople.size() - 1));
            availableUser.calculateDotProduct(chosenPeople.get(chosenPeople.size() - 1).getVector());
        }

        Collections.sort(availableUsers, (a, b) -> (int)(b.getDotProductResult() - a.getDotProductResult()));
        chosenPeople.add(availableUsers.get(0));
        availableUsers.remove(0);

        if ( (chosenPeople.size() + availableUsers.size()/5 ) > 5 ) {
            for (int i = 0; i < availableUsers.size() / 5; i++) {
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
