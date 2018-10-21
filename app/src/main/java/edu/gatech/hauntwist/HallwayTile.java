package edu.gatech.hauntwist;

public class HallwayTile extends MapTile {
    private boolean containsEvent;
    private HallEvent event;
    private boolean hasEvent;

    public HallwayTile(int row, int col) {
        super(row, col);
    }

    public int getRow() {
        return super.getRow();
    }

    public int getCol() {
        return super.getCol();
    }

    public boolean hasEvent() { return hasEvent; }
    public void setHasEvent(boolean b) { hasEvent = b; }

    @Override
    public String toString(){
        return "#";
    }





}
