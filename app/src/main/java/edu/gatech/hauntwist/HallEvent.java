package edu.gatech.hauntwist;
public enum HallEvent {


    private String name;
    private String option0;
    private String option1;
    private String outcome0;
    private String outcome1;
    private int choice;


    public HallEvent(String name, String options0, String option1, String outcome0, String outcome1){
        this.name = name;
        this.optionA = options0;
        this.optionB = option1;
        this.outcomeA = outcome0;
        this.outcomeB = outcome1;
        choice = 0;
    }

    public setChoice(int choice) {
        this.choice = choice;
    }

    public getName() {
        return name;
    }

    public getOption0() {
        return option0;
    }

    public getOption1() {
        return option1;
    }

    public String toString() {
        if (choice == 0){
            return outcome0;
        }
        return outcome1;
    }
}
