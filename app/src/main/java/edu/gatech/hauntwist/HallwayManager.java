package edu.gatech.hauntwist;

import java.util.List;
import java.util.ArrayList;

public class HallwayManager {
    private List<HallwayTile> hall;
    private HallwayTile connector;

    public HallwayManager(){
        hall = new ArrayList<>();
    }

    public void add(HallwayTile h){
        hall.add(h);
    }

    public void remove(HallwayTile h){
        hall.remove(h);
    }

    public HallwayTile getEnd(){
        if (!(hall.isEmpty())){
            return hall.get(hall.size() - 1);
        }
        return null;
    }

    public HallwayTile get(int index){
        return hall.get(index);
    }

    public int size(){
        return hall.size();
    }

    public void setConnector(HallwayTile h){
        this.connector = h;
    }

    public HallwayTile getConnector(){
        return this.connector;
    }

}
