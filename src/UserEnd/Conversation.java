package UserEnd;
import BackEnd.Engine;
import BackEnd.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class Conversation {

    public void startConversation() {
        User user = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName = input.next();
        System.out.println("What is your last name?");
        String lastName = input.next();
        user.setName(firstName,lastName);
        System.out.println("How often do you play per week?");
        int howOftenUserPlaysPerWeek = input.nextInt();
        user.setHowOftenUserPlaysPerWeek(howOftenUserPlaysPerWeek);
        System.out.println("How social are you?");
        int socialness = input.nextInt();
        user.setSocialness(socialness);

        Engine.addUser(user);
        Engine.changeUserStatus(user, false);

        String inputStr;
        while (true) {
            System.out.println("\n\nFinding you a match...");
            ArrayList<User> otherPlayers = Engine.findMatch(user);
            System.out.println("Here are your teammates!");
            for (User player : otherPlayers) {
                System.out.println(player.getFirstName() + " " + player.getLastName());
            }
            System.out.println("Have fun playing!!\n");


            System.out.println("Are you done playing?");
            inputStr = input.next();
            if(inputStr.equals("Yes"))
                Engine.changeUserStatus(user, true);
            review();
            System.out.println("Do you want to play another match?");
            inputStr = input.next();
            if(inputStr.equals("No"))
                break;

        }
    }

    private void review() {
    }

}
