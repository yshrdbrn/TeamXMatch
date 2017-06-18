package BackEnd;

/**
 * Created by yashardabiran on 2017-06-17.
 */
public class User {
    private String name;
    private UserVector vector;
    private int ID;

    public User() {
        vector = new UserVector();
    }

    public User(User user, int ID) {
        this.name = user.name;

        vector = new UserVector();
        this.ID = ID;
    }

    //Getters

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }


    //Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
