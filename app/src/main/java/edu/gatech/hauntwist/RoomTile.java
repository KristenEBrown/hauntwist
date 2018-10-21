package edu.gatech.hauntwist;

import java.util.Random;

public class RoomTile extends MapTile{
    private boolean containsItem;
    private RoomItem item;
    private HallwayTile entrance;
    private boolean hasItem;
    private Random rand;
    private int roomType;

    public RoomTile(int row, int col) {
        super(row, col);
        entrance = null;
        hasItem = false;
        rand = new Random();
        roomType = rand.nextInt(3);

    }

    public void setEntrance(HallwayTile entrance) {
        this.entrance = entrance;
    }

    public HallwayTile getEntrance() {
        return entrance;
    }

    public int getRow() {
        return super.getRow();
    }

    public int getCol() {
        return super.getCol();
    }

    public int getType(){ return roomType; }

    public boolean isConnected() {
        return this.entrance != null;
    }

    public boolean hasItem() { return hasItem; }
    public void setHasItem(boolean b) { hasItem = b; }

    @Override
    public String toString(){
        if (this.getEntrance() == null) {
            return "*";
        }
        return "@";
    }

}
