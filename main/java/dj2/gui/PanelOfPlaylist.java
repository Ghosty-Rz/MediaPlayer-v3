package dj2.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dj2.core.Playlist;
import java.awt.*;
import java.awt.BorderLayout;

import javax.swing.*;


public class PanelOfPlaylist extends JPanel {
    private JTextArea textArea;

    public PanelOfPlaylist (Playlist playlist){
    
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Verdana", Font.BOLD, 12));
        
        this.setLayout(new BorderLayout());
        //add(playButton, BorderLayout.SOUTH);
        playButton.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent ae){
                playlist.playEverything();
            }
        });

        JButton stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Verdana", Font.BOLD, 12));
        //add(stopButton);
        stopButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                playlist.stopPlaying();
            }
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(playButton);
        splitPane.setRightComponent(stopButton);
        this.add(splitPane, BorderLayout.SOUTH);

        JTextArea textArea = new JTextArea();
                textArea.setEnabled(false);
                textArea.setFont(new Font("Verdana", Font.BOLD, 12));
                add(new JScrollPane(textArea), BorderLayout.NORTH);

                textArea.setText(playlist.displayList());
                //update(playlist);
    }

    public void update (Playlist playlist){
        textArea.setText(playlist.displayList());
    }
}

