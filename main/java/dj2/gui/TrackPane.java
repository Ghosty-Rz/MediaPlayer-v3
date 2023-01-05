package dj2.gui;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import org.w3c.dom.events.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import dj2.core.*;

public class TrackPane extends JPanel{
  
    private JPanel mainPanel = new JPanel();
    private JButton addToPlaylistButton = new JButton();
    private JButton playButton;
    private JButton stopButton;
    private JComboBox playlistCombotBox = new JComboBox<>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
    private PlaylistHolder playlists;
    private PlaylistPane playlistpane = new PlaylistPane();
    private Playlist playlist;
    private DisplayPane displayPane = new DisplayPane();
    private HistoryPane historyPane;
    private MusicTrack track;
    private Artist artist;
    private int duration;
    private Style style;
    private JTextArea textArea1;
    private Album album;
    private FlowLayout flayout;

    public TrackPane (MusicTrack track, Artist artist){ 
        this.track = track;
        this.artist = artist;
        this.duration = track.getDuration();


        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public void setType (Album type){
        this.album = type;
        
        JLabel albumButtonLabel = new JLabel();
        albumButtonLabel.setText("Album/Concert: " + album.getTitle());
        albumButtonLabel.setBackground(new Color(206, 135, 189));
        albumButtonLabel.addMouseListener(new MouseInputAdapter() {
            Color color = albumButtonLabel.getForeground();
                public void mouseEntered(MouseEvent me) {
                   color = albumButtonLabel.getForeground();
                   albumButtonLabel.setForeground(Color.green); // change the color to green when mouse over a button
                }
                public void mouseExited(MouseEvent me) {
                   albumButtonLabel.setForeground(color);
                }
                public void mouseClicked(MouseEvent me){
                    displayPane.updateArtist(artist);
                }
        });

        this.add(albumButtonLabel);
    }*/

    private void jbInit () throws Exception {
        
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.setBackground(new Color (206,135,189));
        //this.setSize(500, 113);
        textArea1 = new JTextArea();
        textArea1.setText("~ " + track.getTitle() + " ~" + "\n" + "Duration: " + duration/60 + "m " + duration%60 + "s" + "\n" + "Artist: " + artist.getName());
        textArea1.setEditable(false);
        textArea1.setBackground(new Color(206,135,189));
        textArea1.setForeground(Color.WHITE);
        this.add(textArea1);
        
        addToPlaylistButton = new JButton("Add To Playlist");
        addToPlaylistButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int inte = (int)playlistCombotBox.getSelectedItem();
                try {
                playlists.compareNumbers(inte-1).addTrack(track);
                PanelOfPlaylist panel = (PanelOfPlaylist)playlistpane.getTabbedPane().getTabComponentAt(inte);
                panel.update(playlists.compareNumbers(inte-1));
                
                JOptionPane.showMessageDialog(null, "Music Track added");
                
                }catch (NumberOfPlaylistNotFoundException a){
                    JOptionPane.showMessageDialog(null, "The number selected is Invalid");
                }
            }
        });

        this.add(playlistCombotBox);
        this.add(addToPlaylistButton);

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){

                if (track.getSingleStatus()==true) { JOptionPane.showMessageDialog(null, track.display() + "\n" + "ARTIST:" + "\n" + track.getArtist().display()); }
                else { JOptionPane.showMessageDialog(null, track.display() + "\n" + "ARTIST:" + "\n" + track.getArtist().display() + "\n" + "ALBUM/CONCERT:" + "\n" + track.getType().display()); }
            
                track.play();
                displayPane.updateTrack(track);
                historyPane.update();
                
                //use the code to play sound
            }
        });
        this.add(playButton);
    
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                displayPane.clear();
                track.Stop();
                //use code to stop sound 
            }
        });
        this.add(stopButton);

        /*JLabel artistButtonLabel = new JLabel();
        artistButtonLabel.setText("Artist: " + artist.getName());
        artistButtonLabel.setBackground(new Color(206, 135, 189));
        artistButtonLabel.addMouseListener(new MouseInputAdapter() {
            Color color = artistButtonLabel.getForeground();
                public void mouseEntered(MouseEvent me) {
                   //color = artistButtonLabel.getForeground();
                   //artistButtonLabel.setForeground(Color.green); // change the color to green when mouse over a button
                   JOptionPane.showMessageDialog(null, track.getArtist().display());
                }
                public void mouseExited(MouseEvent me) {
                   //artistButtonLabel.setForeground(color);
                }
                public void mouseClicked(MouseEvent me){
                    JOptionPane.showMessageDialog(null, track.getArtist().display());
                }
        

        });

        this.add(artistButtonLabel);*/

    }


}
