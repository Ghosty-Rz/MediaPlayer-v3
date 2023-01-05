package dj2.core;

import java.io.Serializable;

public class Style implements Serializable {
    private String name;
    private MusicListLL listOfSongs;


    public Style (String name){
        this.name = name;
        listOfSongs = new MusicListLL(name);
    }
    
    public void addTrack (MusicTrack track){
        listOfSongs.addTrack(track);
        track.setStyle(this);
    }

    public String getName (){
        return name;
    }

    public MusicTrack[] getTracks (){
        Object[] temp = listOfSongs.toArray();
        if(temp == null)
            return null;

        MusicTrack[] songs = new MusicTrack[temp.length];
        int index =  0;
        for(Object object : temp)
            songs[index++] = (MusicTrack)object;

        return songs;
        //return listOfStyles.toArray();
    }

    

}
