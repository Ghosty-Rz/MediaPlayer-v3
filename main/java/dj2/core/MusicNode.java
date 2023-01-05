package dj2.core;

public class MusicNode {
    public MusicTrack track;
    public MusicNode next;

    public MusicNode (MusicTrack track){
        this.track = track;
        next = null;
    }
}
