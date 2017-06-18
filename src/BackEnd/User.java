package BackEnd;

import java.util.HashMap;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class User {
    private String name;
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

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public boolean isFree() {
        return isFree;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    //Methods

    public void calculateVector() {
        //TODO
    }
}
