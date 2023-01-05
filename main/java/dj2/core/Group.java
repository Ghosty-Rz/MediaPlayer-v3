package dj2.core;

public class Group extends Artist {
    private String members;

    public Group (String name,String bio, String picture, String members){
        super(name, bio, picture);
        this.members = members;
    }

    public void updateMembers (String members){
        this.members = members;
    }

    public String display (){
        return super.display() + "Members: " + members + "\n";
    }

}
