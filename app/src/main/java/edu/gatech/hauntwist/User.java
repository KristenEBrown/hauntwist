package edu.gatech.hauntwist;

import java.util.ArrayList;
import java.util.Map;

public class User {


    private MapTile currentTile;
    private MapTile leftTile;
    private MapTile forwardTile;
    private MapTile rightTile;
    private MapTile backTile;

    private String name;

    private ArrayList<RoomItem> items;


    public User(MapTile current, String name) {
        this.currentTile = current;
        this.name = name;
        this.items = new ArrayList<RoomItem>();
    }


    public void updateTiles(MapTile currentTile) {
        leftTile = tileUpdater(currentTile, "left");
        rightTile = tileUpdater(currentTile, "right");
        forwardTile = tileUpdater(currentTile, "forward");
        backTile = tileUpdater(currentTile, "back");

    }

    public boolean canGoForward() {
        // implement checking if can go forward
        return false;
    }

    public boolean canGoLeft() {
        // implement checking if can go forward
        return false;
    }

    public boolean canGoRight() {
        // implement checking if can go forward
        return false;
    }

    public void goForward() {
        if (canGoForward()) {
            this.currentTile = this.forwardTile;
            updateTiles(currentTile);
        }
    }

    public void goLeft() {
        if (canGoLeft()) {
            this.currentTile = this.leftTile;
            updateTiles(currentTile);
        }
    }

    public void goRight() {
        if (canGoRight()) {
            this.currentTile = this.rightTile;
            updateTiles(currentTile);
        }
    }

    public MapTile tileUpdater(MapTile currentTile, String dir) {
        if (dir == "right") {
            tileUpdaterHelper(currentTile, currentTile.getRow(), currentTile.getCol() + 1);
        }
        return null;
    }

    private MapTile tileUpdaterHelper(MapTile currentTile, int newRow, int newCol) {
        try {
            return null;
            // stubbed out
        } catch (Exception e) {
            return null;
        }
    }


}
