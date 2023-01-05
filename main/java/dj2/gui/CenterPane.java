package dj2.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.*;

import java.awt.*;

import dj2.core.Library;
import dj2.core.MusicTrack;
import dj2.core.Style;
import dj2.core.*;

public class CenterPane extends JTabbedPane{
    
    public CenterPane (Library library){
        Style[] styles = Library.getStyles();
        setFont(new Font("Verdana", Font.BOLD, 12));
        for(Style style : styles){
            MusicTrack[] musicTracks = style.getTracks();

            if (musicTracks == null)
                continue;
            
            JPanel songsPane = new JPanel();
            songsPane.setLayout(new FlowLayout());
            for(MusicTrack track : musicTracks)
                songsPane.add(new TrackPane(track, track.getArtist()));

            this.add(style.getName(), songsPane);
    }
    }
}


 
