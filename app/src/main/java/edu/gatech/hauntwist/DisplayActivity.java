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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        setAttributes();

        String test = "You wake up in a dimly lit room. Looking around, " +
                "you see that the room is mostly empty, save for a few " +
                "scattered items.";

        msgText.setText(test);




    }

    private void setAttributes() {
        forwardButton = findViewById(R.id.forwardBttn);
        leftButton = findViewById(R.id.leftBttn);
        rightButton = findViewById(R.id.rightBttn);

        textBackground = findViewById(R.id.textWrapper);
        msgText = findViewById(R.id.messageText);

        display = findViewById(R.id.displayView);
    }
}
