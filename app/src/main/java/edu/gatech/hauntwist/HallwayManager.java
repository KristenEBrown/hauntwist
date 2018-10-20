package edu.gatech.hauntwist;

import java.util.List;
import java.util.ArrayList;

public class HallwayManager {
    private List<HallwayTile> hall;
    private boolean keep;

    public HallwayManager(){
        hall = new ArrayList<>();
        keep = true;
    }

    public void add(HallwayTile h){
        if(h.getCol() == -1 || h.getRow() == -1){
            keep = false;
        }
        hall.add(h);
    }

    public void remove(HallwayTile h){
        hall.remove(h);
    }

}
