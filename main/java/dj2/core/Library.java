package dj2.core;

import java.io.Serializable;

public class Library implements Serializable{
    private static Style [] styles;
    private static int numberOfStyles;


    public Library (){
        styles = new Style[30];
        numberOfStyles=0;
    }

    public void addStyle (Style style){
        styles[numberOfStyles++] = style;
    }

    public static Style[] getStyles (){
        Style[] stys = new Style[numberOfStyles];
        for(int i = 0; i < numberOfStyles; i++)
            stys[i] = styles[i];        
        return stys;
    }

    public int getNumberOfStyles (){
        return numberOfStyles;
    }

    /*public RecentlyPlayed getHistory (){
        MusicTrack[] tracktest = styles[0].getTracks();
        return tracktest[0].getRecentlyPlayed();
    }*/
}
