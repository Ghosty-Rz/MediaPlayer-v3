package dj2.Persistence;


import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import dj2.core.Library;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

public class LibraryPersist {
    

    private static final String libraryser = "library.ser";
    private static Library library;
    private static ObjectInputStream In;
    private static ObjectOutputStream Out;

    private LibraryPersist(){
        //don't let anyone instantiate me
    }

    public static Library getInstance(){
        if (library == null)
        try {
                In = new ObjectInputStream(new FileInputStream(libraryser));
                library = (Library)In.readObject();
                
                In.close();
    }catch (Exception e){
        System.out.println ("something went wrong");
    }
        return library;
    }


    public static void saveLibrary() throws IOException {
        if(library == null)
            return;
        Out = new ObjectOutputStream(new FileOutputStream(libraryser));
        Out.writeObject(library);
        Out.close();
    }

   
}