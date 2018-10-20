package edu.gatech.hauntwist;
public enum RoomItem {
    PHOTOGRAPH();

    String name;
    String clue;
    public RoomItem(String name, String clue) {
        this.name = name;
        this.clue = clue;
    }

    public String toString() {
        return "You've picked up a " + this.name + ". " + this.clue;
    }

    public String getName() {
        return this.name;
    }
}
