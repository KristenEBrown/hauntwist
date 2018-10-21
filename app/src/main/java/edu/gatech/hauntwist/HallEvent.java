package edu.gatech.hauntwist;
public enum HallEvent {
    SEEPEOPLE("You can see people down the hall", "go see who they are", "quietly hide from them", "You run towards the people only to see it is your friends." +
            "You hear Luke say something about Fall Break and realize they're still here for Fall Break." , "You stay quiet and the walk by. The people don't seem" +
            "to notice you, but you can see that they are your friends. You hear Luke say something about Fall Break and realize they're still here for Fall Break."),
    MIRROR("You walk past a mirror hung on the wall.", "stop to look at yourself", "keep walking", "You walk towards the mirror, but you can't seem to see anything." +
            "It must be pretty dirty if you can't even see your reflection.", "You walk past the mirror and briefly notice you can't see your reflection." +
            "You must have just been walking too quickly to notice"),
    DEADBODY("You walk past a dead body.", "inspect the body", "step away from the body", "You come closer to the body and after closer inspection you " +
            "recognize the face. It is you! It's your body on the ground!", "You take a step back and step on something. It's a necklace. It looks like the necklace " +
            "that you wear everyday. It looks like it is broken! You look back over at the body and notice it wearing all of your clothes. It must be you!"),
    WHISPERING("You can hear Tom and Luke whispering", "listen to what they are saying","walk away", "You stay quiet and can hear the two's conversation." +
            "They seem to be talking about Madeline falling in love with me. Poor Madeline. You were always in love with Norris.", "As you try to walk away you hear" +
            " Luke shout to Tyler 'Madeline was in love with her dude!'. You can tell they are referencing you. Poor Madeline. You always loved Norris"),
    CRYING("You can hear a girl crying.", "stay to see if she is alright", "focus on the goal at hand", "You stay and realize it is Madeline crying. " +
            "She keeps apologizing for something. What is Madeline so guilty about?", "You continue walking and see tissues leading out of Madeline's" +
            " room. Madeline seems to be pretty upset about your death, almost too upset."),
    FOOTSTEPS("You hear footsteps running out of Madeline's room", "chase after her", "try to find Norris", "You chase after Madeline, but even with your" +
            " ability to move through walls you lose her", "You start to look for Norris, but after fifteen minutes you have yet to find him."),
    SCREAM("You can hear screams.", "hurry to see what's happening", "choose to ignore them", "You rush to the kitchen, where the screams seem to be coming from," +
            "  but by the time you get there it is too late. Madeline has already killed Norris by poisoning his food.", "You ignore the screams trying to pretend" +
            " that everything is fine. You continue walking around until you have reached the kitchen, only to see Madeline standing over Norris. " +
            "She has poisoned his food and has won this twisted story.");



    private String name;
    private String option0;
    private String option1;
    private String outcome0;
    private String outcome1;
    private int choice;


    HallEvent(String name, String options0, String option1, String outcome0, String outcome1){
        this.name = name;
        this.option0 = options0;
        this.option1 = option1;
        this.outcome0 = outcome0;
        this.outcome1 = outcome1;
        choice = 0;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public String getOption0() {
        return option0;
    }

    public String getOption1() {
        return option1;
    }

    public String getOutcome0() {
        return outcome0;
    }

    public String getOutcome1() {
        return outcome1;
    }

    @Override
    public String toString() {
        if (choice == 0){
            return outcome0;
        }
        return outcome1;
    }
}
