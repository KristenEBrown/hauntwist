package edu.gatech.hauntwist;

public abstract class MapTile {
    public MapTile up;
    public MapTile down;
    public MapTile left;
    public MapTile right;

    public MapTile() {
        this(null, null, null, null);
    }

    public MapTile(MapTile up, MapTile down,
                   MapTile left, MapTile right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;

    }

}
