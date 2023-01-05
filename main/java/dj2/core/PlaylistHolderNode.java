package dj2.core;

public class PlaylistHolderNode {
    public Playlist list;
    public PlaylistHolderNode next;

    public PlaylistHolderNode (Playlist list){
        this.list = list;
        next = null;
    }
}
