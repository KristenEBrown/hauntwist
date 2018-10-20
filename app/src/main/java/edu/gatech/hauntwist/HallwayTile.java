package edu.gatech.hauntwist;

public class HallwayTile extends MapTile {
    private boolean containsEvent;
    private HallEvent event;
    private int row;
    private int col;

    public HallwayTile(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getcol() {
        return col;
    }

    @Override
    public String toString(){
        return "+";
    }





}
