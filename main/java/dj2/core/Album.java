package dj2.core;

import java.io.Serializable;

public class Album implements DisplayableArtistWorks, Serializable { //check again : artist ?
    private String title;
    private String picture;
    private String description;
    private String releaseDate;
    private int numberOfSongs;
    private int durationAllSongs;
    private static MusicListLL list;
    protected boolean isOrNot;


    public Album (String title, String picture, String description, String releaseDate){
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.releaseDate = releaseDate;
        list = new MusicListLL(title);
        numberOfSongs = 0;
        durationAllSongs = 0;
    }
    
    public void addTrack (MusicTrack track){
        list.addTrack(track);
    }

    public void setNumberTracks (){
        numberOfSongs = list.count();
    }

    public void setTotalDuration (){
        durationAllSongs = list.countDuration();
    } 

    public void updatePicture (String picture){
        this.picture = picture;
    }

    public void updateDescriptiobn (String description){
        this.description = description;
    }

    public void updateTitle (String title){
        this.title = title;
    }

    public String getTitle (){
        return title;
    }

    public void setTypeTitle (String title){
        this.title = title;
    }

    protected String display1 (){
        return "Title: " + title + "\n" + "releaseDate: " + releaseDate + "\n" + "Description: " + description + "\n" + "Number of tracks in the album: " + numberOfSongs + "\n" + "Duration of the playlist: " + durationAllSongs + "\n";
    }

    public String display (){
        StringBuffer sb = new StringBuffer();

        sb.append (display1());
        //sb.append(list.displaylistOfSongs());

        return sb.toString();
    }

    public void playPlaylist (){
        list.playEverything();
    }

    protected void setBoolean (){
        isOrNot = true;
    }

    public boolean getIsOrNot (){
        return isOrNot;
    }
}
