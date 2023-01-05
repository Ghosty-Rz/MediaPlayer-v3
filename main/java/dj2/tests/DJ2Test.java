package dj2.tests;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import dj2.core.Album;
import dj2.core.Artist;
import dj2.core.Concert;
import dj2.core.Group;
import dj2.core.MusicListLL;
import dj2.core.MusicTrack;

public class DJ2Test {

    public static void main (String[] args){
        /*try {
        Scanner scanner = new Scanner(System.in); //may be temparary

        File file1 = new File ("C:/Users/Rihab/Desktop/dj2/app/src/Michael Jackson - Rock With You.wav");
        AudioInputStream aStream = AudioSystem.getAudioInputStream(file1); //throws
        Clip clip = AudioSystem.getClip();
        clip.open(aStream); //throws

        

        String response = "";

        while (!response.equals("Q")){
            clip.start();
            response = scanner.next();
        }

        scanner.close();

        }catch (UnsupportedAudioFileException uafe){
            System.out.println("prob 1");
        }catch (IOException ioe){
            System.out.println("prob 2");
        }catch (LineUnavailableException lue){
            System.out.println("prob 3");
        }*/

        /*try {
        File file = new File("musicfiles/Michael Jackson - Rock With You.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        

        clip.start();

        }catch (UnsupportedAudioFileException a){ a.printStackTrace();}
        catch (IOException b){ b.printStackTrace();}
        catch (LineUnavailableException c){ c.printStackTrace();}*/

        MusicTrack musicTrack1 = new MusicTrack("Rock With You", 218, "https://www.media.com/watch?", "mp3");
        musicTrack1.setArtist(new Artist("Michael Jackson", "Born in 1958, Known as the 'King Of Pop' Michael Jackson was a best-selling American singer, songwriter and dancer", "data:image/jpeg;base64,/9j"));
        musicTrack1.setAsSingle();

        MusicTrack musicTrack2 = new MusicTrack ("Fireflies", 232, "https://www.media.com/watch?i", "mp3");
        musicTrack2.setArtist(new Group("Gorillaz", "Gorillaz are an English virtual band formed in 1998 by musician Damon Albarn and artist Jamie Hewlett, from London, England", "data:image/jpeg;base57,/9k", "Russel Hobbs - Murdoc Niccals - 2-D - noodle"));
        Album album1 = new Album("The Now Now", "data:image/png;base62,/3l", "The Now Now is the sixth studio album recorded by the British virtual band Gorillaz, released on 29 June 2018 via Parlophone and Warner Bros. Records", "29 June 2018");
        musicTrack2.setType(album1);
        album1.addTrack(musicTrack2);  

        MusicTrack musicTrack3 = new MusicTrack("Joudia", 315, "https://www.youtube.com/watch?v", "mp3");
        musicTrack3.setArtist(new Artist("Soukaina Fahsi", "Born in 1993, in El JAdida, Morocco. Soukaina FAHSI is a lyricist, composer and singer from Morocco.", "data:image/png;base64,/5j"));
        Concert concert1 = new Concert("live concert Rabat 'visa for music'", "data:image/png;base62,/2j", "The young singer Soukaina Fahsi ended the opening show of the 6th edition of 'Visa for Music' 2019 as part of the first professional fair and festival of music from Africa and the Middle East.", "23 November 2019", "Mohammed V National Theater Rabat");
        musicTrack3.setType(concert1);
        concert1.addTrack(musicTrack3);
        
        // (above) Now done creating music tracks and their types(album/concert/single) and artists

        System.out.println ("WELCOME !\n");

        System.out.println (musicTrack1.display());
        System.out.println (musicTrack2.display());
        System.out.println (musicTrack3.display());

        // (above) displaying the 3 created songs

        musicTrack1.play();
        musicTrack2.play();
        musicTrack3.play();

        // (above) played 3 songs 

        musicTrack3.getRecentlyPlayed().displayList();
        // (above) displaying the music tracks in the recently played list

        // (below) creating a playlist
        MusicListLL playlist1 = new MusicListLL("my favorites");
        playlist1.addTrack(musicTrack1);
        playlist1.addTrack(musicTrack2);

        playlist1.displayList();

        playlist1.playEverything(); // playing the playlist
        
    }   
    
}
