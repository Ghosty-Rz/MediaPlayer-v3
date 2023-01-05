package dj2.Persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dj2.core.PlaylistHolder;

public class PlaylistHolderPersist {
    private static final String playlistholderser = "playlistholder.ser";
    private static PlaylistHolder playlistholder;
    private static ObjectInputStream In;
    private static ObjectOutputStream Out;

    private PlaylistHolderPersist(){
        //don't let anyone instantiate me
    }

    public static PlaylistHolder getInstance(){
        if (playlistholder == null)
        try {
                In = new ObjectInputStream(new FileInputStream(playlistholderser));
                playlistholder = (PlaylistHolder)In.readObject();
                
                In.close();
    }catch (Exception e){
        System.out.println ("something went wrong");
    }
        return playlistholder;
    }


    public static void savePlaylistHolder() throws IOException {
        if(playlistholder == null)
            return;
        Out = new ObjectOutputStream(new FileOutputStream(playlistholderser));
        Out.writeObject(playlistholder);
        Out.close();
    }
}
