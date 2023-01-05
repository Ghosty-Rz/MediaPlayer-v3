package dj2.core;

import java.io.Serializable;

public class Artist implements Serializable{
    private String name;
    private String bio;
    private String picture; //the string is for the picture's path
    private GenericList<MusicTrack> singles; 
    private GenericList<Album> albums; 
    private GenericList<Album> concerts;
    private int numberSingles;
    private int numberAlbums;
    private int numberConcerts;
    

    public Artist (String name, String bio, String picture){
        this.name = name;
        this.bio = bio;
        this.picture = picture;
        singles = new GenericList<MusicTrack> ();
        numberSingles = 0;
        albums = new GenericList<Album> ();
        numberAlbums = 0;
        concerts = new GenericList<Album> ();
        numberConcerts = 0;
    }
    
    public String getName (){
        return name;
    }

    public void attachSong (MusicTrack track){
        if (track.getSingleStatus()==true)
            singles.add(track);
        if (track.getType().getIsOrNot()==true)
            albums.add(track.getType());
        else {
            concerts.add(track.getType());
        }
    }

    public void updateName (String name){
        this.name = name;
    }

    public void updateBio (String bio){
        this.bio = bio;
    }

    public void updatePicture (String picture){
        this.picture = picture;
    }

    public void setWorkNumbers (){
        numberSingles = singles.getCount();
        numberAlbums = albums.getCount();
        numberConcerts = concerts.getCount();
    }

    public String display (){
        return "Name: " + name + "\n" + "Bio: " + bio + "\n" + numberSingles + "Singles" + "\n" + numberAlbums + "Albums" + "\n" + numberConcerts + "Concerts" + "\n"; 
    }

    public String displaySingles (){
        return singles.display();
    }

    public String displayAlbums (){
        return albums.display();
    }

    public String displayConcerts (){
        return concerts.display();
    }
}
