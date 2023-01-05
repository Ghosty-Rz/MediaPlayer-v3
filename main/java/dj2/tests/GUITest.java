package dj2.tests;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import dj2.core.Library;
import dj2.core.Style;
import dj2.gui.MainFrame;
import dj2.core.*;



public class GUITest {
    public GUITest() {
        super();
    }

    public static void main(String[] args) throws Exception {

        Library library = buildLibrary();

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MainFrame mainFrame = new MainFrame(library);
       


    }

    private static Library buildLibrary(){
        Library library = new Library();

        Style discoFunk = new Style("Disco funk");
        Style pop = new Style("Pop");
        Style jazz = new Style("Jazz");

        library.addStyle(discoFunk);
        library.addStyle(pop);
        library.addStyle(jazz);
        

        MusicTrack musicTrack1 = new MusicTrack("Rock With You", 218, "Michael_Jackson_Rock_With_You.wav", ".wav");
        musicTrack1.setArtist(new Artist("Michael Jackson", "Born in 1958, Known as the 'King Of Pop' Michael Jackson was a best-selling American singer, songwriter and dancer", "image1"));
        musicTrack1.setAsSingle();
        discoFunk.addTrack(musicTrack1);

        MusicTrack musicTrack2 = new MusicTrack ("Fireflies", 232, "Gorillaz_Fire_Flies.wav", ".wav");
        musicTrack2.setArtist(new Group("Gorillaz", "Gorillaz are an English virtual band formed in 1998 by musician Damon Albarn and artist Jamie Hewlett, from London, England", "image2", "Russel Hobbs - Murdoc Niccals - 2-D - noodle"));
        Album album1 = new Album("The Now Now", "image3", "The Now Now is the sixth studio album recorded by the British virtual band Gorillaz, released on 29 June 2018 via Parlophone and Warner Bros. Records", "29 June 2018");
        musicTrack2.setType(album1);
        album1.addTrack(musicTrack2);
        pop.addTrack(musicTrack2);

        MusicTrack musicTrack3 = new MusicTrack("Joudia", 315, "Soukaina_Fahsi_Joudia.wav", ".wav");
        musicTrack3.setArtist(new Artist("Soukaina Fahsi", "Born in 1993, in El JAdida, Morocco. Soukaina FAHSI is a lyricist, composer and singer from Morocco.", "image4"));
        Concert concert1 = new Concert("live concert Rabat 'visa for music'", "image5", "The young singer Soukaina Fahsi ended the opening show of the 6th edition of 'Visa for Music' 2019 as part of the first professional fair and festival of music from Africa and the Middle East.", "23 November 2019", "Mohammed V National Theater Rabat");
        musicTrack3.setType(concert1);
        concert1.addTrack(musicTrack3);
        jazz.addTrack(musicTrack3);

        

        return library;
    }
    
}
