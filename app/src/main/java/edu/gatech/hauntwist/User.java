package edu.gatech.hauntwist;

import java.util.ArrayList;


public class User {


    private MapTile currentTile;
    private MapTile leftTile;
    private MapTile forwardTile;
    private MapTile rightTile;
    private MapTile backTile;

    private Direction dir;

    private String name;

    private ArrayList<RoomItem> items;


    public User(MapTile current, String name) {
        this.currentTile = current;
        this.name = name;
        this.items = new ArrayList<RoomItem>();
        this.dir = Direction.N;
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
        MapTile[][] tempMap = HouseMap.getMap();
        try {
            return null;
            // stubbed out
        } catch (Exception e) {
            return null;
        }
    }

    private int getForCol() {
        if (dir == Direction.N) {
            return this.currentTile.getCol() - 1;
        } else if (dir == Direction.S) {
            return this.currentTile.getCol() + 1;
        } else {
            return this.currentTile.getCol();
        }
    }

    private int getForRow() {
        if (dir == Direction.E) {
            return this.currentTile.getRow() + 1;
        } else if (dir == Direction.W) {
            return this.currentTile.getRow() - 1;
        } else {
            return this.currentTile.getRow();
        }
    }

    private int getBackCol() {
        if (dir == Direction.N) {
            return this.currentTile.getCol() + 1;
        } else if (dir == Direction.S) {
            return this.currentTile.getCol() - 1;
        } else {
            return this.currentTile.getCol();
        }
    }

    private int getBackRow() {
        if (dir == Direction.E) {
            return this.currentTile.getRow() - 1;
        } else if (dir == Direction.W) {
            return this.currentTile.getRow() + 1;
        } else {
            return this.currentTile.getRow();
        }
    }

    private int getRightCol() {
        if (dir == Direction.N) {
            return this.currentTile.getCol() + 1;
        } else if (dir == Direction.S) {
            return this.currentTile.getCol() - 1;
        } else {
            return this.currentTile.getCol();
        }
    }

    private int getRightRow() {
        if (dir == Direction.E) {
            return this.currentTile.getRow() + 1;
        } else if (dir == Direction.W) {
            return this.currentTile.getRow() - 1;
        } else {
            return this.currentTile.getRow();
        }
    }

    private int getLeftCol() {
        if (dir == Direction.N) {
            return this.currentTile.getCol() - 1;
        } else if (dir == Direction.S) {
            return this.currentTile.getCol() + 1;
        } else {
            return this.currentTile.getCol();
        }
    }

    private int getLeftRow() {
        if (dir == Direction.E) {
            return this.currentTile.getRow() - 1;
        } else if (dir == Direction.W) {
            return this.currentTile.getRow() + 1;
        } else {
            return this.currentTile.getRow();
        }
    }


}
