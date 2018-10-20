package edu.gatech.hauntwist;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class HouseMap {
    MapTile[][] map;
    int size;
    Random rand;
    List<RoomTile> roomList;
    List<HallwayManager> hallwayList;

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

    public void hallSet() {
        int row = roomList.get(0).getRow();
        int col = roomList.get(0).getCol();
        int connectedRooms = 1;
        while (connectedRooms < size){
            HallwayManager horzHallway = moveHorizontal(row, col);
            //HallwayManager vertHallway = moveVertical(horzHallway.getEnd());

            // update cols. Add hallway when run into a room (save to new
            // hallway object) if doesn't work, delete hallway(stored in
            // hallway manager object.
            // then move on to moving down (either from current or update
            // location, and update rows. if still doesn't work,
            // move to next room in roomList
            // note: roomManager object is useless.
        }
    }

    public HallwayManager moveHorizontal(int row, int col) {
        int inc = 1;
        HallwayManager hallway = new HallwayManager();
        if (col > (size/2)) {
            inc = -1;
        }
        //null pointer exception below is possible needs to be fixed
        while (map[row][col + inc] == null && map[row - 1][col] == null
                && map [row + 1][col] == null&& (col+inc) < size) {
            HallwayTile h = new HallwayTile(row, col + inc);
            map[row][col + inc] = h;
            hallway.add(h);
            col = col +inc;
        }
        //if(col == size);
        return new HallwayManager();
    }

    public HallwayManager moveVertical(int row, int col) {
        int inc = 1;
        HallwayManager hallway = new HallwayManager();
        if (row > (size/2)) {
            inc = -1;
        }
        //null pointer exception possible below. Must be fixed
        while (map[row + inc][col] == null && map[row][col - 1] == null
                && map [row][col + 1] == null) {
            HallwayTile h = new HallwayTile(row, col + inc);
            map[row][col + inc] = h;
            hallway.add(h);
            col = col +inc;
        }

        return new HallwayManager();
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
