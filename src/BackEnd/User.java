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

//    public String getName() {
//        return name;
//    }

    public int getID() {
        return ID;
    }

    public boolean isFree() {
        return isFree;
    }

    public int getSocialness(){
        return socialness;
    }

    public ArrayList<Double> getVector() {
        return vector;
    }
    public int getHowOftenUserPlaysPerWeek(){
        return howOftenUserPlaysPerWeek;
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

//    public void setName(String name) {
//        this.name = name;
//    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
    public void setName(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Hello " + firstName + " " + lastName);
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
        vector.add((double) numberGamesPlayedWithPlayer.get(otherUser.getID()));
        vector.add(rating);
    }

    public void calculateDotProduct(ArrayList<Double> anotherVector) {
        double result = 0;
        for (int i = 0; i < vector.size(); i++) {
            result += vector.get(i) * anotherVector.get(i);
        }

        dotProductResult = result;
    }
}
