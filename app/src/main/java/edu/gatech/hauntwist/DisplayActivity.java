package edu.gatech.hauntwist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private Button forwardButton;
    private Button leftButton;
    private Button rightButton;
    private Button turnButton;

    private Button option1;
    private Button option2;

    private View textBackground;
    private TextView msgText;

    private ImageView display;

    private int ordinal = 0;

    private User user = User.getCurrentUser();
    private MapTile displayTile = user.getCurrentTile();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        setAttributes();



        String test = "You're at " + displayTile.getRow() + displayTile.getCol()
                + ". You wake up in a dimly lit room. Looking around, " +
                "you see that the room is mostly empty, save for a few " +
                "scattered items. Go forward.";

        msgText.setText(test);

        updateButtons();




    }

    private void setAttributes() {
        forwardButton = findViewById(R.id.forwardBttn);
        leftButton = findViewById(R.id.leftBttn);
        rightButton = findViewById(R.id.rightBttn);
        turnButton = findViewById(R.id.turnBttn);

        option1 = findViewById(R.id.option1Bttn);
        option2 = findViewById(R.id.option2Bttn);
        option1.setVisibility(View.INVISIBLE);
        option2.setVisibility(View.INVISIBLE);

        textBackground = findViewById(R.id.textWrapper);
        msgText = findViewById(R.id.messageText);

        display = findViewById(R.id.displayView);

<<<<<<< HEAD
=======



>>>>>>> 66fc27e81a9ead4a72d4e7360d0d2d22721fcbd5
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forward();
            }});

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left();
            }});

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right();
            }});

        turnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn();
            }});

    }

    public void forward() {
        Log.d("MOVEMENT", "Can go forward: "+ user.canGoForward());
        if (user.canGoForward()) {
            user.goForward();
            update();
        }
    }

    public void left() {
        Log.d("MOVEMENT", "Can go left: "+ user.canGoLeft());
        if (user.canGoLeft()) {
            user.goLeft();
            update();
        }
    }

    public void right() {
        Log.d("MOVEMENT", "Can go right: " + user.canGoLeft());
        if (user.canGoRight()) {
            user.goRight();
            update();
        }
    }

    public void turn() {
        user.turnAround();
        String newMessage = Integer.toString(user.getCurrentTile().getRow()) + Integer.toString(user.getCurrentTile().getCol())
                + " dir: " + user.getDirection();
        msgText.setText(newMessage);
        updateButtons();
    }

    private void update() {
        updateButtons();


        String newMessage = tileInfoCreator();

        if (user.hasItem()) {
            newMessage = user.getItem().toString();
        }

        msgText.setText(newMessage);

        if (user.hasEvent()) {
            final HallEvent event = user.getEvent();
            option1.setVisibility(View.VISIBLE);
            option1.setText(event.getOption0());
            option2.setVisibility(View.VISIBLE);
            option2.setText(event.getOption1());
            newMessage = event.getName();
            msgText.setText(newMessage);

            forwardButton.setEnabled(false);
            leftButton.setEnabled(false);
            rightButton.setEnabled(false);

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processDecision(event,1);
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processDecision(event, 2);
                }
            });
        }

        if (user.getCurrentTile() instanceof RoomTile){
            if (((RoomTile)user.getCurrentTile()).getType() == 0){
                display.setImageResource(R.drawable.room1);
            } else if (((RoomTile)user.getCurrentTile()).getType() == 1){
                display.setImageResource(R.drawable.room2);
            } else if (((RoomTile)user.getCurrentTile()).getType() == 2){
                display.setImageResource(R.drawable.room3);
            }
        } else if (user.getCurrentTile() instanceof HallwayTile) {
            display.setImageResource(R.drawable.hallway1);
        }

    }

    private void processDecision(HallEvent event, int choice) {
        if (choice == 1) {
            msgText.setText(event.getOutcome0());
        } else {
            msgText.setText(event.getOutcome1());
        }

        option1.setVisibility(View.INVISIBLE);
        option2.setVisibility(View.INVISIBLE);
        forwardButton.setEnabled(user.canGoForward());
        leftButton.setEnabled(user.canGoLeft());
        rightButton.setEnabled(user.canGoRight());
    }

    public void updateButtons() {
        forwardButton.setEnabled(user.canGoForward());
        leftButton.setEnabled(user.canGoLeft());
        rightButton.setEnabled(user.canGoRight());
        updateUser();
    }

    public void updateUser() {
        if(User.getCurrentUser().getEvents().size() == 3 && User.getCurrentUser().getItems().size() == 2) {
            msgText.setText("You suddenly start to piece information together. You are the ghost " +
                    "in the house! You must have been murdered, which is why your body is in the hall. " +
                    "Your friends did not acknowledge you and you could not see your reflection in the mirror, " +
                    "because of this. This would explain the text from Tim’s mom as well, you are the one Tim has lost! " +
                    "Thinking of the picture of your friends you realize you must have been murdered during your Fall Break trip. " +
                    "So who killed you and for what reason?");
        }

        if(User.getCurrentUser().getEvents().size() == 5 && User.getCurrentUser().getItems().size() == 5) {
            msgText.setText("All of the clues make sense now! Madeline was in love with you the whole " +
                    "time and must have known that you loved Norris. She tried to kill Norris with " +
                    "cyanide, but accidentally killed you instead! Oh no! In the love letter, " +
                    "Madeline said she wanted to avenge your death, which means she must still be " +
                    "planning to kill Norris. I must warn him before!");
        }

        if(User.getCurrentUser().getEvents().size() == 7 && User.getCurrentUser().getItems().size() == 7) {
            end();
        }

    }

    public void end() {
        msgText.setText("You were, unfortunately, unable to save Norris. Madeline succeeded in her goal, but with a consequence of losing the person she loved.");
        display.setImageResource(R.drawable.over);
        forwardButton.setEnabled(false);
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
        turnButton.setEnabled(false);
        option1.setEnabled(false);
        option2.setEnabled(false);
    }

    public String tileInfoCreator() {
        String retStr = "You are in a ";

        if (user.getCurrentTile() instanceof RoomTile) {
            retStr += "room. ";
        } else {
            retStr += "hallway. ";
        }

        retStr += "You can go ";
        if (user.canGoLeft()) {
            retStr += "to the left ";
        }
        if (user.canGoRight()) {
            retStr += "to the right ";
        }
        if (user.canGoForward()) {
            retStr += "forward. ";
        }

        return retStr;



    }
}
