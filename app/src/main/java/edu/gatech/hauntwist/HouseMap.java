package edu.gatech.hauntwist;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class HouseMap {
    MapTile[][] map;
    int size;
    Random rand;
    List<RoomTile> roomList;

    public HouseMap(){
        this(10);
    }

    public HouseMap(int n) {
        map = new MapTile[n][n];
        this.size = n;
        rand = new Random();
        roomList = new ArrayList<>();
        roomSet();

    }
    //some sort of creation algo

    public void roomSet() {
        int rooms = 0;
        while (rooms < size) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int r = rand.nextInt(size);
                    if (r == 0 && rooms < size) {
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
        if (moveUp(row, col)) {
            col--;
        } else if (moveDown(row, col)) {
            col++;
        } else if (moveLeft(row, col)) {
            row--;
        } else{
            row++;
        }
        do {
            map[row][col] = new HallwayTile();
            if()
        } while(map[row][col] ;

    }

    public HallwayTile moveHorizontal(int row, int col) {
        int inc = 1;
        if (col > (size/2)) {
            inc = -1;
        }
        while (map[row][col + inc] == null && map[row - 1][col] == null
                && map [row + 1][col] == null) {
            map[row][col + inc] = new HallwayTile(row, col + inc);
            col = col +inc;
        }

        return (HallwayTile)map[row][col];
    }

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
