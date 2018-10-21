package edu.gatech.hauntwist;
public enum RoomItem {
    PHOTOGRAPH("photograph", "You can see you and all of your friends smiling. You remember that this was taken during your trip for Fall Break. " +
            "Oddly enough you can't remember how that trip ended. It must have been a long time ago."),
    PHONE("Tim's cellphone", "You read an unopened message on the screen. It is Tim's mom sending her condolences for his loss. Who could she be talking about?"),
    LOVELETTER("love letter addressed to you from Madeline", "You read that she is hoping to avenge your death. It sounds like she's apologizing for something"),
    DIARY("diary", "You flip to the first page and can tell that it is Norris's diary. He seems to be writing about feeling scared of Madeline. " +
            "Why would he be afraid of her?"),
    PILLBOTTLE("pill bottle", "The bottle contains arsenic! It looks like there's a splash of " +
            "spaghetti sauce on it the side of the bottle. That's odd that something so deadly would be near food."),
    PEN("pen and paper", "You quickly try to write a note warning Norris, but oh no! The pen is out of ink"),
    PILLBOTTLEEMPTY("empty pill bottle", "It is the same bottle as before, but now it is empty! What could Madeline have done with the rest of the arsenic?");


    private String name;
    private String clue;

    RoomItem(String name, String clue) {
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
