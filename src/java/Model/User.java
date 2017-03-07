package Model;

public class User {
    private String nif;
    private String pass;
    private boolean vote;
    private int id;
    
    public User(String nif, String pass, boolean vote) {
        this.nif = nif;
        this.pass = pass;
        this.vote = vote;
    }

    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean getVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    @Override
    public String toString() {
        return "user{" + "nif=" + nif + ", pass=" + pass + ", vote=" + vote + '}';
    }
    
}
