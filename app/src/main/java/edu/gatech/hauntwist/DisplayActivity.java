package edu.gatech.hauntwist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private Button forwardButton;
    private Button leftButton;
    private Button rightButton;

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




    }

    private void setAttributes() {
        forwardButton = findViewById(R.id.forwardBttn);
        leftButton = findViewById(R.id.leftBttn);
        rightButton = findViewById(R.id.rightBttn);

        textBackground = findViewById(R.id.textWrapper);
        msgText = findViewById(R.id.messageText);

        display = findViewById(R.id.displayView);

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
    }

    public void forward() {
        if (user.canGoForward()) {
            user.goForward();
            String newMessage = Integer.toString(user.getCurrentTile().getRow()) + Integer.toString(user.getCurrentTile().getCol());
            msgText.setText(newMessage);
        }
    }

    public void left() {
        if (user.canGoLeft()) {
            user.goLeft();
            String newMessage = Integer.toString(user.getCurrentTile().getRow()) + Integer.toString(user.getCurrentTile().getCol());
            msgText.setText(newMessage);        }
    }

    public void right() {
        if (user.canGoRight()) {
            user.goRight();
            String newMessage = Integer.toString(user.getCurrentTile().getRow()) + Integer.toString(user.getCurrentTile().getCol());
            msgText.setText(newMessage);        }
    }
}
