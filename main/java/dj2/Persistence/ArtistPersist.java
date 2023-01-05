package dj2.Persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dj2.core.Artist;

public class ArtistPersist {
    private static final String artistser = "artist.ser";
    private static Artist artist;
    private static ObjectInputStream In;
    private static ObjectOutputStream Out;

    private ArtistPersist(){
        //don't let anyone instantiate me
    }

    public static Artist getInstance(){
        if (artist == null)
        try {
                In = new ObjectInputStream(new FileInputStream(artistser));
                artist = (Artist)In.readObject();
                
                In.close();
    }catch (Exception e){
        System.out.println ("something went wrong");
    }
        return artist;
    }


    public static void saveArtist() throws IOException {
        if(artist == null)
            return;
        Out = new ObjectOutputStream(new FileOutputStream(artistser));
        Out.writeObject(artist);
        Out.close();
    }

}
