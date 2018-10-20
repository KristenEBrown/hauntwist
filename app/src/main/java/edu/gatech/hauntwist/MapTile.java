package edu.gatech.hauntwist;

public abstract class MapTile {
    MapTile up;
    MapTile down;
    MapTile left;
    MapTile right;

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
