package dj2.core;

import java.io.Serializable;

public class PlaylistHolder implements Serializable{
    private static PlaylistHolderNode head;
    private static PlaylistHolderNode tail;

    public PlaylistHolder (){
        head = tail = null;
    }

    public static void addList (Playlist list){
        if (head == null){
            head = tail = new PlaylistHolderNode(list);
        }
        else {
            tail.next = new PlaylistHolderNode(list);
            tail = tail.next;
        }
    }

    public Playlist compareNumbers (Object i) throws NumberOfPlaylistNotFoundException{
        for (PlaylistHolderNode walker=head; walker!=null; walker=walker.next){
            if (walker.list.getPlaylistNumber() == (int)i)
                return walker.list;
        }
        throw new NumberOfPlaylistNotFoundException();
    }


}
