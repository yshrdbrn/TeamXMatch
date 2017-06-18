package UserEnd;
import BackEnd.User;

import java.util.Scanner;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class Conversation {

    public void startConversation() {
        User user = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName = user.getFirstName();
        System.out.println("What is your last name?");
        String lastName = user.getLastName();
        user.setName(firstName,lastName);
        System.out.println("How often do you play per week?");
        int howOftenUserPlaysPerWeek = user.getHowOftenUserPlaysPerWeek();
        user.setHowOftenUserPlaysPerWeek(howOftenUserPlaysPerWeek);
        System.out.println("How social are you?");
        int socialness = user.getSocialness();
        user.setSocialness(socialness);
        
    }

}
