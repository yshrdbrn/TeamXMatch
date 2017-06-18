package BackEnd;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class User {
    private String firstName;
    private String lastName;
    private int socialness;
    private int howOftenUserPlaysPerWeek;
    private ArrayList<Double> vector;
    private double dotProductResult;
    private int ID;
    private boolean isFree;
    private HashMap<Integer, Integer> numberGamesPlayedWithPlayer;

    private double rating;
    private double gamesPlayed;

    public User() {
        vector = new ArrayList<>();
        isFree = false;
        numberGamesPlayedWithPlayer = new HashMap<>();
        rating = 0;
        gamesPlayed = 0;
    }


    //Getters

    public int getID() {
        return ID;
    }

    public boolean isFree() {
        return isFree;
    }

    public ArrayList<Double> getVector() {
        return vector;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public double getDotProductResult() {
        return dotProductResult;
    }


    //Setters

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFree(boolean free) {
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

    public void calculateVector(User otherUser) {
        vector.add((double) socialness);
        vector.add((double) howOftenUserPlaysPerWeek);

        if (numberGamesPlayedWithPlayer.get(otherUser.getID()) != null)
            vector.add((double) numberGamesPlayedWithPlayer.get(otherUser.getID()));
        else
            vector.add(0.0);

        vector.add(rating);
    }

    public void calculateDotProduct(ArrayList<Double> anotherVector) {
  //      System.out.println(this.vector.size() + "     "  + anotherVector.size());
        double result = 0;
        for (int i = 0; i < vector.size(); i++) {
            result += vector.get(i) * anotherVector.get(i);
        }

        dotProductResult = result;
    }

    public void updateRating(double rating) {
        this.rating = ( this.rating * gamesPlayed  +  rating ) / (gamesPlayed + 1);
        gamesPlayed++;
    }

    public void updateNumberOfGamesPlayedTogether(User otherPlayer) {
        Integer num = numberGamesPlayedWithPlayer.get(otherPlayer.getID());
        if (num != null)
            numberGamesPlayedWithPlayer.put(otherPlayer.getID(), num + 1);
        else
            numberGamesPlayedWithPlayer.put(otherPlayer.getID(), 1);
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
