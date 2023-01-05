package dj2.core;

import java.io.Serializable;

public class GenericList<T extends DisplayableArtistWorks> implements Serializable {
    private GenericNode<T> head;
    private GenericNode<T> tail;

    public GenericList (){
        head = tail = null;
    }

    public void add (T object){
        if (head == null)
            head = tail = new GenericNode<T>(object);
        else {
            tail.next = new GenericNode<T>(object);
            tail = tail.next;
        }
    }

    public int getCount (){
        int count = 0;
        for (GenericNode<T> walker=head; walker != null; walker=walker.next)
            count ++;
        
        return count;
    }

    public String display (){
        StringBuffer string = new StringBuffer();
        for(GenericNode<T> walker = head; walker != null; walker = walker.next){
            string.append(walker.object.display());
            string.append("\n");
        }
        return string.toString();
    }
    
}
