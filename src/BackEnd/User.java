package BackEnd;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class to store all the information needed for every user
 */
public class User {
    private String firstName;
    private String lastName;
    private int socialness; //Level of socialness. Range -> [0, 10]
    private int howOftenUserPlaysPerWeek; //Range -> [0, 7]
    private ArrayList<Double> vector; //Vector containing user's features
    private double dotProductResult;
    private int ID;
    private boolean isFree; //Is user free to get matched to other players
    private HashMap<Integer, Integer> numberGamesPlayedWithPlayer;  //key is the ID of the other player
                                                                    //value is the number of times they
                                                                    //played with each other

    private double rating;
    private double gamesPlayed; //Total number of games a user played

    public User() {
        vector = new ArrayList<>();
        isFree = false;
        numberGamesPlayedWithPlayer = new HashMap<>();
        rating = 0;
        gamesPlayed = 0;
    }


    //Getters

    boolean isFree() {
        return isFree;
    }

    ArrayList<Double> getVector() {
        return vector;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    double getDotProductResult() {
        return dotProductResult;
    }


    //Setters

    void setID(int ID) {
        this.ID = ID;
    }

    void setFree(boolean free) {
        isFree = free;
    }

    public void setName(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setHowOftenUserPlaysPerWeek(int howOftenUserPlaysPerWeek ){
        this.howOftenUserPlaysPerWeek = howOftenUserPlaysPerWeek;
    }
    public void setSocialness(int socialness){
        this.socialness = socialness;
    }


    //Methods

    /**
     * Puts several attributes into the vector
     * @param otherUser needed to obtain the number of times user and otherUser played with eachother
     */
    void calculateVector(User otherUser) {
        vector.clear();

        vector.add((double) socialness);
        vector.add((double) howOftenUserPlaysPerWeek);

        if (numberGamesPlayedWithPlayer.get(otherUser.ID) != null)
            vector.add((double) numberGamesPlayedWithPlayer.get(otherUser.ID));
        else
            vector.add(0.0);

        vector.add(rating);
    }

    /**
     * performs a dot product calculation and puts it in dotProductResult attribute
     * @param anotherVector given to perform dot product with
     */
    void calculateDotProduct(ArrayList<Double> anotherVector) {
        double result = 0;
        for (int i = 0; i < vector.size(); i++) {
            result += vector.get(i) * anotherVector.get(i);
        }

        dotProductResult = result;
    }

    /**
     * Adds a rating to user's average rating
     * @param rating given new rating
     */
    void updateRating(double rating) {
        this.rating = ( this.rating * gamesPlayed  +  rating ) / (gamesPlayed + 1);
        gamesPlayed++;
    }

    /**
     * increments the number of games two users played with each other
     * @param otherPlayer the other user which this user played a game with
     */
    void updateNumberOfGamesPlayedTogether(User otherPlayer) {
        Integer num = numberGamesPlayedWithPlayer.get(otherPlayer.ID);
        if (num != null)
            numberGamesPlayedWithPlayer.put(otherPlayer.ID, num + 1);
        else
            numberGamesPlayedWithPlayer.put(otherPlayer.ID, 1);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialness=" + socialness +
                ", howOftenUserPlaysPerWeek=" + howOftenUserPlaysPerWeek +
                '}';
    }
}
