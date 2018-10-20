package edu.gatech.hauntwist;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class HouseMap {
    private MapTile[][] map;
    private int size;
    private Random rand;
    private List<RoomTile> roomList;
    private List<HallwayManager> hallwayList;

    public HouseMap(){
        this(5);
    }

    public HouseMap(int n) {
        this.size = 2*n;
        map = new MapTile[size][size];
        rand = new Random();
        roomList = new ArrayList<>();
        hallwayList = new ArrayList<>();
        roomSet();
        hallSet();

    }
    //some sort of creation algo

    public void roomSet() {
        int rooms = 0;
        int roomLimit = size + size/2;
        while (rooms < roomLimit) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int r = rand.nextInt(size);
                    if (r == 0 && rooms < roomLimit) {
                        RoomTile room = new RoomTile(i, j);
                        roomList.add(room);
                        map[i][j] = room;
                        rooms++;
                    }
                }
            }
        }
    }

    public void hallSet(){
        HallwayTile h = this.getStart(0);
        int hallways = 1;
        while(hallways < size){
            HallwayManager horzHallway = moveHorizontal(h.getRow(), h.getCol());
            h = getNextOpen(horzHallway);
            hallways++;
            HallwayManager vertHallway = moveVertical(h.getRow(), h.getCol());
            h = getNextOpen(vertHallway);
            hallways++;
        }


    }

    public HallwayTile getStart(int index) {
        int col = roomList.get(index).getCol();
        int row = roomList.get(index).getRow();
        if (col + 1 < size && map[row][col + 1] == null) {
            return new HallwayTile(row, col + 1);
        } else if (col - 1 >= 0 && map[row][col - 1] == null) {
            return new HallwayTile(row, col - 1);
        } else if (row + 1 >= 0 && map[row + 1][col] == null) {
            return new HallwayTile(row + 1, col);
        } else if (row - 1 >= 0 && map[row - 1][col] == null) {
            return new HallwayTile(row - 1, col);
        }
        return getStart(index + 1);
    }

    public HallwayTile getNextOpen(HallwayManager hall){
        int row = hall.getConnector().getRow();
        int col = hall.getConnector().getCol();
        if (col < 0 || col > size - 1
                || row < 0 || row > size - 1
                || map[row][col] != null){
            return hall.getEnd();
        }
        return hall.getConnector();
    }


    public HallwayManager moveHorizontal(int row, int col) {
        int inc = 1;
        HallwayManager hallway = new HallwayManager();
        if (col > (size/2)) {
            inc = -1;
        }
        boolean a = false;
        boolean b = false;
        boolean c = false;
        while (col < size && col >- 1) {
            if (map[row][col] == null) {
                HallwayTile h = new HallwayTile(row, col);
                hallway.add(h);
                map[row][col] = h;
                if (row > 0) {
                    a = check(row - 1, col, h);
                }
                if (row < (size - 1)) {
                    b = check(row + 1, col, h);
                }
                if ((col + inc) < size && (col + inc) > -1) {
                    c = check(row, col + inc, h);
                }
                if (a || b || c) {
                    hallway.setConnector(new HallwayTile(row, (col + inc)));
                    return hallway;
                }
            }
            col = col + inc;
        }
        hallway.setConnector(new HallwayTile(row, col));
        return hallway;
    }

    public boolean check( int row, int col, HallwayTile h) {
        if (map[row][col] instanceof RoomTile) {
            RoomTile r = (RoomTile)map[row][col];
            if (r.getEntrance() == null) {
                r.setEntrance(h);
                return true;
            }
            return false;
        }
        return false;
    }

    public HallwayManager moveVertical(int row, int col) {
        int inc = 1;
        HallwayManager hallway = new HallwayManager();
        if (row > (size/2)) {
            inc = -1;
        }
        boolean a = false;
        boolean b = false;
        boolean c = false;
        while (row < size && row >- 1) {
            if (map[row][col] == null) {
                HallwayTile h = new HallwayTile(row, col);
                hallway.add(h);
                map[row][col] = h;
                if (col > 0) {
                    a = check(row, col - 1, h);
                }
                if (col < (size - 1)) {
                    b =check(row, col + 1, h);
                }
                if ((row + inc) < size && (row + inc) > -1) {
                    c = check(row + inc, col, h);
                }
                if (a || b || c) {
                    hallway.setConnector(new HallwayTile(row + inc, col));
                    return hallway;
                }
            }
            row = row + inc;
        }
        hallway.setConnector(new HallwayTile(row, col));
        return hallway;
    }

    public MapTile[][] getMap() {
        return map;
    }


    // move methods should return the updated row/col value, and store created hallways
    // in hallway objects. should store what one hallway tile points to right and
    // left(what if hallways intersect). should also fix hallway entryway pointers.
    // perhaps a certain place on the map should always have indications to all crossing
    // hallways, and check if adjacent doors have entryways.

    public String toString(){
        String toRet = "";
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (map[i][j] != null) {
                    toRet += String.format("%-3s", map[i][j].toString());
                } else {
                    toRet += String.format("%-3s", "•");
                }
            }
            toRet += "\n";
        }
        return toRet;
    }


}
