package dj2.core;

import java.io.Serializable;

public class MusicListLL implements Serializable{
    protected MusicNode head;
    protected MusicNode tail;
    protected int size;
    protected String name;

    public MusicListLL (String name){
        head = tail = null;
        this.name = name;
        size = 0;
    }

    public void addTrack (MusicTrack track){
        if(head == null)
            head = tail = new MusicNode(track);
        else {
            tail.next = new MusicNode(track);
            tail = tail.next;
        }
        size++;
    }

    /*public void playEverything (){
        for (MusicNode walker=head; walker != null; walker= walker.next)
            walker.track.play();
    }*/

    public void playEverything (){
        int i = 0;
        int numberOfTracks;
        numberOfTracks = count();
            for (MusicNode walker=head; walker != null; walker= walker.next){
                walker.track.play();
                i++;
                if (i == numberOfTracks)
                    return;
            }
    }

    public void stopPlaying (){
        tail.track.Stop();
    }

    public String getName (){
        return name;
    }

    public String displayList (){
        return name + ":" + "\n" + "Total Duration: " +countDuration()/60+ "min " +countDuration()%60+ "s" + "\n" + displaylistOfSongs() + "-------------------------------------------" + "\n";
    }

    public String displaylistOfSongs (){
        StringBuffer sb = new StringBuffer();

        int num = 1;
        for (MusicNode walker=head; walker != null; walker= walker.next){
            sb.append (num + ". " + walker.track.getTitle());
            sb.append("\n");
            num++ ;
        }

        return sb.toString();
    }

    public Object[] toArray (){
       
         if(size == 0)
            return null;
        Object[] tracks = new Object[size];
        int index = 0;
        for(MusicNode walker = head; walker != null; walker = walker.next){
            tracks[index] = walker.track;
            index++;
        }
        return tracks;
     }
    
    public int count (){ //this returns the number of tracks in a linked list
        int numberTracks=0;
        for (MusicNode walker=head; walker != null; walker=walker.next)
            numberTracks++;

        return numberTracks;
    }

    public int countDuration (){ //this calculates the total of duration of the tracks in a playlist
        int totalDuration = 0; 
        for (MusicNode walker=head; walker != null; walker= walker.next)
            totalDuration += walker.track.getDuration();

        return totalDuration;

}

}
