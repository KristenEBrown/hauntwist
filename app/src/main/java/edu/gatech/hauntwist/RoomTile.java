package edu.gatech.hauntwist;

public class RoomTile extends MapTile{
    private boolean containsItem;
    private RoomItem item;
    private int row;
    private int col;
    private HallwayTile entrance;

    public RoomTile(int row, int col) {
        this.row = row;
        this.col = col;
        entrance = null;

    }

    public void setEntrance(HallwayTile entrance) {
        this.entrance = entrance;
    }

    public HallwayTile getEntrance() {
        return entrance;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString(){
        return "@";
    }

}
