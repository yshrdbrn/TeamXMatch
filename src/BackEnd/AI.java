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

        for (User availableUser : availableUsers) {
            availableUser.calculateVector();
            availableUser.calculateDotProduct(user.getVector());
        }

        Collections.sort(availableUsers, (a, b) -> (int)(a.getDotProductResult() - a.getDotProductResult()));

        return null; //TODO
    }
}
