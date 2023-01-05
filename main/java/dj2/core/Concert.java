package dj2.core;

public class Concert extends Album {
    private String location;

    public Concert (String title, String picture, String description, String releaseDate, String location){
        super(title, picture, description, releaseDate);
        this.location = location;     
    }

    public void updateLocation (String location){
        this.location = location;
    }

    protected String display1 (){
        return super.display1() + "Location: " + location + "\n";
    } 

    public String getLocation (){
        return location;
    }

    protected void setBoolean (){
        isOrNot = false;
    }

    public boolean getIsOrNot (){
        return isOrNot;
    }
}
