package Model;


import java.sql.Blob;

public class Anime {
    
    private String name;
    private int votes;
    private byte[] img;
    
    public Anime(String name) {
        this.name = name;
    }
    
    public Anime(String name, int votes, byte[] img){
        this.name = name;
        this.votes = votes;
        this.img = img;
    }
    
    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Anime{" + "name=" + name + ", votes=" + votes + '}';
    }
    
}
