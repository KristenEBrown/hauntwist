package edu.gatech.hauntwist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class User {

    private List<RoomItem> listItem;

    private MapTile currentTile;
    private MapTile leftTile;
    private MapTile forwardTile;
    private MapTile rightTile;
    private MapTile backTile;

    private Direction dir;

    private String name;

    private Random rand;

    private ArrayList<RoomItem> itemList;
    private ArrayList<HallEvent> eventList;

    private static User currentUser;


    public User(MapTile current, String name) {
        this.currentTile = current;
        this.name = name;
        this.itemList = new ArrayList<RoomItem>();
        this.dir = Direction.N;
        itemList = new ArrayList<>();
        eventList = new ArrayList<>();
        rand = new Random();
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

    public Direction getDirection() {
        return this.dir;
    }

    public boolean hasItem() {
        if (!(currentTile instanceof RoomTile)) {
            return false;
        }
        return ((RoomTile)currentTile).hasItem();
    }

    public RoomItem getItem() {
        RoomItem[] vals = RoomItem.values();
        RoomItem nextItem = vals[itemList.size()];
        itemList.add(nextItem);
        ((RoomTile)currentTile).setHasItem(false);
        return nextItem;
    }

    public boolean hasEvent() {
        if (!(currentTile instanceof HallwayTile)) {
            return false;
        }
        return ((HallwayTile)currentTile).hasEvent();
    }

    public HallEvent getEvent() {
        HallEvent[] vals = HallEvent.values();
        HallEvent nextEvent = vals[eventList.size()];
        eventList.add(nextEvent);
        ((HallwayTile)currentTile).setHasEvent(false);
        return nextEvent;
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
            this.updateTiles(currentTile);
        } else if (dir == Direction.S) {
            this.dir = Direction.N;
            this.updateTiles(currentTile);
        } else if (dir == Direction.E) {
            this.dir = Direction.W;
            this.updateTiles(currentTile);
        } else if (dir == Direction.W) {
            this.dir = Direction.E;
            this.updateTiles(currentTile);
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
        if (dir == Direction.E) {
            return this.currentTile.getCol() + 1;
        } else if (dir == Direction.W) {
            return this.currentTile.getCol() - 1;
        } else {
            return this.currentTile.getCol();
        }
    }

    private int getForRow() {
        if (dir == Direction.N) {
            return this.currentTile.getRow() - 1;
        } else if (dir == Direction.S) {
            return this.currentTile.getRow() + 1;
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
