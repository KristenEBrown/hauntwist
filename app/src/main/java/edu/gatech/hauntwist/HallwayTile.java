package edu.gatech.hauntwist;

public class HallwayTile extends MapTile {
    private boolean containsEvent;
    private HallEvent event;

    public HallwayTile(int row, int col) {
        super(row, col);
    }

    public int getRow() {
        return super.getRow();
    }

    public int getcol() {
        return super.getCol();
    }

    @Override
    public String toString(){
        return "+";
    }





}
