package dj2.core;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.sound.sampled.spi.AudioFileReader;

public class MusicTrack implements DisplayableArtistWorks{
    private String title;
    private Style style;
    private int duration;
    private Artist artist;
    private Album type;
    private boolean single;
    private String path;
    private String format;
    private static MusicListLL recentlyPlayed;
    private Clip clip;

    public MusicTrack (String title, int duration, String path, String format){
        this.title = title;
        this.duration = duration;
        this.path = path;
        this.format = format;
        single = false;
        artist = null;
        style = null;
        type = null;
        recentlyPlayed = new MusicListLL ("Recently Played List");

       
    }

    public void setArtist (Artist artist){ 
        this.artist = artist;
    }

    public void setStyle (Style style){
        this.style = style;
        //style.addTrack(this);
    }

    public void setType (Album type){
        this.type = type;
        //type.addTrack(this);
    }

    public void setAsSingle (){
        this.single = true;
        //artist.addSingle(this);
    }

    public String getTitle (){
        return title;
    }

    public int getDuration (){
        return duration;
    }

    public Artist getArtist (){
        return artist;
    }

    public Album getType (){
        return type;
    }

    public boolean getSingleStatus (){
        if (single==true)
            return true;
        return false;
    }

    public String display (){
        if (type == null)
            return "Title: " + title + "\n" + "Duration: " + duration + " s" + "\n" + "Artist: " + artist.getName() + "\n" + "Single: " + single + "\n" + format + " | " + path + "\n" + "***";
        
        return "Title: " + title + "\n" + "Duration: " + duration + " s" + "\n" + "Artist: " + artist.getName() + "\n" + "Album/Concert: " + type.getTitle() + "\n" + format + " | " + path + "\n" + "***";
    }

    public void play (){
        //System.out.println (display ());
        /*System.out.println ("-------------------------------------------");
        System.out.println ( title + " by " + artist.getName() + " is playing now");
        System.out.println ( "playing for " + duration/60 + "min " + duration%60 + "s");
        System.out.println ("-------------------------------------------");*/
        //recentlyPlayed.addTrack(this);

        /*File file = new File(path);
        try {
        AudioInputStream aStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(aStream);
        
        }catch (UnsupportedAudioFileException a){
            System.out.println("a1");
        }catch (IOException b){
            System.out.println("b1");
        }catch (LineUnavailableException c){
            System.out.println("c1");
        }

        clip.start();*/

    File temp = new File(path);
    String file = temp.getAbsolutePath();
    File mymusic = new File(file);
    try {
    AudioInputStream aStream = AudioSystem.getAudioInputStream(mymusic);
            clip = AudioSystem.getClip();
            clip.open(aStream);
    }catch (UnsupportedAudioFileException a){
        System.out.println("a1");
    }catch (IOException b){
        System.out.println("b1");
    }catch (LineUnavailableException c){
        System.out.println("c1");
    }    
        clip.start();
    }

public void Stop(){
    clip.stop();
}

    public MusicListLL getRecentlyPlayed (){
        return recentlyPlayed;
    }
}
