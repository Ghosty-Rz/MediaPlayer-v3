package dj2.gui;

import java.awt.Font;
import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;


import dj2.core.MusicListLL;
import dj2.core.Playlist;

public class PlaylistPane extends JPanel{
    //private JPanel boxPane;
    private MusicListLL[] playlists ;
    private int numberOfPlaylists;
    private FlowLayout flayout;
    //private PlaylistTabbedPane playlistTabbedPane = new PlaylistTabbedPane();
    private JTabbedPane playlistTabbedPane = new JTabbedPane();

    public PlaylistPane (){
        super();
        
        //boxPane = new JPanel();
        //JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
        
        JLabel label = new JLabel();
        label.setFont(new FontUIResource("Verdana", Font.BOLD, 12));
        label.setText("Playlists :");
        setLayout(new BorderLayout());
        //add(scrollBar, BorderLayout.WEST);
        add(label, BorderLayout.NORTH);

        JButton addPlaylisButton = new JButton("Click To Add New Playlist");
        addPlaylisButton.setSize(196, 30);
        add(addPlaylisButton, BorderLayout.CENTER);
        //boxPane.setLayout(new BoxLayout(boxPane, BoxLayout.Y_AXIS));
        add(playlistTabbedPane, BorderLayout.SOUTH);

        addPlaylisButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                
                String name = JOptionPane.showInputDialog("Name the Playlist");
                Playlist playlist1 = new Playlist(name); 
                //creating the new pane for the playlist
                
                PanelOfPlaylist pane = new PanelOfPlaylist(playlist1);
                
                playlistTabbedPane.addTab(playlist1.getName(), pane);
                //add the pane 

                //playlistsPane.addPlaylist(playlist1);
                //boxPane.add(playlistpane);
                //add(playlistpane, BorderLayout.SOUTH);

                
            }
        });
        
        
    }

    public JTabbedPane getTabbedPane (){
        return playlistTabbedPane;
    }
}
