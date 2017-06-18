package UserEnd;
import BackEnd.Engine;
import BackEnd.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Since we don't have an interface for our application, the front-end starts here and the user will be asked for input.
 */
public class Conversation {

    private ArrayList<User> otherPlayers;
    private Scanner input;
    private User user;

    public void startConversation() {
        user = new User();
        input = new Scanner(System.in);
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
        while (true) {  // as long as the player in willing to play this loop will execute.
            System.out.println("\n\nFinding you a match...");
            otherPlayers = Engine.findMatch(user);
            System.out.println("Here are your teammates!");
            for (User player : otherPlayers) {
                System.out.println(player.getFirstName() + " " + player.getLastName());
            }
            System.out.println("Have fun playing!!\n");


            System.out.println("Are you done playing?");
            inputStr = input.next();
            if(inputStr.equalsIgnoreCase("Yes"))
                Engine.changeUserStatus(user, true);
            review();
            System.out.println("Do you want to play another match?");
            inputStr = input.next();
            if(inputStr.equalsIgnoreCase("No"))
                break;

        }
    }

    /**
     * asking users the review about their teammates.
     */
    private void review() {
        double rating;
        System.out.println("So what do you think about your teammates?\nGive them rating from 1 to 5\n");
        for (User player : otherPlayers) {
            System.out.println(player.getFirstName() + " " + player.getLastName());
            rating = input.nextInt();
            Engine.addRatingToUser(player, rating);

            Engine.addGamesPlayed(user, player);
        }
    }

}
