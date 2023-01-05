package dj2.gui;

import dj2.Persistence.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

class MenuBar extends JMenuBar {
    private JMenu menuFile = new JMenu("File");
    private JMenuItem menuFileSave = new JMenuItem("Save");
    private JMenuItem menuFileExit = new JMenuItem("Exit");
    private static AlbumPersist albumPersist;
    private static ArtistPersist artistPersist;
    private static LibraryPersist libraryPersist;
    private static PlaylistHolderPersist playlistHolderPersist;

    protected MenuBar(){
        super();
        menuFile.add(menuFileSave);
        menuFile.add(menuFileExit);
        add(menuFile);
        
        menuFileSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                try {
                albumPersist.saveAlbum();
                artistPersist.saveArtist();
                libraryPersist.saveLibrary();
                playlistHolderPersist.savePlaylistHolder();
                }catch (Exception a){
                    System.out.println("Something went wrong");
                }
            }
        });

        menuFileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        
    }
}
