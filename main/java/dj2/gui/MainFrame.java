package dj2.gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import dj2.core.*;

public class MainFrame extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private PlaylistPane playlistPane;
    private CenterPane centerPane;
    private DisplayPane displayPane;
    private HistoryPane historyPane;

    public MainFrame (Library library){

        playlistPane = new PlaylistPane();
        centerPane = new CenterPane(library);
        displayPane = new DisplayPane();
        historyPane = new HistoryPane();

        JLabel versionLabel = new JLabel("DJ2 v1.0");
        versionLabel.setFont(new Font("Verdana", Font.BOLD, 12));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(versionLabel, BorderLayout.SOUTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(centerPane, BorderLayout.CENTER);
        mainPanel.add(eastPanel, BorderLayout.EAST);

        westPanel.setLayout(new BorderLayout());
        westPanel.add(playlistPane);
        westPanel.setPreferredSize(new Dimension(420, 700));
        
        eastPanel.setLayout(new BorderLayout());
        eastPanel.add(displayPane, BorderLayout.NORTH);
        eastPanel.add(historyPane, BorderLayout.SOUTH);
        eastPanel.setPreferredSize(new Dimension(420, 700));
        
        setTitle("DJ2");
        setJMenuBar(new MenuBar());
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }






    //private JPanel playlistPane = new JPanel();
    //private JPanel songsPane = new JPanel();
    //private JPanel displayPane = new JPanel();
    
    
    /*public MainFrame (){
        playlistPane.setBorder(BorderFactory.createEmptyBorder (30,30,10,30));
        playlistPane.setLayout(new BorderLayout ());
        playlistPane.add(playlistPane,BorderLayout.WEST);

        displayPane.setBorder(BorderFactory.createEmptyBorder (30,30,10,30));
        displayPane.setLayout(new BorderLayout ());
        displayPane.add(displayPane, BorderLayout.EAST);

        setTitle("DJ2");
    }/* */

}
