import java.util.ArrayList;

// Reuse the Album class from the last assignment,
// ensure that it implements comparable,
public class Album implements Comparable<Album> {
    Integer ID;
    ArrayList<String> artistName;
    String title;
    Integer numSongs;

    // it has a numerical ID, able to store multiple artists' names,
    // a title, and have the number of songs on the album
    public Album(int id, ArrayList<String> name, String title, int num){
        this.ID = id;
        this.artistName = name;
        this.title = title;
        this.numSongs = num;
    }

    public int getID(){
        return ID;
    }

    public void setID(int id){
        this.ID = id;
    }

    public ArrayList<String> getName(){
        return artistName;
    }

    public void setName(ArrayList<String> name){
        this.artistName = name;
    }

    public String getTitle(){
        return title;
    }

    public void setID(String title){
        this.title = title;
    }

    public int getNumSong(){
        return numSongs;
    }

    public void setNumSong(int num){
        this.numSongs = num;
    }

        public String getNameString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i< artistName.size()-1; i++){
            stringBuilder.append(String.format("%s, ",artistName.get(i)));
        }
        stringBuilder.append(String.format("%s",artistName.get(artistName.size()-1)));
        return stringBuilder.toString();
    }

    // Compare the number of songs
    @Override
    public int compareTo(Album o) {
        if(this.numSongs > o.numSongs){
            return 1;
        }
        else if (this.numSongs == o.numSongs){
            return 0;
        }
        else{
            return -1;
        }
    }

    // The toString return ID: NUM_SONGS -- [ARTISTS NAMES]
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(" %d: %d -- [%s] ",this.getID(),this.getNumSong(),this.getNameString()));
        return stringBuilder.toString();
    }
}
