package dj2.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.*;

import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

import dj2.core.Library;
import dj2.core.MusicListLL;
import dj2.core.MusicTrack;


public class HistoryPane extends JPanel {
    private JButton playButton;
    private JButton stopButton;
    private JTextArea textArea;
    private MusicTrack track = new MusicTrack("1", 1, "1", "1");


    public HistoryPane (){
        
        setLayout(new BorderLayout());
        setPreferredSize(new DimensionUIResource(280, 300));

        JLabel label = new JLabel("History: ");
        label.setFont(new FontUIResource("Verdana", Font.BOLD, 12));
        add(label, BorderLayout.NORTH);
        playButton = new JButton("PLay");
        //add(playButton);

        stopButton = new JButton("Stop");
        //add(stopButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(playButton);
        splitPane.setRightComponent(stopButton);
        add(splitPane, BorderLayout.SOUTH);

        textArea = new JTextArea();
        update();
        //textArea.setText(library.getHistory().displayList());
        add(textArea, BorderLayout.CENTER);
        
    }

    public void update() {
        textArea.setText(track.getRecentlyPlayed().displayList());
    }


}
