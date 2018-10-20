package edu.gatech.hauntwist;

public class RoomTile extends MapTile{
    private boolean containsItem;
    private RoomItem item;
    private HallwayTile entrance;

    public RoomTile(int row, int col) {
        super(row, col);
        entrance = null;

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

    public int getcol() {
        return super.getCol();
    }

    @Override
    public String toString(){
        return "@";
    }

}
