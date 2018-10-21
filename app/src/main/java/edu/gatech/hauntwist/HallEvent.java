package edu.gatech.hauntwist;
public enum HallEvent {
    TALKING("","","","","");

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

    @Override
    public String toString() {
        if (choice == 0){
            return outcome0;
        }
        return outcome1;
    }
}
