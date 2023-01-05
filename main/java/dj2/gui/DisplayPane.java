package dj2.gui;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

import dj2.core.Album;
import dj2.core.Artist;
import dj2.core.MusicTrack;

public class DisplayPane extends JPanel{
    //private JPanel pane;
    private JTextArea textArea;
    //private JTextArea artistTextArea;
    //private JTextArea albumTextArea;
    private JLabel image;
    private Artist artist;
    private Album album;
    private MusicTrack track;

    public DisplayPane (){
        //pane = new JPanel();
        setBorder(BorderFactory.createLineBorder(new Color(206,135,189), 2));
        setPreferredSize(new DimensionUIResource(330, 366));
        textArea = new JTextArea();
        textArea.setEnabled(false);
        textArea.setFont(new Font("Verdana", Font.BOLD, 12));
        textArea.setPreferredSize(new DimensionUIResource(320, 355));
        textArea.setText("♪♪♪ Nothing To Display ♪♪♪");
        add(textArea);

        /*artistTextArea = new JTextArea();
        artistTextArea.setEnabled(false);
        artistTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
        pane.add(artistTextArea);

        albumTextArea = new JTextArea();
        albumTextArea.setEnabled(false);
        albumTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
        pane.add(albumTextArea);*/

 

    }

    public void updateTrack (MusicTrack track){
        this.textArea.setText(track.display());
    }

    public void updateArtist (Artist artist){
        this.textArea.setText(artist.display());
    }
    public void updateAlbum (Album album){
        this.textArea.setText(album.display());
    }

    public void clear (){
        this.textArea.setText("♪♪♪ Nothing To Display ♪♪♪");
    }
    
}
