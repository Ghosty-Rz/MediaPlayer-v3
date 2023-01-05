package dj2.core;

public class GenericNode<T extends DisplayableArtistWorks> {
    public T object;
    public GenericNode<T> next;

    public GenericNode (T object){
        this.object = object;
        next = null;
    }
}
