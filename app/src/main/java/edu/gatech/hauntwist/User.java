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

    private static User currentUser;


    public User(MapTile current, String name) {
        this.currentTile = current;
        this.name = name;
        this.items = new ArrayList<RoomItem>();
        this.dir = Direction.N;
        updateTiles(current);
    }

    public static void setCurrentUser(User newUser) {
        currentUser = newUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public MapTile getCurrentTile() {
        return currentTile;
    }


    public void updateTiles(MapTile currentTile) {
        leftTile = tileUpdater(currentTile, "left");
        rightTile = tileUpdater(currentTile, "right");
        forwardTile = tileUpdater(currentTile, "forward");
        backTile = tileUpdater(currentTile, "back");

    }

    public void turnAround() {
        if (dir == Direction.N) {
            this.dir = Direction.S;
        } else if (dir == Direction.S) {
            this.dir = Direction.N;
        } else if (dir == Direction.E) {
            this.dir = Direction.W;
        } else if (dir == Direction.W) {
            this.dir = Direction.E;
        }
    }

    public boolean canGoForward() {
        if (forwardTile != null) {
            return true;
        }
        return false;
    }

    public boolean canGoLeft() {
        return leftTile != null;
    }

    public boolean canGoRight() {
        return rightTile != null;
    }

    public boolean canGoBack() {
        return backTile != null;
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

    public void goBack() {
        if (canGoBack()) {
            this.currentTile = this.backTile;
            updateTiles(currentTile);
        }
    }

    public MapTile tileUpdater(MapTile currentTile, String dir) {
        if (dir == "right") {
            return tileUpdaterHelper(currentTile, getRightRow(), getRightCol());
        } else if (dir == "left") {
            return tileUpdaterHelper(currentTile, getLeftRow(), getLeftCol());
        } else if (dir == "forward") {
            return tileUpdaterHelper(currentTile, getForRow(), getForCol());
        } else if (dir == "back") {
            return tileUpdaterHelper(currentTile, getBackRow(), getBackCol());
        }
        return null;
    }

    private MapTile tileUpdaterHelper(MapTile currentTile, int newRow, int newCol) {
        MapTile[][] tempMap = HouseMap.getMapArray();
        try {
            return tempMap[newRow][newCol];
        } catch (ArrayIndexOutOfBoundsException e) {
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
