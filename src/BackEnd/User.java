package BackEnd;

import java.util.HashMap;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class User {
    private String firstName;
    private String lastName;
    private int socialness;
    private int nbTimes;
    private boolean isValid;
    private UserVector vector;
    private int ID;
    private boolean isFree;
    private HashMap<Integer, Integer> numberGamesPlayedWithPlayer;

    public User() {
        vector = new UserVector();
        isFree = false;
        numberGamesPlayedWithPlayer = new HashMap<>();
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
    public boolean isValid(){
        if(socialness>10 || socialness<0)
            return false;
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
    public void setNbTimes(int nbTimes ){
        this.nbTimes = nbTimes;
    }

    //Methods

    public void calculateVector() {
        //TODO
    }
}
