package dj2.Persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dj2.core.Album;

public class AlbumPersist {
    private static final String albumser = "album.ser";
    private static Album album;
    private static ObjectInputStream In;
    private static ObjectOutputStream Out;

    private AlbumPersist(){
        //don't let anyone instantiate me
    }

    public static Album getInstance(){
        if (album == null)
        try {
                In = new ObjectInputStream(new FileInputStream(albumser));
                album = (Album)In.readObject();
                
                In.close();
    }catch (Exception e){
        System.out.println ("something went wrong");
    }
        return album;
    }


    public static void saveAlbum() throws IOException {
        if(album == null)
            return;
        Out = new ObjectOutputStream(new FileOutputStream(albumser));
        Out.writeObject(album);
        Out.close();
    }

}
