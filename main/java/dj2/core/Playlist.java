package dj2.core;

public class Playlist extends MusicListLL {
    private static int numberOfPlaylist = 0;
    private static PlaylistHolder playlistHolder = new PlaylistHolder();

    public  Playlist (String name){
        super(name);
        numberOfPlaylist++ ;
        this.name = numberOfPlaylist + ". " + name;
        playlistHolder.addList(this);
    }

    public int getPlaylistNumber (){
        return numberOfPlaylist;
    }


}
